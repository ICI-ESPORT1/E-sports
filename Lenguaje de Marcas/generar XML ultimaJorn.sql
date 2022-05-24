create or replace type equipo_tip as object ("@cod_Equipo" number(3),
                                                nombre varchar2(20),
                                                resultado varchar2(5));
                            
create or replace type eqlist_tip as table of equipo_tip;

create or replace type partido_ti as object ("@id_partido" number(3),
                                                "@turno" varchar2(10),
                                                equipos eqlist_tip);
                                                
create or replace type partlist_ti as table of partido_ti;

create or replace type jornada_ti as object ("@num_jornada" number(3),
                                                partidos partlist_ti);
                                        

DECLARE
    contexto dbms_xmlgen.ctxHandle;
    resultado clob;
BEGIN

    contexto :=dbms_xmlgen.newContext
    ('select jornada_ti(jornada.num_jornada,
                           cast(MULTISET
                                (select partido_ti(partido.id_partido,partido.turno,
                                cast (MULTISET
                                     (select equipo.cod_equipo,equipo.nombre, resultado.resultado
                                     from equipo, resultado
                                     where equipo.cod_equipo=resultado.id_equipo and resultado.id_partido = partido.num_jornada)
                                     as eqlist_tip))
                                from partido
                                where partido.num_jornada = jornada.num_jornada)
                                as partlist_ti)
                            )
            as jornada
            from jornada
            where num_jornada = (select MAX(a.num_jornada) from jornada a)
            ');
            
            resultado := dbms_xmlgen.getxml(contexto);
            delete from temp_clob_tab;
            insert into temp_clob_tab values (resultado);
            
            dbms_xmlgen.closeContext(contexto);
                                     
END;
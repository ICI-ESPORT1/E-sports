create or replace procedure generarUltimaJorn 
is

    contexto dbms_xmlgen.ctxHandle;
    resultado clob;
begin
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
    insert into fichero (resultado,fecha) values (resultado,sysdate+7);
    dbms_xmlgen.closeContext(contexto);
end generarUltimaJorn; 


begin
generarUltimaJorn();
end;

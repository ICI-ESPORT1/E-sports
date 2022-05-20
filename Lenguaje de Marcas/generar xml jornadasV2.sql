/*OBTENER ESTRUCTURA XML CALENDARIO*/
drop type t_equipo FORCE;
drop type type_equiList FORCE;
drop type type_partido FORCE;
drop type type_partidoList FORCE;
drop type type_jorn FORCE;


create or replace type t_equipo as object (   nombre varchar2(20),
                                              resultado varchar2(5));
                                               
create or replace type type_equiList as table of t_equipo;

create or replace type t_partido as object ("@id_partido" number(3),
                                               equipos type_equiList);
                                               
create or replace type type_partidoList as table of t_partido;   
 
create or replace type type_jorn as object ("@num_jornada" number(3),
                                            lista_partidos type_partidoList);

                                         
                                            

declare
    contexto dbms_xmlgen.ctxHandle;
    resultado clob;
begin
    contexto :=dbms_xmlgen.newContext
   ('select type_jorn(jornada.num_jornada,
                       cast(MULTISET
                           (select partido.id_partido,
                            cast(MULTISET
                                (select equipo.nombre, resultado.resultado 
                                 from equipo, resultado
                                 where equipo.cod_equipo = resultado.id_equipo and resultado.id_partido = partido.num_jornada)
                                 as type_equiList)
                            from partido
                            where partido.num_jornada = jornada.num_jornada) 
                            as type_partidoList)
                        )
        as jornada            
        from jornada
        order by jornada.num_jornada
        '); 
        DBMS_XMLGEN.setRowSetTag(contexto, 'RESUMEN_RESULTADOS');
        DBMS_XMLGEN.setRowTag(contexto,'JORNADAS');
        dbms_xmlgen.setnullhandling(contexto, 2);

    
    resultado := dbms_xmlgen.getxml(contexto);
    insert into fichero (resultado,fecha) values (resultado,sysdate+2);
    dbms_xmlgen.closeContext(contexto);
end;


select to_char(sysdate+2,'YYYY-MM-DD"T"HH24:MM:SS') expiration_date FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAMP - INTERVAL '-7' day) FROM DUAL;

drop table fichero;
create table fichero(
resultado clob,
fecha date
);

select * from fichero;
delete fichero where resultado is not null;
DESC FICHERO;
SELECT * FROM EQUIPO;
SELECT * FROM RESULTADO;
SELECT * FROM JORNADA;


desc equipo;

select  type_jorn(jornada.num_jornada,
                       cast(MULTISET
                           (select partido.id_partido,
                            cast(MULTISET
                                (select equipo.nombre, resultado.resultado 
                                 from equipo, resultado
                                 where equipo.cod_equipo = resultado.id_equipo and resultado.id_partido = partido.num_jornada)
                                 as type_equiList)
                            from partido
                            where partido.num_jornada = jornada.num_jornada) 
                            as type_partidoList)
                        )
        as jornada            
        from jornada
        order by jornada.num_jornada;
                   
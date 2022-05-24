create or replace procedure generarXmlPartidos 
is

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
    insert into fichero (resultado,fecha,nombre) values (resultado,sysdate+7,'JORNADAS');
    dbms_xmlgen.closeContext(contexto);
end;


begin
generarXmlPartidos();
end;
/*
RESULTADO                                                                        FECHA   
-------------------------------------------------------------------------------- --------
<?xml version="1.0"?>                                                            22/05/22
<RESUMEN_RESULTADOS>                                                                     
 <JORNADAS>                                                                              
  <JORNADA num_jornada="1                                                                
*/
set SERVEROUTPUT ON




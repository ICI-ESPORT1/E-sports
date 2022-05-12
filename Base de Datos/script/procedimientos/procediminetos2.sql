/* PROCEDIMIENTOS RESULTADOS */

/* PROCEDIMIENTO PARA VISUALIZAR TODOS LOS RESULTADOS DE TODOS LOS EQUIPOS */
create or replace procedure VisualizarResultados
(
c_resultado out tcursor
)
as
v_codError number;
v_mensError varchar2(300);
e_noHayDatos exception;
pragma exception_init(e_noHayDatos, -20010);
begin

open c_resultado for
select a.equipo,  NVL(count(a.resultado),0) as perdido,  NVL(count(b.resultado),0) as ganado
from resultados_temporada_ganados a ,resultados_temporada_perdidos b
where a.resultado='G'
group by a.equipo
INTERSECT
select b.equipo,  NVL(count(b.resultado),0) as ganado,  NVL(count(a.resultado),0) as perdido
from resultados_temporada_perdidos b,resultados_temporada_ganados a 
where b.resultado='P'
group by b.equipo;


select NVL(count(a.resultado),0) as ganado
from resultados_temporada_ganados a
where 
a.resultado='G'
and a.partido
group by b.equipo;

select a.equipo,  NVL(count(a.resultado),0) as perdido
from resultados_temporada_ganados a 
where a.resultado='G'
group by a.equipo

EXCEPTION

when no_data_found then
    raise e_noHayDatos;

when e_noHayDatos then
    v_codError := sqlcode;
    v_mensError := 'El equipo no existe';

dbms_output.put_line('ERROR: '||v_codError ||' '|| v_mensError);
END;


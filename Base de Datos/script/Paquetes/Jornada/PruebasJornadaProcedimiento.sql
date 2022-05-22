/*PROCEDIMINETOS ANONIMOS PARA PROCEDIMIENTOS DE JORNADA*/
desc jornada;
select * from jornada;
select * from calendario;
/*Procedimiento nuevo_jornada*/
--Llamamos al procedimiento nuevo_jornada con un num_semana que ya existe
begin
gestionarJornada.nuevo_jornada(sysdate,'2',2);
end;

/*
Error que empieza en la línea: 7 del comando :
begin
gestionarJornada.nuevo_jornada(sysdate,'2',2);
end;
Informe de error -
ORA-20050: Error Oracle -2291,ORA-02291: restricción de integridad (SYSTEM.JOR_NUM_FK) violada - clave principal no encontrada
ORA-06512: en "SYSTEM.GESTIONARJORNADA", línea 51
ORA-06512: en línea 2
*/


--Llamamos al procedimiento nuevo_jornada sin el dato id_calendario
begin
gestionarJornada.nuevo_jornada(sysdate,'2');
end;

/*
Error que empieza en la línea: 24 del comando :
begin
gestionarJornada.nuevo_jornada(sysdate,'2');
end;
Informe de error -
ORA-06550: línea 2, columna 1:
PLS-00306: número o tipos de argumentos erróneos al llamar a 'NUEVO_JORNADA'
ORA-06550: línea 2, columna 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
*/

--Llamamos al procedimiento nuevo_jornada 
begin
gestionarJornada.nuevo_jornada(sysdate,'5',1);
end;

/*Procedimiento PL/SQL terminado correctamente.*/


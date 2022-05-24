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
Error que empieza en la l�nea: 7 del comando :
begin
gestionarJornada.nuevo_jornada(sysdate,'2',2);
end;
Informe de error -
ORA-20050: Error Oracle -2291,ORA-02291: restricci�n de integridad (SYSTEM.JOR_NUM_FK) violada - clave principal no encontrada
ORA-06512: en "SYSTEM.GESTIONARJORNADA", l�nea 51
ORA-06512: en l�nea 2
*/


--Llamamos al procedimiento nuevo_jornada sin el dato id_calendario
begin
gestionarJornada.nuevo_jornada(sysdate,'2');
end;

/*
Error que empieza en la l�nea: 24 del comando :
begin
gestionarJornada.nuevo_jornada(sysdate,'2');
end;
Informe de error -
ORA-06550: l�nea 2, columna 1:
PLS-00306: n�mero o tipos de argumentos err�neos al llamar a 'NUEVO_JORNADA'
ORA-06550: l�nea 2, columna 1:
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


/*PROCEDIMINETOS ANONIMOS ASISTENTE*/

/*Procedimiento nuevo_asistente*/
--Llamamos al procedimiento nuevo_asistente con un DNI ya insertado
begin
gestionarAsistente.nuevo_asistente('30252486B','Iker','123123123','c',2000);
end;

/*
Error que empieza en la línea: 1 del comando :
begin
gestionarAsistente.nuevo_asistente('30252486B','Iker','123123123','c',2000);
end;
Informe de error -
ORA-20023: Error Oracle -1,ORA-00001: restricción única (EQDAW02.ASIS_DNI_UN) violada
ORA-06512: en "EQDAW02.GESTIONARASISTENTE", línea 71
ORA-06512: en línea 2
*/


--Llamamos al procedimiento nuevo_asistente sin el dato sueldo
begin
gestionarAsistente.nuevo_asistente('30252486B','Iker','123123123','c');
end;

/*
Error que empieza en la línea: 16 del comando :
begin
gestionarAsistente.nuevo_asistente('30252486B','Iker','123123123','c');
end;
Informe de error -
ORA-06550: línea 2, columna 1:
PLS-00306: número o tipos de argumentos erróneos al llamar a 'NUEVO_ASISTENTE'
ORA-06550: línea 2, columna 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
*/

--Llamamos al procedimiento nuevo_asistente 
begin
gestionarAsistente.nuevo_asistente('30152486B','Iker','123125123','c',2000);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/

/*Procedimiento cambio_equipo_asistente*/
--LLamamos al procedimineto cambio_equipo_asistente con un id_asistente que no existe
begin
gestionarAsistente.cambio_equipo_asistente(11,2);
end;

/*
Error que empieza en la línea: 43 del comando :
begin
gestionarAsistente.cambio_equipo_asistente(11,2);
end;
Informe de error -
ORA-20026: Error Oracle 1,El asistente no existe
ORA-06512: en "EQDAW02.GESTIONARASISTENTE", línea 111
ORA-06512: en línea 2
*/

--LLamamos al procedimineto cambio_equipo_asistente con un cod_equipo que no existe
begin
gestionarAsistente.cambio_equipo_asistente(1,5);
end;
/*
Error que empieza en la línea: 59 del comando :
begin
gestionarAsistente.cambio_equipo_asistente(1,5);
end;
Informe de error -
ORA-20025: Error Oracle 1,El equipo no existe
ORA-06512: en "EQDAW02.GESTIONARASISTENTE", línea 106
ORA-06512: en línea 2
*/

--Llamamos al procedimiento cambio_equipo_asistente 
begin
gestionarAsistente.cambio_equipo_asistente(1,3);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/


/*Procedimiento borrar_asistente*/

--LLamamos al procedimineto borrar_asistente con un dni que no existe
begin
gestionarAsistente.borrar_asistente('12312312T');
end;
/*
Error que empieza en la línea: 76 del comando :
begin
gestionarAsistente.borrar_asistente(11);
end;
Informe de error -
ORA-20028: Error Oracle 1,El asistente no existe
ORA-06512: en "EQDAW02.GESTIONARASISTENTE", línea 141
ORA-06512: en línea 2
*/

--LLamamos al procedimineto borrar_asistente 
begin
gestionarAsistente.borrar_asistente('12345678H');
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/
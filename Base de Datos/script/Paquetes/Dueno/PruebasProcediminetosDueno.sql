/*PROCEDIMINETOS ANONIMOS DUENO*/

/*Procedimiento nuevo_dueno*/
--Llamamos al procedimiento nuevo_dueno con un DNI ya insertado
begin
gestionarDueno.nuevo_dueno('76025134Z','Iker','123123123','c',1);
end;

/*
Error que empieza en la línea: 5 del comando :
begin
gestionarDueno.nuevo_dueno('76025134Z','Iker','123123123','c',1);
end;
Informe de error -
ORA-20032: Error Oracle -1,ORA-00001: restricción única (EQDAW02.DUE_DNI_UN) violada
ORA-06512: en "EQDAW02.GESTIONARDUENO", línea 75
ORA-06512: en línea 2
*/


--Llamamos al procedimiento nuevo_dueno sin el dato id_equipo
begin
gestionarDueno.nuevo_dueno('30252486B','Iker','123123123','c');
end;

/*
Error que empieza en la línea: 22 del comando :
begin
gestionarDueno.nuevo_dueno('30252486B','Iker','123123123','c');
end;
Informe de error -
ORA-06550: línea 2, columna 1:
PLS-00306: número o tipos de argumentos erróneos al llamar a 'NUEVO_DUENO'
ORA-06550: línea 2, columna 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
*/

--Llamamos al procedimiento nuevo_dueno 
begin
gestionarDueno.nuevo_dueno('30152486B','Iker','123125123','c',1);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/

/*Procedimiento cambio_equipo_asistente*/
--LLamamos al procedimineto cambio_equipo_dueno con un id_dueno que no existe
begin
gestionarDueno.cambio_equipo_dueno(11,2);
end;

/*
Error que empieza en la línea: 51 del comando :
begin
gestionarDueno.cambio_equipo_dueno(11,2);
end;
Informe de error -
ORA-20034: Error Oracle 1,El dueño no existe
ORA-06512: en "EQDAW02.GESTIONARDUENO", línea 112
ORA-06512: en línea 2
*/

--LLamamos al procedimineto cambio_equipo_dueno con un cod_equipo que no existe
begin
gestionarDueno.cambio_equipo_dueno(1,5);
end;
/*
Error que empieza en la línea: 67 del comando :
begin
gestionarDueno.cambio_equipo_dueno(1,5);
end;
Informe de error -
ORA-20034: Error Oracle 1,El dueño no existe
ORA-06512: en "EQDAW02.GESTIONARDUENO", línea 112
ORA-06512: en línea 2

*/

--Llamamos al procedimiento cambio_equipo_dueno 
begin
gestionarDueno.cambio_equipo_dueno(4,4);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/


/*Procedimiento borrar_dueno*/

--LLamamos al procedimineto borrar_dueno con un id_dueno que no existe
begin
gestionarDueno.borrar_dueno(11);
end;
/*
Error que empieza en la línea: 94 del comando :
begin
gestionarDueno.borrar_dueno(11);
end;
Informe de error -
ORA-20034: Error Oracle 1,El dueño no existe
ORA-06512: en "EQDAW02.GESTIONARDUENO", línea 143
ORA-06512: en línea 2
*/

--LLamamos al procedimineto borrar_dueno 
begin
gestionarDueno.borrar_dueno(4);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/
/*PROCEDIMINETOS ANONIMOS ENTRENADOR*/

/*Procedimiento nuevo_asistente*/
--Llamamos al procedimiento nuevo_entrenador con un DNI ya insertado
begin
gestionarEntrenadores.nuevo_entrenador('30252486B','Iker','123123123','c',1,2000);
end;

/*
Error que empieza en la línea: 5 del comando :
begin
gestionarEntrenadores.nuevo_entrenador('30252486B','Iker','123123123','c',1,2000);
end;
Informe de error -
ORA-20037: Error Oracle -1,ORA-00001: restricción única (SYSTEM.ENTR_DNI_UN) violada
ORA-06512: en "SYSTEM.GESTIONARENTRENADORES", línea 74
ORA-06512: en línea 2
*/


--Llamamos al procedimiento nuevo_asistente sin el dato sueldo
begin
gestionarEntrenadores.nuevo_entrenador('30252486B','Iker','123123123','c',1);
end;

/*
Error que empieza en la línea: 22 del comando :
begin
gestionarEntrenadores.nuevo_entrenador('30252486B','Iker','123123123','c',1);
end;
Informe de error -
ORA-06550: línea 2, columna 1:
PLS-00306: número o tipos de argumentos erróneos al llamar a 'NUEVO_ENTRENADOR'
ORA-06550: línea 2, columna 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
*/

--Llamamos al procedimiento nuevo_asistente 
begin
gestionarEntrenadores.nuevo_entrenador('30152486B','Iker','123125123','c',1,12000);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/
select * from entrenador;
/*Procedimiento cambio_equipo_asistente*/
--LLamamos al procedimineto cambio_equipo_asistente con un id_asistente que no existe
begin
gestionarEntrenadores.cambio_equipo_entrenador(22,2);
end;

/*
Error que empieza en la línea: 51 del comando :
begin
gestionarEntrenadores.cambio_equipo_entrenador(22,2);
end;
Informe de error -
ORA-20038: Error Oracle 1,El entrenador no existe
ORA-06512: en "SYSTEM.GESTIONARENTRENADORES", línea 106
ORA-06512: en línea 2
*/

--LLamamos al procedimineto cambio_equipo_asistente con un cod_equipo que no existe
begin
gestionarEntrenadores.cambio_equipo_entrenador(1,5);
end;
/*
Error que empieza en la línea: 67 del comando :
begin
gestionarEntrenadores.cambio_equipo_entrenador(1,5);
end;
Informe de error -
ORA-20039: Error Oracle 1,El equipo no existe
ORA-06512: en "SYSTEM.GESTIONARENTRENADORES", línea 111
ORA-06512: en línea 2
*/

--Llamamos al procedimiento cambio_equipo_asistente 
begin
gestionarEntrenadores.cambio_equipo_entrenador(1,3);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/


/*Procedimiento borrar_asistente*/

--LLamamos al procedimineto borrar_asistente con un dni que no existe
begin
gestionarEntrenadores.borrar_entrenador('12312312H');
end;
/*
Error que empieza en la línea: 93 del comando :
begin
gestionarEntrenadores.borrar_entrenador(11);
end;
Informe de error -
ORA-20041: Error Oracle 1,El entrenador no existe
ORA-06512: en "SYSTEM.GESTIONARENTRENADORES", línea 143
ORA-06512: en línea 2
*/

--LLamamos al procedimineto borrar_asistente 
begin
gestionarEntrenadores.borrar_entrenador('12345678H');
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/
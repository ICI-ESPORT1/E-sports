/*PROCEDIMINETOS ANONIMOS JUGADOR*/
desc jugador;
/*Procedimiento nuevo_jugador*/
--Llamamos al procedimiento nuevo_jugador con un DNI ya insertado
begin
gestionarJugadores.nuevo_jugador('30252486B','Iker','123123123','c',1,'iker',2000,1);
end;

/*
Error que empieza en la línea: 5 del comando :
begin
gestionarJugadores.nuevo_jugador('30252486B','Iker','123123123','c',1,'iker',2000,1);
end;
Informe de error -
ORA-20044: Error Oracle -1,ORA-00001: restricción única (SYSTEM.JUG_DNI_UN) violada
ORA-06512: en "SYSTEM.GESTIONARJUGADORES", línea 78
ORA-06512: en línea 2
*/

--Llamamos al procedimiento nuevo_jugador sin el dato sueldo
begin
gestionarJugadores.nuevo_jugador('30252486B','Iker','123123123','c',1,'iker',1);
end;

/*
Error que empieza en la línea: 21 del comando :
begin
gestionarJugadores.nuevo_jugador('30252486B','Iker','123123123','c',1,'iker',1);
end;
Informe de error -
ORA-06550: línea 2, columna 1:
PLS-00306: número o tipos de argumentos erróneos al llamar a 'NUEVO_JUGADOR'
ORA-06550: línea 2, columna 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
*/

--Llamamos al procedimiento nuevo_jugador 
begin
gestionarJugadores.nuevo_jugador('30252486B','Iker','123123123','c',1,'iker',2000,1);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/
select * from jugador;
/*Procedimiento cambio_equipo_jugador*/
--LLamamos al procedimineto cambio_equipo_jugador con un id_jugador que no existe
begin
gestionarJugadores.cambio_equipo_jugador(23,2);
end;

/*
Error que empieza en la línea: 50 del comando :
begin
gestionarJugadores.cambio_equipo_jugador(23,2);
end;
Informe de error -
ORA-20045: Error Oracle 1,El jugador no existe
ORA-06512: en "SYSTEM.GESTIONARJUGADORES", línea 110
ORA-06512: en línea 2
*/

--LLamamos al procedimineto cambio_equipo_jugador con un cod_equipo que no existe
begin
gestionarJugadores.cambio_equipo_jugador(1,5);
end;
/*
Error que empieza en la línea: 66 del comando :
begin
gestionarJugadores.cambio_equipo_jugador(1,5);
end;
Informe de error -
ORA-20045: Error Oracle 1,El equipo no existe
ORA-06512: en "SYSTEM.GESTIONARJUGADORES", línea 115
ORA-06512: en línea 2
*/

--Llamamos al procedimiento cambio_equipo_jugador 
begin
gestionarJugadores.cambio_equipo_jugador(1,3);
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/


/*Procedimiento borrar_jugador*/
select * from jugador;
--LLamamos al procedimineto borrar_jugador con un dni que no existe
begin
gestionarJugadores.borrar_jugador('12312312T');
end;
/*
Error que empieza en la línea: 92 del comando :
begin
gestionarJugadores.borrar_jugador(22);
end;
Informe de error -
ORA-20045: Error Oracle 1,El jugador no existe
ORA-06512: en "SYSTEM.GESTIONARJUGADORES", línea 146
ORA-06512: en línea 2
*/

--LLamamos al procedimineto borrar_jugador 
begin
gestionarJugadores.borrar_jugador('58016989H');
end;
/*
Procedimiento PL/SQL terminado correctamente.
*/
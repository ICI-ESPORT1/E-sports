/*PRUEBAS PROCEDIMIENTO NUEVO-EQUIPO*/
/*PRUEBA CORRECTA*/
begin
gestionarEquipos.nuevo_equipo('Equipo1','Español',to_date('01/01/20','DD/MM/YY'), 123098456,'Mail@mail.com','tiene',2);
end;
/*
Procedimiento PL/SQL terminado correctamente.


COD_EQUIPO NOMBRE               NACIONALIDAD                                       FECHA_CR   TELEFONO MAIL                                                                                                                                                   ESCUDO                                                                                                                                                 ID_ASISTENTE
---------- -------------------- -------------------------------------------------- -------- ---------- ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------
         1 force                espanola                                           01/01/22  654987321 force@gmail.com                                                                                                                                        tiene                                                                                                                                                             2
         2 alliance             francesa                                           23/04/22  698745125 alliance@gmail.com                                                                                                                                     no_tiene                                                                                                                                                          2
         3 stacks               inglesa                                            14/03/21  632598145 stacks@gmail.com                                                                                                                                       tiene                                                                                                                                                              
         4 players              alemana                                            01/04/20  648211557 players@gmail.com                                                                                                                                      tiene                                                                                                                                                             3
         6 alliadsgance         francesa                                           23/04/22     695125 alnce@gmail.com                                                                                                                                        no_tiene                                                                                                                                                          2
         7 allifaadsgance       francesa                                           23/04/22    6925125 alnfasce@gmail.com                                                                                                                                     no_tiene                                                                                                                                                          2
         8 Equipo1              Español                                            01/01/20  123098456 Mail@mail.com                                                                                                                                          tiene                                                                                                                                                             2

7 filas seleccionadas. 
*/
/*PRUEBA INCORRECTA*/
begin
gestionarEquipos.nuevo_equipo('Equipo1','Español',to_date('01/01/20','DD/MM/YY'), 123098456,'Mail@mail.com','tiene',2);
end;
select * from equipo;
/*


Error que empieza en la línea: 23 del comando :
begin
gestionarEquipos.nuevo_equipo('Equipo1','Español',to_date('01/01/20','DD/MM/YY'), 123098456,'Mail@mail.com','tiene',2);
end;
Informe de error -
ORA-20043: Error Oracle 1,El equipo ya existe
ORA-06512: en "EQDAW02.GESTIONAREQUIPOS", línea 54
ORA-06512: en línea 2 */

/*PROCEDIMIENTO PARA CAMBIAR NOMBRE EQUIPO*/
begin 
gestionarEquipos.cambiar_nombre_equipo('Equipo1','NuevoNombre');
end;
select * from equipo;
/*
COD_EQUIPO NOMBRE               NACIONALIDAD                                       FECHA_CR   TELEFONO MAIL                                                                                                                                                   ESCUDO                                                                                                                                                 ID_ASISTENTE
---------- -------------------- -------------------------------------------------- -------- ---------- ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------
         1 force                espanola                                           01/01/22  654987321 force@gmail.com                                                                                                                                        tiene                                                                                                                                                             2
         2 alliance             francesa                                           23/04/22  698745125 alliance@gmail.com                                                                                                                                     no_tiene                                                                                                                                                          2
         3 stacks               inglesa                                            14/03/21  632598145 stacks@gmail.com                                                                                                                                       tiene                                                                                                                                                              
         4 players              alemana                                            01/04/20  648211557 players@gmail.com                                                                                                                                      tiene                                                                                                                                                             3
         6 alliadsgance         francesa                                           23/04/22     695125 alnce@gmail.com                                                                                                                                        no_tiene                                                                                                                                                          2
         7 allifaadsgance       francesa                                           23/04/22    6925125 alnfasce@gmail.com                                                                                                                                     no_tiene                                                                                                                                                          2
         8 NuevoNombre          Español                                            01/01/20  123098456 Mail@mail.com                                                                                                                                          tiene                                                                                                                                                             2

7 filas seleccionadas. 
*/
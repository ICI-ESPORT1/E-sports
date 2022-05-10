/*PRUEBAS INSERT*/  
  
select * from equipo;
/*
COD_EQUIPO NOMBRE               NACIONALIDAD                                       FECHA_CR   TELEFONO MAIL                                                                                                                                                   ESCUDO                                                                                                                                                 ID_ASISTENTE    GANADOS   PERDIDOS
---------- -------------------- -------------------------------------------------- -------- ---------- ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------ ---------- ----------
         1 force                espanola                                           01/01/22  654987321 force@gmail.com                                                                                                                                        tiene                                                                                                                                                             1          0          0
*/

insert into resultado (id_equipo,id_partido,resultado) values(1,1,'G');

select * from partido;

select * from resultado;




select * from equipo;
/*
COD_EQUIPO NOMBRE               NACIONALIDAD                                       FECHA_CR   TELEFONO MAIL                                                                                                                                                   ESCUDO                                                                                                                                                 ID_ASISTENTE    GANADOS   PERDIDOS
---------- -------------------- -------------------------------------------------- -------- ---------- ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------ ---------- ----------
         1 force                espanola                                           01/01/22  654987321 force@gmail.com                                                                                                                                        tiene                                                                                                                                                             1          1          0
*/

update resultado
set resultado = 'P'
where id_equipo =1;

/*
COD_EQUIPO NOMBRE               NACIONALIDAD                                       FECHA_CR   TELEFONO MAIL                                                                                                                                                   ESCUDO                                                                                                                                                 ID_ASISTENTE    GANADOS   PERDIDOS
---------- -------------------- -------------------------------------------------- -------- ---------- ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------ ---------- ----------
         1 force                espanola                                           01/01/22  654987321 force@gmail.com                                                                                                                                        tiene                                                                                                                                                             1          0          1
*/





select * from equipo;
/*
COD_EQUIPO NOMBRE               NACIONALIDAD                                       FECHA_CR   TELEFONO MAIL                                                                                                                                                   ESCUDO                                                                                                                                                 ID_ASISTENTE    GANADOS   PERDIDOS
---------- -------------------- -------------------------------------------------- -------- ---------- ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------------------------------------------------------------------------------------------------------------------------------------------------ ------------ ---------- ----------
         1 force                espanola                                           01/01/22  654987321 force@gmail.com                                                                                                                                        tiene                                                                                                                                                             1          0          1

*/

delete from resultado
where id_equipo = 1 and id_partido=1;


alter trigger borrarResultado   enable;






















 when deleting then
    v_equipo := :new.id_equipo;
    v_partido := :new.id_partido;
   
    select resultado into v_resultado
    from resultado
    where id_equipo= v_equipo and id_partido= v_partido;
    
     if v_resultado = 'G' then
     update equipo
     set ganados = ganados -1
     where cod_equipo = v_equipo;
     
   else

     update equipo
     set perdidos = perdidos -1
     where cod_equipo = v_equipo;
 end if;










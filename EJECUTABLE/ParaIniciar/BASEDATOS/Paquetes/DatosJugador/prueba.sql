/*PROCEDIMINETOS ANONIMOS DATOSJUGADOR*/

declare
sc_cursor visualizarDatos.tcursor;
reg_datos datosJugadores%rowtype;
begin
 visualizarDatos.datosJugadorID(1,sc_cursor);
 
 fetch sc_cursor into reg_datos;
 if(sc_cursor%notfound)then
   dbms_output.put_line('NO HAY JUGADORES');
 else
 while(sc_cursor%found)loop
   dbms_output.put_line('nombre: '||reg_datos.nombreJugador);
    fetch sc_cursor into reg_datos;
  end loop;
  end if;
  close sc_cursor;
end;
/*CON UN JUGADOR QUE EXISTE*/
/*nombre: Iker

Procedimiento PL/SQL terminado correctamente.*/

/*CON UN JUGADOR QUE NO EXISTE*/

declare
sc_cursor visualizarDatos.tcursor;
reg_datos datosJugadores%rowtype;
begin
 visualizarDatos.datosJugadorID(100,sc_cursor);
 
 fetch sc_cursor into reg_datos;
 if(sc_cursor%notfound)then
   dbms_output.put_line('NO HAY JUGADORES');
 else
 while(sc_cursor%found)loop
   dbms_output.put_line('nombre: '||reg_datos.nombreJugador);
    fetch sc_cursor into reg_datos;
  end loop;
  end if;
  close sc_cursor;
end;
/*Informe de error -
ORA-20030: Error Oracle 1,El jugador no existe
ORA-06512: en "EQDAW02.VISUALIZARDATOS", línea 48
ORA-06512: en línea 5*/

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
/*CON UN JUGADOR QUE EXISTE*/
/*nombre: Rachel Brown

Procedimiento PL/SQL terminado correctamente.*/

/*CON UN JUGADOR QUE NO EXISTE*/
/*Procedimiento PL/SQL terminado correctamente.
NO HAY JUGADORES*/
set serveroutput on;
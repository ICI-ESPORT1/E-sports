/*CUERPO GESTIONRESULTADOS*/

create or replace package body visualizarDatos as
 function validar_jugador
    (p_jugador in number)
    return boolean;

 function validar_jugador
    (p_jugador in number)
    return boolean
    is
        v_idJugador number;
    begin
        select id_jugador into v_idJugador
        from jugador
        where jugador.id_jugador = p_jugador;
        return true;
    exception
        when no_data_found then 
        return false;
    end validar_jugador;

procedure datosJugadorID
(
p_idJugador in int,
c_resultado out tcursor
)
as
v_error varchar2(300);
v_error_mensaje varchar2(300);
v_codError number;
e_jugadorNoExiste exception;

begin
if(validar_jugador(p_idJugador)) then
open c_resultado for
 select id_jugador, nombreJugador,dni,telefono,direccion,id_equipo,apodo,sueldo,
        nombreequipo,rol
 from datosJugadores
 where id_jugador = p_idJugador;
 
else
raise e_jugadorNoExiste;
end if;
  exception
      
    when e_jugadorNoExiste then
        v_error_mensaje:='El jugador no existe';
        v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
      RAISE_APPLICATION_ERROR(-20028,v_error);
      
end;
end visualizarDatos;








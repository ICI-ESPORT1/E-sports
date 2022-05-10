/*CUERPO GESTIONRESULTADOS*/

create or replace package body visualizarDatos as
procedure datosJugadorID
(
p_idJugador in int,
c_resultado out tcursor
)
as
v_codError number;
v_mensError varchar2(300);
e_jugadorNoExiste exception;
pragma exception_init(e_jugadorNoExiste,-20011);

begin
open c_resultado for
 select id_jugador, nombreJugador,dni,telefono,direccion,id_equipo,apodo,sueldo,
        nombreequipo,rol
 from datosJugadores
 where id_jugador = p_idJugador;

exception
when no_data_found then
  raise e_jugadorNoExiste;
when e_jugadorNoExiste then
  v_codError := sqlcode;
  v_mensError := 'El jugador no existe';
end;
end visualizarDatos;








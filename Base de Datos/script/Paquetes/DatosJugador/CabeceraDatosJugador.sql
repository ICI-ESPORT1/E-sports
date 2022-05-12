/*PAQUETE VISUALIZAR DATOS*/
create or replace package visualizarDatos as
type tcursor is ref cursor;
procedure datosJugadorID
(
p_idJugador in int,
c_resultado out tcursor
);
end visualizarDatos;
/*compila*/





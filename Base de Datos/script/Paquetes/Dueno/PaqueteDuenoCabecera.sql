create or replace package gestionarDueno as

procedure nuevo_dueno
(
p_dni dueno.dni%type,
p_nombre dueno.nombre%type,
p_telefono dueno.telefono%type,
p_direccion dueno.direccion%type,
p_id_equipo dueno.id_equipo%type
);

procedure cambio_equipo_dueno
(
p_idDueno dueno.id_dueno%type,
p_idEquipoNuevo dueno.id_equipo%type
);

procedure borrar_dueno
(
p_idDueno dueno.id_dueno%type
);


end gestionarDueno;

create or replace package gestionarJornada as
procedure nuevo_jornada
(
p_fecha jornada.fecha%type,
p_numSemana jornada.num_semana%type,
p_idCalendario jornada.id_calendario%type
);

end gestionarJornada;
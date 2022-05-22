create or replace package body gestionarJornada as
/*declaro las funciones que son comunes a todos los procedimientos*/

/*Programacion de las funciones*/
function validar_jornada
(p_fecha in varchar2)
return boolean
is
v_idJornada NUMBER;
begin
select num_jornada into v_idJornada
from jornada
where jornada.fecha = p_fecha;
return true;
exception
when no_data_found then
return false;
end validar_jornada;


/*EMPIEZAN LOS PROCEDIMIENTOS***********************************************/
/*PROCEDIMIENTO PARA AÑADIR JORNADAS+*/
procedure nuevo_jornada
(
p_fecha jornada.fecha%type,
p_numSemana jornada.num_semana%type,
p_idCalendario jornada.id_calendario%type
)
is
e_jorNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
if validar_jornada(p_fecha)then
raise e_jorNoExiste;
else
insert into jornada
    (FECHA,NUM_SEMANA,id_calendario)
    values(p_fecha,p_numSemana,p_idCalendario);
end if;

exception

when e_jorNoExiste then
    v_error_mensaje:='La jornada no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20049,v_error);
when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20050,v_error);
    
END nuevo_jornada;

end gestionarJornada;
/*CUERPO PAQUETE GESTIONAR JUGADORES*/
create or replace package body gestionarJugadores as
/*declaro las funciones que son comunes a todos los procedimientos*/
    function validar_equipo_jugador
    (p_equipo in number)
    return boolean;
function validar_jugador
    (p_jugador in number)
    return boolean; 
    
function validar_jugador_dni
    (p_jugador in varchar2)
    return boolean;
    
/*Programacion de las funciones*/    
    function validar_equipo_jugador
    (p_equipo in number)
    return boolean
    is
        v_idEquipo NUMBER;
    begin
        select cod_equipo into v_idEquipo
        from equipo
        where equipo.cod_equipo= p_equipo;
      return true;
    exception
        when no_data_found then
          return false;
    end validar_equipo_jugador;    
    
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
    
    function validar_jugador_dni
    (p_jugador in varchar2)
    return boolean
    is
        v_dniJugador varchar2(9);
    begin
        select dni into v_dniJugador
        from jugador
        where jugador.dni= p_jugador;
        return true;
    exception
        when no_data_found then 
        return false;
    end validar_jugador_dni;
/*EMPIEZAN LOS PROCEDIMIENTOS***********************************************/
/*PROCEDIMIENTO PARA AÑADIR JUGADORES*/
procedure nuevo_jugador
(
p_dni jugador.dni%type,
p_nombre jugador.nombre%type,
p_telefono jugador.telefono%type,
p_direccion jugador.direccion%type,
p_id_equipo jugador.id_equipo%type,
p_nickname jugador.nickname%type,
p_sueldo jugador.sueldo%type,
p_id_rol jugador.id_rol%type
)
as
e_jugNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
  if validar_equipo_jugador(p_id_equipo)then

     insert into jugador
     (DNI,NOMBRE,TELEFONO,DIRECCION,ID_EQUIPO,NICKNAME,SUELDO,ID_ROL)
        values(p_dni,p_nombre,p_telefono,p_direccion,p_id_equipo,p_nickname,
               p_sueldo,p_id_rol);
  else
    raise e_jugNoExiste;
  end if;
  
  exception
  
  when e_jugNoExiste then
    v_error_mensaje:='El equipo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20043,v_error);
    
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20044,v_error);
    
END nuevo_jugador;
/*PROCEDIMIENTO PARA CAMBIAR EQUIPO*******************************************/
procedure cambio_equipo_jugador
(
p_idJugador jugador.id_jugador%type,
p_idEquipoNuevo jugador.id_equipo%type
)
is
e_jugNoExiste exception;
e_equNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
 if validar_jugador(p_idJugador) then
    if validar_equipo_jugador(p_idEquipoNuevo)then
      update jugador
      set id_equipo = p_idEquipoNuevo
      where id_jugador = p_idJugador;
    else
      raise e_equNoExiste;
    end if;
 else
   raise e_jugNoExiste;
 end if;
 
 exception
 
   when e_jugNoExiste then
    v_error_mensaje:='El jugador no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20045,v_error);
    
   when e_equNoExiste then
    v_error_mensaje:='El equipo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20045,v_error);
    
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20046,v_error);
    
end cambio_equipo_jugador;  
/*PROCEDIMIENTO PARA BORRAR JUGADOR*******************************************/
procedure borrar_jugador
(
p_dniJugador jugador.dni%type
)
is
e_jugNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
  if validar_jugador_dni(p_dniJugador) then
   delete from jugador
   where dni = p_dniJugador;
   
   else
        raise e_jugNoExiste;
  end if;
  
  exception
   
   when e_jugNoExiste then
    v_error_mensaje:='El jugador no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20047,v_error);
    
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20048,v_error);
    
END borrar_jugador;  

end gestionarJugadores;

create or replace package body gestionarEntrenadores as
/*declaro las funciones que son comunes a todos los procedimientos*/

    
/*Programacion de las funciones*/    

function validar_equipo_entrenador
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
end validar_equipo_entrenador;

    
function validar_entrenador
(p_entrenador in number)
return boolean
is
  v_idEntrenador number;
begin
  select id_entrenador into v_idEntrenador
  from entrenador
  where entrenador.id_entrenador = p_entrenador;
return true;
exception
  when no_data_found then 
    return false;
 end validar_entrenador;   
    
    function validar_entrenador_dni
(p_entrenador in number)
return boolean
is
  v_idEntrenador number;
begin
  select id_entrenador into v_idEntrenador
  from entrenador
  where entrenador.id_entrenador = p_entrenador;
return true;
exception
  when no_data_found then 
    return false;
  end validar_entrenador_dni;  

/*EMPIEZAN LOS PROCEDIMIENTOS***********************************************/
/*PROCEDIMIENTO PARA AÑADIR ENTRENADORES*/

procedure nuevo_entrenador
(
p_dni entrenador.dni%type,
p_nombre entrenador.nombre%type,
p_telefono entrenador.telefono%type,
p_direccion entrenador.direccion%type,
p_id_equipo entrenador.id_equipo%type,
p_sueldo entrenador.sueldo%type
)
is
e_dueNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
  if validar_entrenador(p_id_equipo)then

     insert into entrenador
     (DNI,NOMBRE,TELEFONO,DIRECCION,ID_EQUIPO,SUELDO)
        values(p_dni,p_nombre,p_telefono,p_direccion,p_id_equipo,
               p_sueldo);
  else
     raise e_dueNoExiste;
  end if;

  exception
  
  when e_dueNoExiste then
    v_error_mensaje:='El equipo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20036,v_error);
    
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20037,v_error);
    
END nuevo_entrenador;

/*PROCEDIMIENTO PARA CAMBIAR DE EQUIPO A UN ENTRENADOR*/
procedure cambio_equipo_entrenador
(
p_idEntrenador entrenador.id_entrenador%type,
p_idEquipoNuevo entrenador.id_equipo%type
)
is
e_equipoNoExiste exception;
e_dueNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
 if validar_entrenador(p_idEntrenador) then
    if validar_equipo_entrenador(p_idEquipoNuevo)then
      update entrenador
      set id_equipo = p_idEquipoNuevo
      where id_entrenador = p_idEntrenador;
    else
      raise e_equipoNoExiste;
    end if;
 else
  raise e_dueNoExiste;
 end if;
 
 exception
 when e_dueNoExiste then
    v_error_mensaje:='El entrenador no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20038,v_error);
    
 when e_equipoNoExiste then 
    v_error_mensaje:='El equipo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20039,v_error);
    
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20040,v_error);
      
end cambio_equipo_entrenador;   


/*PROCEDIMIENTO PARA BORRAR ENTRENADOR*/
procedure borrar_entrenador
(
p_dniEntrenador entrenador.dni%type
)
is
e_dueNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
  if validar_entrenador_dni(p_dniEntrenador) then
   delete from entrenador
   where dni = p_dniEntrenador;
   
   else
        raise e_dueNoExiste;
  end if;
  
  exception
  when e_dueNoExiste then
    v_error_mensaje:='El entrenador no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20041,v_error);
    
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20042,v_error);
    
END borrar_entrenador;  

end gestionarEntrenadores;
/*CUERPO PAQUETE GESTIONAR JUGADORES*/
create or replace package body gestionarDueno as

/******declaro las funciones que son comunes a todos los procedimientos*******/
    function validar_equipo_dueno
    (p_equipo in number)
    return boolean;
function validar_dueno
    (p_dueno in number)
    return boolean; 
    
/*Programacion de las funciones*/    
    function validar_equipo_dueno
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
    end validar_equipo_dueno;    
    
    function validar_dueno
    (p_dueno in number)
    return boolean
    is
        v_idDueno number;
    begin
        select id_dueno into v_idDueno
        from dueno
        where dueno.id_dueno = p_dueno;
        return true;
    exception
        when no_data_found then 
        return false;
    end validar_dueno;
    
    
      function validar_dueno_dni
    (p_dueno in varchar2)
    return boolean
    is
        v_dniDueno varchar2(9);
    begin
        select dni into v_dniDueno
        from dueno
        where dueno.dni = p_dueno;
        return true;
    exception
        when no_data_found then 
        return false;
    end validar_dueno_dni;
    
    
    
/*EMPIEZAN LOS PROCEDIMIENTOS***********************************************/
/*PROCEDIMIENTO PARA ANADIR DUENO*/
procedure nuevo_dueno
(
p_dni dueno.dni%type,
p_nombre dueno.nombre%type,
p_telefono dueno.telefono%type,
p_direccion dueno.direccion%type,
p_id_equipo dueno.id_equipo%type
)
as
v_error varchar2(300);
v_error_mensaje varchar2(300);
e_equipoNoExiste exception;
begin
  if validar_equipo_dueno(p_id_equipo)then

     insert into dueno
     (DNI, NOMBRE, TELEFONO, DIRECCION, ID_EQUIPO)
        values(p_dni,p_nombre,p_telefono,p_direccion,p_id_equipo);
  else
    raise e_equipoNoExiste;
  end if;
  exception
  when e_equipoNoExiste then
    v_error_mensaje:='El equipo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20031,v_error);
   when others then
     v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20032,v_error);
END nuevo_dueno;


/*PROCEDIMIENTO PARA CAMBIAR DE EQUIPO AL DUENO******************************/
procedure cambio_equipo_dueno
(
p_idDueno dueno.id_dueno%type,
p_idEquipoNuevo dueno.id_equipo%type
)
is
e_equipoNoExiste exception;
e_dueNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
 if validar_dueno(p_idDueno) then
    if validar_equipo_dueno(p_idEquipoNuevo)then
      update dueno
      set id_equipo = p_idEquipoNuevo
      where id_dueno = p_idDueno;
    else
      raise e_equipoNoExiste;
    end if;
 else
  raise e_dueNoExiste;
 end if;
 
 exception
    when e_equipoNoExiste then
    v_error_mensaje:='El equipo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20033,v_error);
    
    when e_dueNoExiste then
    v_error_mensaje:='El duenoo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20034,v_error);
    
    when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20035,v_error);
    
end cambio_equipo_dueno; 

/*PROCEDIMIENTO PARA BORRAR DE EQUIPO AL DUENO******************************/
procedure borrar_dueno
(
p_dniDueno dueno.dni%type
)
is
e_dueNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin
  if validar_dueno_dni(p_dniDueno) then
   delete from dueno
   where dni = p_dniDueno;
   
   else
      raise e_dueNoExiste;
  end if;
  
  exception
    when e_dueNoExiste then
    v_error_mensaje:='El duenoo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20034,v_error);
    
    when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20035,v_error);
    
END borrar_dueno;

end gestionarDueno;
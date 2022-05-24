/*CUERPO PAQUETE GESTIONARASISTENTE*/
create or replace package body gestionarAsistente as

/*Declaro funciones*/
function validar_equipo_asistente
(p_equipo in number)
return boolean;

function validar_asistente
(p_asistente in number)
return boolean;
/*Programacion funciones*/
function validar_equipo_asistente
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
end validar_equipo_asistente;

function validar_asistente
(p_asistente in number)
return boolean
is
  v_idAsistente number;
begin
  select id_asistente into v_idAsistente
  from asistente
  where asistente.id_asistente = p_asistente;
return true;
exception
  when no_data_found then 
    return false;
end validar_asistente;

function validar_asistente_dni
(p_asistente in varchar2)
return boolean
is
  v_dniAsistente varchar2(9);
begin
  select dni into v_dniAsistente
  from asistente
  where asistente.dni = p_asistente;
return true;
exception
  when no_data_found then 
    return false;
end validar_asistente_dni;


/*EMPIEZAN LOS PROCEDIMIENTOS ************************************************/
/*A?ADIR NUEVO ASISTENTE*/
procedure nuevo_asistente
(
p_dni asistente.dni%type,
p_nombre asistente.nombre%type,
p_telefono asistente.telefono%type,
p_direccion asistente.direccion%type,
p_sueldo asistente.sueldo%type
)
is
v_error varchar2(300);
v_error_mensaje varchar2(300);
e_valor_null exception;
pragma exception_init(e_valor_null,-01400);
begin

   insert into asistente
   (dni,nombre,telefono,direccion,sueldo) values
   (p_dni,p_nombre,p_telefono,p_direccion,p_sueldo);

 exception
    when e_valor_null then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20019,v_error);
    
    when dup_val_on_index then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20020,v_error);
    
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20021,v_error);
END nuevo_asistente;  

procedure cambio_equipo_asistente
(
p_idAsistente asistente.id_asistente%type,
p_idEquipoNuevo equipo.cod_equipo%type
)
is
v_error varchar2(300);
v_error_mensaje varchar2(300);
e_asisNoExiste exception;
e_equi_no_existe exception;
begin
 if validar_asistente(p_idAsistente) then
    if validar_equipo_asistente(p_idEquipoNuevo)then
      update equipo
      set id_asistente =  p_idAsistente
      where cod_equipo = p_idEquipoNuevo;
    else
    raise e_equi_no_existe;
    end if;
 else
  raise e_asisNoExiste;
 end if;
 
 exception
 when e_equi_no_existe then
    v_error_mensaje:='El equipo no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20022,v_error);
     
 when e_asisNoExiste then
    v_error_mensaje:='El asistente no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20023,v_error);
     
   when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20024,v_error);
     
end cambio_equipo_asistente;

/**************************PROCEDIMINETO PARA BORRAR UN ASISTENTE*********************************/
procedure borrar_asistente
(
p_dniAsistente asistente.dni%type
)
is
v_error varchar2(300);
v_error_mensaje varchar2(300);
e_asisNoExiste exception;
begin
  if validar_asistente_dni(p_dniAsistente) then
   delete from asistente
   where dni = p_dniAsistente;
   
   else
      raise e_asisNoExiste;
  end if;
  
  exception
    when e_asisNoExiste then
    v_error_mensaje:='El asistente no existe';
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20025,v_error);
    
    when others then
    v_error_mensaje:=sqlerrm;
    v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
    RAISE_APPLICATION_ERROR(-20026,v_error);

END borrar_asistente;
end gestionarAsistente;

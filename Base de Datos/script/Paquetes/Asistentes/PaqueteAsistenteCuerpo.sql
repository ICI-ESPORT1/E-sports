/*CUERPO PAQUETE GESTIONARASISTENTE*/
create or replace package body gestionarAsistente as
/*EXCEPCIONES PARA EL PAQUETE*/
e_equipoNoExiste exception;
pragma exception_init(e_equipoNoExiste,-20002);

e_asisNoExiste exception;
pragma exception_init(e_asisNoExiste,-20003);

/*Declaro funciones*/
function validar_equipo
(p_equipo in number)
return boolean;

function validar_asistente
(p_asistente in number)
return boolean;
/*Programacion funciones*/
function validar_equipo
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
end validar_equipo;

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
/*EMPIEZAN LOS PROCEDIMIENTOS ************************************************/
/*A�ADIR NUEVO ASISTENTE*/
procedure nuevo_asistente
(
p_dni asistente.dni%type,
p_nombre asistente.nombre%type,
p_telefono asistente.telefono%type,
p_sueldo asistente.sueldo%type
)
is

begin

   insert into asistente
   (dni,nombre,telefono,sueldo) values
   (p_dni,p_nombre,p_telefono,p_sueldo);

 exception

   when others then
     dbms_output.put_line('HA OCURRIDO UN ERROR');
END nuevo_asistente;  

procedure cambio_equipo
(
p_idAsistente asistente.id_asistente%type,
p_idEquipoNuevo equipo.cod_equipo%type
)
is
begin
 if validar_asistente(p_idAsistente) then
    if validar_equipo(p_idEquipoNuevo)then
      update equipo
      set id_asistente =  p_idAsistente
      where cod_equipo = p_idEquipoNuevo;
    else
      dbms_output.put_line ('El equipo no existe');
    end if;
 else
  raise e_asisNoExiste;
 end if;
 exception
 when e_asisNoExiste then
  dbms_output.put_line ('El asistente no existe');
   when others then
      dbms_output.put_line('HA OCURRIDO UN ERROR');
end cambio_equipo;

procedure borrar_asistente
(
p_idAsistente asistente.id_asistente%type
)
is
begin
  if validar_asistente(p_idAsistente) then
   delete from asistente
   where id_asistente = p_idAsistente;
   
   else
      raise e_asisNoExiste;
  end if;
  exception
    when e_asisNoExiste then
        dbms_output.put_line ('El asistente no existe');
    when others then
        dbms_output.put_line('HA OCURRIDO UN ERROR');
END borrar_asistente;
end gestionarAsistente;

/*TRIGGER SUMAR GANADOS Y PERDIDOS*/

create or replace trigger ganadosPerdidos
before insert or update  on resultado 
for each row 
declare
   v_equipo number;
   v_resultado varchar2(5);
   v_partido number;
   
begin
case 
 when inserting then
 v_resultado := :new.resultado;
 v_equipo := :new.id_equipo;
     if v_resultado = 'G' then
     update equipo
     set ganados = ganados + 1
     where cod_equipo = v_equipo;
     dbms_output.put_line('Sumo 1 a ganados');
   else
     update equipo
     set perdidos = perdidos +1
     where cod_equipo = v_equipo;
         dbms_output.put_line('Sumo 1 a perdidos');
   end if;  
 when updating then
   v_resultado := :new.resultado;
   v_equipo := :new.id_equipo;
   
   if v_resultado = 'G' then
     update equipo
     set ganados = ganados +1
     where cod_equipo = v_equipo;
     
     update equipo
     set perdidos = perdidos -1
     where cod_equipo = v_equipo;
     
   else
        update equipo
     set ganados = ganados -1
     where cod_equipo = v_equipo;
     
     update equipo
     set perdidos = perdidos +1
     where cod_equipo = v_equipo;
 end if;

end case;
end ganadosPerdidos;

create or replace trigger borrarResultado 
for delete on resultado compound trigger
    v_equipo number;
    v_resultado varchar2(5);
    v_partido number;
    
before each row is
 begin
    select resultado into v_resultado
    from resultado
    where id_equipo= v_equipo and id_partido= v_partido;
    
    v_equipo := :new.id_equipo;
    v_partido := :new.id_partido;
 end before each row;

after statement is
begin
      if v_resultado = 'G' then
     update equipo
     set ganados = ganados -1
     where cod_equipo = v_equipo;
    
   else
     update equipo
     set perdidos = perdidos -1
     where cod_equipo = v_equipo;
 end if;
end after statement;
end borrarResultado;




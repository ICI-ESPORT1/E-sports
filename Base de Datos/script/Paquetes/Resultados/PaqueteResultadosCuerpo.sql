create or replace package body gestionResultados as
procedure obtenerClasificacion
(
c_resultado out tcursor
)
as
e_quipoNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin


    open c_resultado for 
    select equipo,count(resultado) as ganados
          from resultados_temporada 
          where upper(resultado)='G' 
          group by equipo
          order by count(resultado) desc;
      
    exception
    
        when no_data_found then
         raise e_quipoNoExiste ;
         
        when e_quipoNoExiste then
            v_error_mensaje:='El equipo no existe';
            v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
            RAISE_APPLICATION_ERROR(-20049,v_error);
            
END obtenerClasificacion;

/*Metodo para mostrar todos los partidos de las jornadas*/
procedure partidosJornada
(
c_partidos out tcursor
)
as
e_quipoNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin 

    open c_partidos for
    select equipo, resultado, partido
    from resultados_temporada
    order by partido;

    exception
    
        when no_data_found then
         raise e_quipoNoExiste ;
         
        when e_quipoNoExiste then
            v_error_mensaje:='El equipo no existe';
            v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
            RAISE_APPLICATION_ERROR(-20050,v_error);


end partidosJornada;

procedure partidos
(
c_partidos out tcursor
)
as
e_quipoNoExiste exception;
v_error varchar2(300);
v_error_mensaje varchar2(300);
begin

    open c_partidos for
    select equipo, resultado, partido
    from resultados_temporada
    where fecha<sysdate
    order by partido;

    exception
    
        when no_data_found then
         raise e_quipoNoExiste ;
         
        when e_quipoNoExiste then
            v_error_mensaje:='El equipo no existe';
            v_error:= 'Error Oracle '||to_char(sqlcode)||','||v_error_mensaje;
            RAISE_APPLICATION_ERROR(-20051,v_error);

end partidos;

end gestionResultados;
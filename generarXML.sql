/*GENERAR XML TABLAS*/
/*TABLA DUENO*/
DECLARE
  contexto DBMS_XMLGEN.ctxHandle;
  resultado CLOB;
 
BEGIN
  contexto := DBMS_XMLGEN.newContext(
              'SELECT * FROM dueno');		  
  DBMS_XMLGEN.setRowSetTag(contexto,'duenos');
  DBMS_XMLGEN.setRowTag(contexto,'dueno');
  DBMS_XMLGEN.setNullHandling(contexto,2);
  resultado := DBMS_XMLGEN.getXML(contexto);
  
  INSERT INTO fichero VALUES(resultado);
  DBMS_XMLGEN.closeContext(contexto);
  
END;

select * from fichero;

/*RESULTADO                                                                       
--------------------------
<?xml version="1.0"?>
<duenos>
 <dueno>
  <ID_DUENO>1</ID_DUENO>
  <DNI>76025134*/
  
desc calendario;
/*TABLA ENTRENADOR*/
/*TABLA ASISTENTE*/
/*TABLA JUGADOR*/
/*TABLA ROL*/
/*TABLA CALENDARIO*/
/*TABLA JORNADA*/
/*TABLA PARTIDO*/
/*TABLA RESULTADO*/
/*TABLA EQUIPO*/


create or replace PACKAGE gestionResultados as
type tcursor is ref Cursor;
procedure obtenerClasificacion
(
c_resultado out tcursor
);

procedure partidosJornada
(
c_partidos out tcursor
);

procedure partidos
(
c_partidos out tcursor
);

end gestionResultados;
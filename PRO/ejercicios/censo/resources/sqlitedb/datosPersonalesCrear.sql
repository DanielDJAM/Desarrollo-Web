CREATE TABLE if not EXISTS DatosPersonales (
  dni VARCHAR(9) NOT NULL PRIMARY KEY,
  nombre VARCHAR(50),
  fecha VARCHAR(50),
  id_direccion VARCHAR(50) NOT NULL,
  tlfn INT(20)
  /*FOREIGN KEY (id_direccion) REFERENCES Direccion(id_direccion)*/
  );
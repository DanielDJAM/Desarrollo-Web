package es.iespuertolacruz.daniel;

import java.io.File;
import java.io.FileWriter;

import es.iespuertolacruz.daniel.Exception.EscrituraException;

public class EscrituraFichero {

	public void escribirFichero(String nombre) {

		String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };

		/** FORMA 1 DE ESCRITURA **/
		FileWriter fichero = null;
		try {

			fichero = new FileWriter(nombre);

			// Escribimos linea a linea en el fichero
			for (String linea : lineas) {
				fichero.write(linea + "\n");
			}

			fichero.close();

		} catch (EscrituraException e) {
            throw new EscrituraException("Ha ocurrido un error al escribir en el fichero.");
		}
	}
}

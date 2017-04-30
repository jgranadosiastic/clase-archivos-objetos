package parqueo.backend.datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import parqueo.backend.modelos.parqueo.Parqueo;

/**
 * PracticaGUI
 * @author jose - 28.04.2017 
 * @Title: ManejadorDatosParqueo
 * @Description: description
 *
 * Changes History
 */
public class ManejadorDatosParqueo {
	
	private static final String ARCHIVO_PARQUEO = "parqueo.dat";
	
	private File archivoParqueo;

	public ManejadorDatosParqueo() {
		archivoParqueo = new File(ARCHIVO_PARQUEO);
	}
	
	public void guardarDatos(Parqueo parqueo) throws IOException {
		ObjectOutputStream salidaObj = null;
		try {
			FileOutputStream salida = new FileOutputStream(archivoParqueo);
			salidaObj = new ObjectOutputStream(salida);
			salidaObj.writeObject(parqueo);
		} catch (FileNotFoundException ex) {
			throw new IOException(ex);
		} catch (IOException ex) {
			throw new IOException(ex);
		} finally {
			salidaObj.close();
		}
	}
	
	public Parqueo cargarParqueo() throws IOException {
		if (archivoParqueo.exists()) {
			FileInputStream entrada = new FileInputStream(archivoParqueo);
			ObjectInputStream entradaObj = new ObjectInputStream(entrada);
			try {
				return (Parqueo) entradaObj.readObject();
			} catch (ClassNotFoundException ex) {
				throw new IOException(ex);
			} finally {
				entradaObj.close();
			}
		} else {
			return new Parqueo();
		}
	}
}
package parqueo.backend.excepciones;

/**
 * PracticaGUI
 * @author jose - 19.04.2017 
 * @Title: InputsVaciosException
 * @Description: description
 *
 * Changes History
 */
public class InputsVaciosException extends Exception {
	public InputsVaciosException() {
		
	}
	
	public InputsVaciosException(String mensaje) {
		super(mensaje);
	}
}
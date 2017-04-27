package parqueo.backend.excepciones;

/**
 * Escritorio
 *
 * @author jose - 10.04.2017
 * @Title: ValidacionExcepcion
 * @Description: description
 *
 * Changes History
 */
public class ValidacionExcepcion extends Exception {

	/**
	 * Creates a new instance of <code>ValidacionExcepcion</code> without detail message.
	 */
	public ValidacionExcepcion() {
	}

	/**
	 * Constructs an instance of <code>ValidacionExcepcion</code> with the specified
	 * detail message.
	 *
	 * @param msg the detail message.
	 */
	public ValidacionExcepcion(String msg) {
		super(msg);
	}
}

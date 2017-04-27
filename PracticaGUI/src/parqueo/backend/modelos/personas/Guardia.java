package parqueo.backend.modelos.personas;

import java.time.LocalDate;

/**
 * PracticaGUI
 * @author jose - 10.04.2017 
 * @Title: Guardia
 * @Description: description
 *
 * Changes History
 */
public class Guardia extends Empleado {
	public static final int HORAS_LABORALES = 12;
	public static final int TIPO_EMPLEADO = 2;
	
	private String codigoSeguro;

	public Guardia(int codigo, String CUI, String nombre, LocalDate inicioLabores, int tipoEmpleado, String codigoSeguro) {
		super(codigo, CUI, nombre, inicioLabores, tipoEmpleado);
		this.codigoSeguro = codigoSeguro;
	}

	public String getCodigoSeguro() {
		return codigoSeguro;
	}

	public void setCodigoSeguro(String codigoSeguro) {
		this.codigoSeguro = codigoSeguro;
	}
	
	
}
package parqueo.backend.modelos.personas;

import java.time.LocalDate;

/**
 * PracticaGUI
 * @author jose - 10.04.2017 
 * @Title: Operador
 * @Description: description
 *
 * Changes History
 */
public class Operador extends Empleado {
	public static final int HORAS_LABORALES = 8;
	public static final int TIPO_EMPLEADO = 1;

	public Operador(int codigo, String CUI, String nombre, LocalDate inicioLabores, int tipoEmpleado) {
		super(codigo, CUI, nombre, inicioLabores, tipoEmpleado);
	}

}
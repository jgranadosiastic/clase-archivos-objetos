package parqueo.backend.modelos.personas;

import java.time.LocalDate;

/**
 * PracticaGUI
 * @author jose - 08.04.2017 
 * @Title: Empleado
 * @Description: description
 *
 * Changes History
 */
public class Empleado extends Persona {
	private int codigo;
	private double salario;
	private LocalDate inicioLabores;
	private String telefono;
	private int tipoEmpleado;

	public Empleado(int codigo, String CUI, String nombre, LocalDate inicioLabores, int tipoEmpleado) {
		super(CUI, nombre);
		this.codigo = codigo;
		this.inicioLabores = inicioLabores;
		this.tipoEmpleado = tipoEmpleado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getInicioLabores() {
		return inicioLabores;
	}

	public void setInicioLabores(LocalDate inicioLabores) {
		this.inicioLabores = inicioLabores;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	
	
	
}
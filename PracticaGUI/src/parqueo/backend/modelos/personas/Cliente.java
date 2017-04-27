package parqueo.backend.modelos.personas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import parqueo.backend.modelos.registros.RegistroVehiculo;

/**
 * PracticaGUI
 *
 * @author jose - 08.04.2017
 * @Title: Cliente
 * @Description: description
 *
 * Changes History
 */
public class Cliente extends Persona {

	private String NIT;
	private List<RegistroVehiculo> registros;
	private List<RegistroVehiculo> registrosDescuentos;
	private double contadorHorasDescuento;
	
	public Cliente() {
	}

	public Cliente(String NIT, String CUI, String nombre) {
		super(CUI, nombre);
		this.NIT = NIT;
		registros = new ArrayList<>();
		registrosDescuentos = new ArrayList<>();
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String NIT) {
		this.NIT = NIT;
	}

	public List<RegistroVehiculo> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroVehiculo> registros) {
		this.registros = registros;
	}

	public List<RegistroVehiculo> getRegistrosDescuentos() {
		return registrosDescuentos;
	}

	public void setRegistrosDescuentos(List<RegistroVehiculo> registrosDescuentos) {
		this.registrosDescuentos = registrosDescuentos;
	}

	public double getContadorHorasDescuento() {
		return contadorHorasDescuento;
	}

	public void setContadorHorasDescuento(double contadorHorasDescuento) {
		this.contadorHorasDescuento = contadorHorasDescuento;
	}

	public Cliente clonarDatos() {
		Cliente clon = new Cliente();
		clon.setCUI(getCUI());
		clon.setNIT(getNIT());
		clon.setDireccion(getDireccion());
		clon.setNombre(getNombre());
		return clon;
	}
}

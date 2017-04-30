package parqueo.backend.modelos.registros;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import parqueo.backend.modelos.parqueo.Parqueo;
import parqueo.backend.modelos.personas.Cliente;

/**
 * PracticaGUI
 *
 * @author jose - 08.04.2017
 * @Title: RegistroVehiculo
 * @Description: description
 *
 * Changes History
 */
public class RegistroVehiculo implements Serializable {

	private LocalDate fechaIngreso;
	private double horasParqueadas;
	private double subtotal;
	private boolean conDescuento;
	private double total;
	//no enviamos el objeto cliente para evitar copias
	private transient Cliente cliente;
	private String placa;
	private int tipoVehiculo;
	//usamos esta llave para enlazar el cliente con el 
	//registro cuando cargamos desde archivo
	private String nitCliente;

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getHorasParqueadas() {
		return horasParqueadas;
	}

	public void setHorasParqueadas(double horasParqueadas) {
		this.horasParqueadas = horasParqueadas;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public boolean isConDescuento() {
		return conDescuento;
	}

	public void setConDescuento(boolean conDescuento) {
		this.conDescuento = conDescuento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (cliente != null) {
			this.nitCliente = cliente.getNIT();
		}
		this.cliente = cliente;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public String getTipoVehiculoStr() {
		switch (tipoVehiculo) {
			case Parqueo.VEHICULO_MOTO:
				return "Moto";
			case Parqueo.VEHICULO_CARRO:
				return "Carro";
			case Parqueo.VEHICULO_CAMION:
				return "Camion";
			default:
				return "Indefinido";
		}
	}
	
	public String getEstado() {
		return this.esCerrado() ? "Cerrado" : "Abierto";
	}

	public boolean getAntiguedad() {
		return fechaIngreso.isBefore(LocalDate.now().minus(2, ChronoUnit.DAYS));
	}
	
	public boolean esCerrado() {
		return this.horasParqueadas > 0;
	}

	public String getNitCliente() {
		return nitCliente;
	}
	
	
}

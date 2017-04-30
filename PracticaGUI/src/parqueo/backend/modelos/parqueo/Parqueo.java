package parqueo.backend.modelos.parqueo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import parqueo.backend.modelos.personas.Cliente;
import parqueo.backend.modelos.personas.Persona;
import parqueo.backend.modelos.registros.RegistroVehiculo;

/**
 * PracticaGUI
 *
 * @author jose - 10.04.2017
 * @Title: Parqueo
 * @Description: description
 *
 * Changes History
 */
public class Parqueo implements Serializable {

	//Capacidad
	public static final int CAPACIDAD_MOTOS = 10;
	public static final int CAPACIDAD_CARROS = 10;
	public static final int CAPACIDAD_CAMIONES = 5;
	//tarifas
	public static final double TARIFA_MOTOS = 5;
	public static final double TARIFA_MOTOS_FRACCION = 3;
	public static final double TARIFA_CARROS = 10;
	public static final double TARIFA_CARROS_FRACCION = 6;
	public static final double TARIFA_CAMIONES = 15;
	public static final double TARIFA_CAMIONES_FRACCION = 10;
	//tipos vehiculos
	public static final int VEHICULO_MOTO = 0;
	public static final int VEHICULO_CARRO = 1;
	public static final int VEHICULO_CAMION = 2;
	//propiedades
	public static final String PROP_ESPACIOS_MOTOS = "espaciosMotos";
	public static final String PROP_ESPACIOS_CARROS = "espaciosCarros";
	public static final String PROP_ESPACIOS_CAMIONES = "espaciosCamiones";
	//fecha
	public static final String FORMATO_FECHA = "dd/MM/yyyy";
	//descuento
	public static final double HORAS_PARA_DESCUENTO = 5;
	public static final double PORCENTAJE_DESCUENTO = 0.15;

	private int espaciosDisponiblesMotos;
	private int espaciosDisponiblesCarros;
	private int espaciosDisponiblesCamiones;

	private List<RegistroVehiculo> registros;
	private List<Persona> clientes;
	private List<Persona> empleados;

	public Parqueo() {
		espaciosDisponiblesMotos = CAPACIDAD_MOTOS;
		espaciosDisponiblesCarros = CAPACIDAD_CARROS;
		espaciosDisponiblesCamiones = CAPACIDAD_CAMIONES;
		registros = new ArrayList<>();
		clientes = new ArrayList<>();
		empleados = new ArrayList<>();
		//inicializarData();
	}

	private void inicializarData() {
//		Cliente cliente1 = new Cliente("1111", "111111", "cliente 1");
//		Cliente cliente2 = new Cliente("2222", "222222", "cliente 2");
//		clientes.add(cliente1);
//		clientes.add(cliente2);
//		clientes.add(new Cliente("3333", "333333", "cliente 3"));
//		clientes.add(new Cliente("4444", "444444", "cliente 4"));
//		clientes.add(new Cliente("5555", "555555", "cliente 5"));
//
//		//registro con entrada y salida
//		RegistroVehiculo registro1 = new RegistroVehiculo();
//		registro1.setCliente(cliente1);
//		registro1.setFechaIngreso(LocalDate.parse("2017-04-10"));
//		registro1.setPlaca("m1");
//		registro1.setTipoVehiculo(VEHICULO_MOTO);
//		registro1.setConDescuento(false);
//		registro1.setHorasParqueadas(3);
//		registro1.setSubtotal(15);
//		registro1.setTotal(15);
//		cliente1.setContadorHorasDescuento(3);
//		cliente1.getRegistros().add(registro1);
//		registros.add(registro1);
//		//registro con entrada y salida
//		RegistroVehiculo registro2 = new RegistroVehiculo();
//		registro2.setCliente(cliente2);
//		registro2.setFechaIngreso(LocalDate.parse("2017-04-10"));
//		registro2.setPlaca("cam1");
//		registro2.setTipoVehiculo(VEHICULO_CAMION);
//		registro2.setConDescuento(false);
//		registro2.setHorasParqueadas(6);
//		registro2.setSubtotal(90);
//		registro2.setTotal(90);
//		cliente2.setContadorHorasDescuento(6);
//		cliente2.getRegistros().add(registro2);
//		registros.add(registro2);
//		//registro con entrada y salida
//		RegistroVehiculo registro3 = new RegistroVehiculo();
//		registro3.setCliente(cliente1);
//		registro3.setFechaIngreso(LocalDate.parse("2017-04-11"));
//		registro3.setPlaca("m1");
//		registro3.setTipoVehiculo(VEHICULO_MOTO);
//		registro3.setConDescuento(false);
//		registro3.setHorasParqueadas(0.5);
//		registro3.setSubtotal(3);
//		registro3.setTotal(3);
//		cliente1.setContadorHorasDescuento(6.5);
//		cliente1.getRegistros().add(registro3);
//		registros.add(registro3);
//		//aun en parqueo
//		RegistroVehiculo registro4 = new RegistroVehiculo();
//		registro4.setCliente(cliente2);
//		registro4.setFechaIngreso(LocalDate.parse("2017-04-11"));
//		registro4.setPlaca("c1");
//		registro4.setTipoVehiculo(VEHICULO_CARRO);
//		cliente2.getRegistros().add(registro4);
//		registros.add(registro4);
//		espaciosDisponiblesCarros--;
	}

	public List<RegistroVehiculo> getRegistros() {
		return registros;
	}

	public List<Persona> getClientes() {
		return clientes;
	}

	public List<Persona> getEmpleados() {
		return empleados;
	}

	/**
	 * calcula la cantidad de espacios disponibles para un tipo de vehiculo
	 * 
	 * @param tipoVehiculo
	 * @return 
	 */
	public int obtenerEspaciosDisponibles(int tipoVehiculo) {
		switch (tipoVehiculo) {
			case Parqueo.VEHICULO_MOTO:
				return this.espaciosDisponiblesMotos;
			case Parqueo.VEHICULO_CARRO:
				return this.espaciosDisponiblesCarros;
			case Parqueo.VEHICULO_CAMION:
				return espaciosDisponiblesCamiones;
			default:
				return 0;
		}
	}

	/**
	 * Agrega un registro al listado de registros y disminuye el contador de espacios de
	 * un tipo de vehiculo para indicar que ya se ocupó un espacio.
	 *
	 * @param registro
	 */
	public void ingresarVehiculo(RegistroVehiculo registro) {
		switch (registro.getTipoVehiculo()) {
			case Parqueo.VEHICULO_MOTO:
				this.espaciosDisponiblesMotos--;
				break;
			case Parqueo.VEHICULO_CARRO:
				this.espaciosDisponiblesCarros--;
				break;
			case Parqueo.VEHICULO_CAMION:
				this.espaciosDisponiblesCamiones--;
				break;
			default:
				break;
		}
		this.registros.add(registro);
	}

	/**
	 * Aumente el contador de espacios de un tipo de vehiculo para indicar que ya se
	 * liberó un espacio.
	 *
	 * @param tipoVehiculo
	 */
	public void retirarVehiculo(int tipoVehiculo) {
		switch (tipoVehiculo) {
			case Parqueo.VEHICULO_MOTO:
				this.espaciosDisponiblesMotos++;
				break;
			case Parqueo.VEHICULO_CARRO:
				this.espaciosDisponiblesCarros++;
				break;
			case Parqueo.VEHICULO_CAMION:
				this.espaciosDisponiblesCamiones++;
				break;
			default:
				break;
		}
	}

	public void setRegistros(List<RegistroVehiculo> registros) {
		this.registros = registros;
	}

	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}
	
	
}

package parqueo.backend.parqueo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import parqueo.backend.excepciones.ValidacionExcepcion;
import parqueo.backend.modelos.parqueo.Parqueo;
import parqueo.backend.modelos.personas.Cliente;
import parqueo.backend.modelos.registros.RegistroVehiculo;
import parqueo.backend.personas.clientes.ManejadorClientes;

/**
 * PracticaGUI
 *
 * @author jose - 10.04.2017
 * @Title: ManejadorParqueo
 * @Description: description
 *
 * Changes History
 */
public class ManejadorParqueo {

	private Parqueo parqueo;

	public ManejadorParqueo(Parqueo parqueo) {
		this.parqueo = parqueo;
	}

	public Parqueo getParqueo() {
		return parqueo;
	}

	public void setParqueo(Parqueo parqueo) {
		this.parqueo = parqueo;
	}

	/**
	 * Registra el ingreso de u vehiculo al parqueo, haciendo validaciones y otra logica
	 *
	 * @param tipoVehiculo
	 * @param nit
	 * @param placa
	 * @param fechaIngreso
	 * @param manejadorClientes
	 * @return
	 * @throws ValidacionExcepcion
	 */
	public RegistroVehiculo registrarVehiculo(int tipoVehiculo, String nit, String placa,
		   String fechaIngreso, ManejadorClientes manejadorClientes) throws ValidacionExcepcion {
		RegistroVehiculo registro = new RegistroVehiculo();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(fechaIngreso, formato);
		Cliente cliente = manejadorClientes.buscarPorNIT(nit);
		if (cliente == null) {
			throw new ValidacionExcepcion("No existe cliente con el NIT: " + nit);
		}
		if (buscarRegistroAbierto(nit, placa, fecha) != null) {
			throw new ValidacionExcepcion("No se puede registrar un vehiculo dos veces");
		}
		registro.setFechaIngreso(fecha);
		registro.setPlaca(placa);
		registro.setCliente(cliente);
		registro.setTipoVehiculo(tipoVehiculo);
		parqueo.ingresarVehiculo(registro);
		cliente.getRegistros().add(registro);
		return registro;
	}

	/**
	 * Verifica si hay espacio disponible para el vehiculo con tipo especifico
	 *
	 * @param tipoVehiculo
	 * @return
	 */
	public boolean verificarEspacio(int tipoVehiculo) {
		return parqueo.obtenerEspaciosDisponibles(tipoVehiculo) > 0;
	}

	/**
	 * Obtiene el total de espacios disponibles para un tipo de vehiculo
	 *
	 * @param tipoVehiculo
	 * @return
	 */
	public int obtenerEspaciosDisponibles(int tipoVehiculo) {
		return parqueo.obtenerEspaciosDisponibles(tipoVehiculo);
	}

	/**
	 * Obtiene el total de espacios usados para un tipo de vehiculo
	 *
	 * @param tipoVehiculo
	 * @return
	 */
	public int obtenerEspaciosUsados(int tipoVehiculo) {
		int espaciosDisponibles = obtenerEspaciosDisponibles(tipoVehiculo);
		switch (tipoVehiculo) {
			case Parqueo.VEHICULO_MOTO:
				return Parqueo.CAPACIDAD_MOTOS - espaciosDisponibles;
			case Parqueo.VEHICULO_CARRO:
				return Parqueo.CAPACIDAD_CARROS - espaciosDisponibles;
			case Parqueo.VEHICULO_CAMION:
				return Parqueo.CAPACIDAD_CAMIONES - espaciosDisponibles;
			default:
				return 0;
		}
	}

	/**
	 * Busca el registro abierto de un vehiculo estacionado
	 *
	 * @param nit
	 * @param placa
	 * @param fechaIngreso
	 * @return
	 */
	public RegistroVehiculo buscarRegistroAbierto(String nit, String placa,
		   LocalDate fechaIngreso) {
		for (RegistroVehiculo registro : parqueo.getRegistros()) {
			if (registro.getCliente().getNIT().equalsIgnoreCase(nit)
				   && registro.getPlaca().equalsIgnoreCase(placa)
				   && registro.getFechaIngreso().isEqual(fechaIngreso)
				   && !registro.esCerrado()) {
				return registro;
			}
		}
		return null;
	}

	/**
	 * Busca los registros basado en el filtro 'verOpcion' para consultar los registros
	 * cerrados, abiertos o todos
	 *
	 * @param verOpcion
	 * @return
	 */
	public List<RegistroVehiculo> buscarRegistros(int verOpcion) {
		if (verOpcion == 0) {//todos los registros
			return parqueo.getRegistros();
		}
		List<RegistroVehiculo> resultados = new ArrayList<>();

		for (RegistroVehiculo registro : parqueo.getRegistros()) {
			if (!registro.esCerrado() && verOpcion == 1) {//registros abiertos
				resultados.add(registro);
			} else if (registro.esCerrado() && verOpcion == 2) {//registros cerrados
				resultados.add(registro);
			}
		}
		return resultados;
	}

	/**
	 * Registra la salida de un vehiculo cerrando el registro del vechiculo y calculando
	 * el pago
	 *
	 * @param tipoVehiculo
	 * @param nit
	 * @param placa
	 * @param fechaIngreso
	 * @param horasStr
	 * @return
	 * @throws ValidacionExcepcion
	 */
	public RegistroVehiculo retirarVehiculo(int tipoVehiculo, String nit, String placa,
		   String fechaIngreso, String horasStr) throws ValidacionExcepcion {
		double horas;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha ;
		try {
			fecha = LocalDate.parse(fechaIngreso, formato);
		} catch(DateTimeException ex) {
			throw new ValidacionExcepcion("Fecha Incorrecta");
		}
		RegistroVehiculo registro = buscarRegistroAbierto(nit, placa, fecha);
		if (registro == null) {
			throw new ValidacionExcepcion("No existe registro para el vehiculo: " + placa
				   + ", cliente NIT: " + nit);
		}
		try {
			horas = Double.parseDouble(horasStr);
		} catch (NumberFormatException ex) {
			throw new ValidacionExcepcion("Las horas no están en formato numerico correcot: ####.00");
		}
		registro.setSubtotal(calcularSubtotalPago(tipoVehiculo, horas));
		registro.setTotal(calcularSubtotalPago(tipoVehiculo, horas));
		registro.setHorasParqueadas(horas);
		//para descuento
		if (registro.getCliente().getContadorHorasDescuento() >= Parqueo.HORAS_PARA_DESCUENTO) {
			registro.setConDescuento(true);
			registro.setTotal(registro.getSubtotal() - (registro.getSubtotal() * Parqueo.PORCENTAJE_DESCUENTO));
			registro.getCliente().getRegistrosDescuentos().add(registro);
			registro.getCliente().setContadorHorasDescuento(0);
		} else {
			registro.getCliente().setContadorHorasDescuento(registro.getCliente().getContadorHorasDescuento() + horas);
		}
		parqueo.retirarVehiculo(tipoVehiculo);
		return registro;
	}

	/**
	 * Calcula el subtotal a pagar de acuerdo a las horas y al tipo del vechiculo
	 *
	 * @param tipoVehiculo
	 * @param horas
	 * @return
	 */
	public double calcularSubtotalPago(int tipoVehiculo, double horas) {
		double tarifa;
		double tarifaFraccion;
		double subtotal;
		switch (tipoVehiculo) {
			case Parqueo.VEHICULO_MOTO:
				tarifa = Parqueo.TARIFA_MOTOS;
				tarifaFraccion = Parqueo.TARIFA_MOTOS_FRACCION;
				break;
			case Parqueo.VEHICULO_CARRO:
				tarifa = Parqueo.TARIFA_CARROS;
				tarifaFraccion = Parqueo.TARIFA_CARROS_FRACCION;
				break;
			case Parqueo.VEHICULO_CAMION:
				tarifa = Parqueo.TARIFA_CAMIONES;
				tarifaFraccion = Parqueo.TARIFA_CAMIONES_FRACCION;
				break;
			default:
				tarifa = 0;
				tarifaFraccion = 0;
		}
		subtotal = Math.floor(horas) * tarifa;
		if (horas % 1 > 0) {
			subtotal += tarifaFraccion;
		}
		return subtotal;
	}
}

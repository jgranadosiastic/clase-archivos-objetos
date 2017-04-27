package parqueo.backend.reportes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import parqueo.backend.excepciones.ValidacionExcepcion;
import parqueo.backend.modelos.parqueo.Parqueo;
import parqueo.backend.modelos.registros.RegistroVehiculo;

/**
 * PracticaGUI
 * @author jose - 20.04.2017 
 * @Title: Reporteador
 * @Description: description
 *
 * Changes History
 */
public class Reporteador {
	private Parqueo parqueo;

	public Reporteador(Parqueo parqueo) {
		this.parqueo = parqueo;
	}
	
	public List<RegistroVehiculo> obtenerReporte2(String fechaInicioStr, String fechaFinStr) throws ValidacionExcepcion {
		LocalDate fechaInicio;
		LocalDate fechaFin;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(Parqueo.FORMATO_FECHA);
		List<RegistroVehiculo> registrosADevolver = new ArrayList<>();
		try {
			fechaInicio = LocalDate.parse(fechaInicioStr, formato);
			fechaFin = LocalDate.parse(fechaFinStr, formato);
			
			for (RegistroVehiculo registro : parqueo.getRegistros()) {
				LocalDate fechaReg = registro.getFechaIngreso();
				if ((fechaReg.isAfter(fechaInicio)
					   || fechaReg.isEqual(fechaInicio))
					   && (fechaReg.isBefore(fechaFin)
					   || fechaReg.isEqual(fechaFin))) {
					registrosADevolver.add(registro);
				}
			}
		} catch (DateTimeParseException e) {
			throw new ValidacionExcepcion("Esa su fecha no sirve uste!");
		}
		return registrosADevolver;
	}
	
	public double obtenerSumaTotales(List<RegistroVehiculo> registrosADevolver) {
		double total = 0;
		for (RegistroVehiculo registroVehiculo : registrosADevolver) {
			total += registroVehiculo.getTotal();
		}
		return total;
	}
}
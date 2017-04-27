package parqueo.backend.personas.clientes;

import java.util.List;
import parqueo.backend.excepciones.InputsVaciosException;
import parqueo.backend.excepciones.ValidacionExcepcion;
import parqueo.backend.modelos.parqueo.Parqueo;
import parqueo.backend.modelos.personas.Cliente;
import parqueo.backend.modelos.personas.Persona;
import parqueo.backend.personas.ManejadorPersonas;

/**
 * PracticaGUI
 *
 * @author jose - 10.04.2017
 * @Title: ManejadorClientes
 * @Description: description
 *
 * Changes History
 */
public class ManejadorClientes extends ManejadorPersonas {

	public ManejadorClientes(Parqueo parqueo) {
		super(parqueo);
	}

	public List<Persona> buscarClientes() {
		return getParqueo().getClientes();
	}

	public Cliente agregarCliente(String NIT, String CUI, String nombre) throws ValidacionExcepcion, InputsVaciosException {
		if (NIT.isEmpty() ||
			   CUI.isEmpty() ||
			   nombre.isEmpty()) {
			throw new InputsVaciosException("DEBE LLENAR TODOS LOS CAMPOS!!!!");
		}
		if (buscarPorCUI(CUI, getParqueo().getClientes()) != null) {
			throw new ValidacionExcepcion("Ya existe cliente con ese CUI: " + CUI);
		}
		if (buscarPorNIT(NIT) != null) {
			throw new ValidacionExcepcion("Ya existe cliente con ese NIT: " + NIT);
		}
		Cliente nuevo = new Cliente(NIT, CUI, nombre);
		this.agregarPersona(nuevo, getParqueo().getClientes());
		return nuevo;
	}

	public Cliente modificarCliente(String nitOriginal, String cuiOriginal, Cliente modificado) throws ValidacionExcepcion {
		if (buscarPorCUI(modificado.getCUI(), getParqueo().getClientes()) != null
			   && !modificado.getCUI().equalsIgnoreCase(cuiOriginal)) {
			throw new ValidacionExcepcion("Ya existe cliente con ese CUI: " + modificado.getCUI());
		}
		if (buscarPorNIT(modificado.getNIT()) != null
			   && !modificado.getNIT().equalsIgnoreCase(nitOriginal)) {
			throw new ValidacionExcepcion("Ya existe cliente con ese NIT: " + modificado.getNIT());
		}
		Cliente cliente = (Cliente) buscarPorCUI(cuiOriginal, getParqueo().getClientes());
		cliente.setNIT(modificado.getNIT());
		cliente.setCUI(modificado.getCUI());
		cliente.setNombre(modificado.getNombre());
		return cliente;
	}

	public Cliente buscarPorNIT(String NIT) {
		for (Persona persona : getParqueo().getClientes()) {
			Cliente cliente = (Cliente) persona;
			if (cliente.getNIT().equalsIgnoreCase(NIT)) {
				return cliente;
			}
		}
		return null;
	}
}

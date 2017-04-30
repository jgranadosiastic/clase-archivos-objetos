package parqueo.backend.personas.clientes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parqueo.backend.datos.ManejadorDatos;
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
	
	private static final String ARCHIVO_CLIENTES = "clientes.dat";
	private File archivoClientes;
	private ManejadorDatos<Persona> manejadorDatos;

	public ManejadorClientes(Parqueo parqueo) {
		super(parqueo);
		archivoClientes = new File(ARCHIVO_CLIENTES);
		manejadorDatos = new ManejadorDatos<>();
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
		try {
			manejadorDatos.guardarLista(getParqueo().getClientes(), archivoClientes);
		} catch (IOException ex) {
			//error archivo
		}
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
		try {
			manejadorDatos.guardarLista(getParqueo().getClientes(), archivoClientes);
		} catch (IOException ex) {
			Logger.getLogger(ManejadorClientes.class.getName()).log(Level.SEVERE, null, ex);
		}
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
	
	public void cargarListadoClientes() {
		try {
			getParqueo().setClientes(manejadorDatos.cargarLista(archivoClientes));
		} catch (IOException ex) {
			Logger.getLogger(ManejadorClientes.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

package parqueo.backend.personas;

import java.util.List;
import parqueo.backend.modelos.parqueo.Parqueo;
import parqueo.backend.modelos.personas.Persona;

/**
 * PracticaGUI
 *
 * @author jose - 10.04.2017
 * @Title: ManejadorPersonas
 * @Description: description
 *
 * Changes History
 */
public abstract class ManejadorPersonas {

	private Parqueo parqueo;

	public ManejadorPersonas(Parqueo parqueo) {
		this.parqueo = parqueo;
	}

	public Parqueo getParqueo() {
		return parqueo;
	}

	public void setParqueo(Parqueo parqueo) {
		this.parqueo = parqueo;
	}

	/**
	 * Busca una persona por CUI
	 *
	 * @param CUI
	 * @param personas
	 * @return
	 */
	public Persona buscarPorCUI(String CUI, List<Persona> personas) {
		for (Persona persona : personas) {
			if (persona.getCUI().equalsIgnoreCase(CUI)) {
				return persona;
			}
		}
		return null;
	}
	
	public Persona agregarPersona(Persona persona, List<Persona> personas) {
		personas.add(persona);
		return persona;
	}
}

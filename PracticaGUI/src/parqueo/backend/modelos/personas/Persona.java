package parqueo.backend.modelos.personas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * PracticaGUI
 * @author jose - 08.04.2017 
 * @Title: Persona
 * @Description: description
 *
 * Changes History
 */
public class Persona {
	private String CUI;
	private String nombre;
	private String direccion;
	
	public static final String PROP_CUI = "CUI";
	public static final String PROP_NOMBRE = "nombre";
	
	protected PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

	public Persona() {
	}

	
	public Persona(String CUI, String nombre) {
		this.CUI = CUI;
		this.nombre = nombre;
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String CUI) {
		this.CUI = CUI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		String anterior = this.nombre;
		this.nombre = nombre;
		propertySupport.firePropertyChange(PROP_NOMBRE, anterior, nombre);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	/**
	 * Metodo especifico para agregar un escucha de cambios
	 *
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}

	/**
	 * Metodo especifico para quitar un escucha de cambios
	 *
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}
	
}
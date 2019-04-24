package pe.edu.unmsm.tesis.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.json.JSONObject;

public class Sintoma {

	private String criterio;
	private String nombre;
	private String detalle;
	private int duracion;
	private int peso;
	
	
	public Sintoma() {
		
	}
	
	public Sintoma(String criterio, String nombre, String detalle, int duracion, int peso) {
		this.criterio = criterio;
		this.nombre = nombre;
		this.detalle = detalle;
		this.duracion = duracion;
		this.peso = peso;
	}

	public String toString() {
		return (new JSONObject(this)).toString();
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDetalle() {
		return detalle;
	}



	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}



	public int getDuracion() {
		return duracion;
	}



	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
}

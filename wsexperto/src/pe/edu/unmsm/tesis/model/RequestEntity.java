package pe.edu.unmsm.tesis.model;

import java.util.List;

import org.json.JSONObject;

public class RequestEntity {

	private List<Sintoma> sintomas;
	
	
	public String toString() {
		return (new JSONObject(this)).toString();
	}


	public List<Sintoma> getSintomas() {
		return sintomas;
	}


	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}
}

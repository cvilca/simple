package pe.edu.unmsm.tesis.core;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import pe.edu.unmsm.tesis.model.CatalogoSintomas;
import pe.edu.unmsm.tesis.model.Sintoma;

public class Parser {

	private List<Sintoma> listSintomas;
	private static final String SIMPLE_INITIAL_FACT = "(sintoma (criterio X_1) (nombre Y_2) (peso Z_3)) ";
	
	public Parser(List<Sintoma> listSintomas) {
		this.listSintomas = listSintomas;
	}
	
	public String getInitialFacts() {
		StringBuilder initialFacts = new StringBuilder("(deffacts sintomas-iniciales ");
		Sintoma s = null;
		try {
			for(int i =0; i < listSintomas.size(); i++) {
				s = listSintomas.get(i);
				if(!s.getNombre().isEmpty())	{
					initialFacts.append(getSimpleFactByNombre(s.getNombre()));
				}	
			}
			initialFacts.append(getDefaultFacts());
			initialFacts.append(")");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return initialFacts.toString();
	}
	
	private String getSimpleFactByNombre(String nombre) {
		Sintoma sintoma = null;
		String simpleFact = null;
		try {
			for(int i=0; i<CatalogoSintomas.catalogo.length;i++) {
				sintoma = CatalogoSintomas.catalogo[i];
				if(nombre.equals(sintoma.getNombre())) {
					simpleFact = SIMPLE_INITIAL_FACT.replaceAll("X_1", sintoma.getCriterio())
													.replaceAll("Y_2", sintoma.getNombre())
													.replaceAll("Z_3", sintoma.getPeso()+"");
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sintoma = null;
		}
		return simpleFact;
	}
	
	private String getDefaultFacts() {
		return " (puntaje A 0) (puntaje B 0) (puntaje C 0)";
	}
}

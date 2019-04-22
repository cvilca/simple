package pe.edu.unmsm.tesis;

import java.util.Iterator;

import jess.Fact;
import jess.Rete;

public class Ejecutor {

	private static Rete motor;
	
	public Ejecutor() {
		try {
			motor = new Rete();
			motor.batch("esquizofrenia2.clp");	
			motor.executeCommand("(reset)");
			motor.executeCommand("(run)");	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getFacts() {
		StringBuilder hechos = new StringBuilder("Sin diagnóstico");
		Fact fact=null;
		try {
			Iterator ite = motor.listFacts();
			while(ite.hasNext()) {
				fact = (Fact) ite.next();
				if(fact.getName().equals("MAIN::diagnostico")) {
					System.out.println(fact.getSlotValue("valor"));
					hechos = new StringBuilder(fact.getSlotValue("valor").toString());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return hechos.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("iniciando SE");
		Ejecutor e = new Ejecutor();
		Fact fact=null;
		try {
			e.motor.executeCommand("(reset)");
			e.motor.executeCommand("(run)");	
			Iterator ite = motor.listFacts();
			while(ite.hasNext()) {
				fact = (Fact) ite.next();
				if(fact.getName().equals("MAIN::diagnostico")) {
					System.out.println(fact.getSlotValue("valor"));	
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}

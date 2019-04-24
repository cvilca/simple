package pe.edu.unmsm.tesis.model;

public class CatalogoSintomas {

	public static final String CRITERIO_A = "A";
	public static final String CRITERIO_B = "B";
	public static final String CRITERIO_C = "C";
	public static final String CRITERIO_D = "D";
	public static final String CRITERIO_E = "E";
	
	public static Sintoma[] catalogo = new Sintoma[] {
		new Sintoma(CRITERIO_A, "ideas-delirantes", "", 6, 2),
		new Sintoma(CRITERIO_A, "alucinaciones", "", 6, 1),
		new Sintoma(CRITERIO_A, "lenguaje-desorganizado", "", 6, 1),
		new Sintoma(CRITERIO_A, "comportamiento-catatonico", "", 6, 1),
		
		new Sintoma(CRITERIO_B, "disfuncion-laboral", "", 6, 1),
		new Sintoma(CRITERIO_B, "disfuncion-interpersonal", "", 6, 1),
		new Sintoma(CRITERIO_B, "disfuncion-personal", "", 6, 1),
		
		new Sintoma(CRITERIO_C, "no-consume-medicamentos", "", 6, 1)
	};
	
	
}

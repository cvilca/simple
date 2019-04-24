(deftemplate sintoma
	(slot criterio)
	(slot nombre)
	(slot peso)
)

(deftemplate diagnostico
	(slot valor)
)

;;(deffacts sintomas-iniciales
	;;(sintoma (criterio A) (nombre ideas-delirantes) (peso 2))
	;;(sintoma (criterio A) (nombre alucinaciones) (peso 1))
	;;(sintoma (criterio A) (nombre lenguaje-desorganizado) (peso 1))
	;;(sintoma (criterio A) (nombre comportamiento-catatonico) (peso 1))
	;;(sintoma (criterio A) (nombre sintomas-negativos) (peso 1))
	;;(sintoma (criterio B) (nombre disfuncion-laboral) (peso 1))
	;;(sintoma (criterio B) (nombre disfuncion-interpersonal) (peso 1))
	;;(sintoma (criterio B) (nombre disfuncion-personal) (peso 1))
	;;(sintoma (criterio C) (nombre no-consume-medicamentos) (peso 1))
	;;(puntaje A 0)
	;;(puntaje B 0)
	;;(puntaje C 0)
;;)


(defrule suma-sintomas-a
	(sintoma (criterio ?x) (nombre ?y) (peso ?z))
	=>
	(assert (suma-criterio ?x ?z))
)

(defrule suma-criterios-totales
	?nueva-area <- (suma-criterio ?criterio ?peso)
	?suma <- (puntaje ?criterio ?total)
	=>
	(retract ?suma ?nueva-area)
	(assert (puntaje ?criterio (+ ?total ?peso)))
)

(defrule imprimir-salida
	(declare (salience -1)) 
	(puntaje ?criterio ?total)	
	=>
	(printout t "TOTAL "?criterio " es: " ?total crlf)
)

(defrule evaluando-diagnostico
	(declare (salience -2)) 
	(puntaje ?criterioA&A ?puntajeA)
	(puntaje ?criterioB&B ?puntajeB)
	(test (>= ?puntajeA 2))
	(test (> ?puntajeB 0))
	=>
	(printout t "*************************" crlf)
	(printout t "DIAGNOSTICO : ESQUIZOFRENIA PARANOIDE" crlf)	
	(assert (diagnostico (valor esquizofrenia)))
)
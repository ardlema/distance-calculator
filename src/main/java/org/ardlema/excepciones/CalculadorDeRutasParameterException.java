package org.ardlema.excepciones;

public class CalculadorDeRutasParameterException extends CalculadorDeRutasException {


	public CalculadorDeRutasParameterException(
            CalculadorDeRutasExceptionType _exceptionType) {
		super(_exceptionType);
	}

	public String toString(){
	    return "CalculadorDeRutasExcepcion["+tipoDeExcepcion.toString()+"]";
	} 
}

package org.ardlema.excepciones;


public class CalculadorDeRutasException extends IllegalArgumentException {

    CalculadorDeRutasExceptionType tipoDeExcepcion;


	public CalculadorDeRutasException() {
		super();
	}


	public CalculadorDeRutasException(
            CalculadorDeRutasExceptionType _exceptionType) {
        tipoDeExcepcion = _exceptionType;
	}
	

	public CalculadorDeRutasExceptionType getExceptionType(){
		return tipoDeExcepcion;
	}
	
}

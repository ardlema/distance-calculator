package org.ardlema.excepciones;

public enum CalculadorDeRutasExceptionType {

		CIUDAD_NO_VALIDA_EXCEPTION ("La ciudad introducida no existe en el mapa.");

		private String descripcion;

		private CalculadorDeRutasExceptionType(String descripcionDeLaExcepcion) {
			this.descripcion = descripcionDeLaExcepcion;
		}
		

		@Override
		public String toString() {
			return this.descripcion;
		}
		

}

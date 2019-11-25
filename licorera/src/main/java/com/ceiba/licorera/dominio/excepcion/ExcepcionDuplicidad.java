package com.ceiba.licorera.dominio.excepcion;

public class ExcepcionDuplicidad extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ExcepcionDuplicidad(String mensaje) {
        super(mensaje);
    }
}

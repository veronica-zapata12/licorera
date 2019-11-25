package com.ceiba.licorera.dominio.excepcion;

public class ExcepcionHora extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ExcepcionHora(String mensaje) {
        super(mensaje);
    }

}

package com.ceiba.licorera.dominio.excepcion;

public class ExcepcionFecha extends RuntimeException {
    private static final long serialVersionUID  = 1L;

    public ExcepcionFecha(String mensaje) {
        super(mensaje);
    }
}

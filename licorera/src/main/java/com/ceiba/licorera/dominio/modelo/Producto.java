package com.ceiba.licorera.dominio.modelo;

import com.ceiba.licorera.dominio.validador.ValidadorDeArgumento;

public class Producto {
    private static final String EL_NOMBRE_ES_OBLIGATORIO = "el nombre es obligatorio";
    private static final String EL_VALOR_ES_OBLIGATORIO = "el valor es obligatorio";
    private Long idProducto;
    private String nombre;
    private Double valor;

    public Producto( Long idProducto,String nombre, Double valor) {
        ValidadorDeArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarObligatorio(valor, EL_VALOR_ES_OBLIGATORIO);
        this.idProducto =idProducto;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}

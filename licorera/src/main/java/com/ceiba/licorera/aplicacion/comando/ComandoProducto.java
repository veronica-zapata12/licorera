package com.ceiba.licorera.aplicacion.comando;

public class ComandoProducto {
    private  Long id;
    private String nombre;
    private Double valor;

    public ComandoProducto(Long id, String nombre, Double valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

}

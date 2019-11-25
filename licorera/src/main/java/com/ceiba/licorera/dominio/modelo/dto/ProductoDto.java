package com.ceiba.licorera.dominio.modelo.dto;

public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private Double valor;

    public ProductoDto() {
    }

    public ProductoDto(Long idProducto, String nombre, Double valor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

package com.ceiba.licorera.dominio.modelo.dto;

public class DetallefacturaDto {
    private int cantidad;
    private ProductoDto producto;

    public DetallefacturaDto() {
    }

    public DetallefacturaDto(int cantidad, ProductoDto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }
}

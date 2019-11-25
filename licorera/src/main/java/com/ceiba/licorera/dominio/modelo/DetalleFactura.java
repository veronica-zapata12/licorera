package com.ceiba.licorera.dominio.modelo;

public class DetalleFactura {
    private int cantidad;
    private Producto producto;


    public DetalleFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;

    }

    public int getCantidad() {
        return cantidad;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double cacularValorParcial() {

        return cantidad * producto.getValor();

    }
}

package com.ceiba.licorera.TestDominio.DetalleFactura;

import com.ceiba.licorera.TestDominio.Producto.ProductoDataBuilder.ProductoDataBuilder;
import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import com.ceiba.licorera.dominio.modelo.Producto;

public class FacturaDetalleDataBuilder {
    private final int CANTIDAD = 2;
    private int cantidad;
    private Producto producto;

    public FacturaDetalleDataBuilder() {
        this.cantidad = CANTIDAD;
        producto = new ProductoDataBuilder().build();
    }
    public DetalleFactura build() {
        return new DetalleFactura(this.cantidad, this.producto);

    }
}

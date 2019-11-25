package com.ceiba.licorera.TestDominio.Factura;

import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class FacturaDataBuilder {
    private static final Long ID = 1L;
    private Long id;
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();

    public FacturaDataBuilder() {
        this.id = ID;
        Producto producto1 = new Producto( 1L,"vodka", 55000.0);
        int cantidad1 = 3;
        DetalleFactura detalleFactura = new DetalleFactura(cantidad1, producto1);
        detalleFacturas.add(detalleFactura);
        Producto producto2 = new Producto( 1L,"ron", 40000.0);
        int cantidad2 = 4;
        DetalleFactura detalleFactura2 = new DetalleFactura(cantidad2, producto2);
        detalleFacturas.add(detalleFactura2);
    }

    public Factura build() {
        return new Factura(this.id, this.detalleFacturas);
    }
}

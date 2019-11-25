package com.ceiba.licorera.TestDominio.Producto.ProductoDataBuilder;

import com.ceiba.licorera.dominio.modelo.Producto;

public class ProductoDataBuilder {
    private static final Long ID = 1L;
    private static final String NOMBRE = "cerveza pilsen";
    private static final Double VALOR = 35000.00;
    private Long id;
    private String nombre;
    private Double valor;

    public ProductoDataBuilder() {
        this.id = ID;
        this.nombre = NOMBRE;
        this.valor = VALOR;
    }

    public ProductoDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;

    }

    public ProductoDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ProductoDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Producto build() {
        return new Producto( this.id,this.nombre, this.valor);
    }
}

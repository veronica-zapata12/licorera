package com.ceiba.licorera.TestAplicacion.Comando.ComandoProductoTest;

import com.ceiba.licorera.aplicacion.comando.ComandoProducto;

public class ProductoComandoDataBuilder {
    private  Long id;
    private String nombre;
    private Double valor;
public ProductoComandoDataBuilder(){
    id=1L;
    nombre="tequila jose cuervo";
    valor=65000.0;
}
public ComandoProducto build(){
    return new ComandoProducto(id,nombre,valor);
}
}

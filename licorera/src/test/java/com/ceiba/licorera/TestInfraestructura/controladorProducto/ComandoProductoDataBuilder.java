package com.ceiba.licorera.TestInfraestructura.controladorProducto;

import com.ceiba.licorera.aplicacion.comando.ComandoProducto;

public class ComandoProductoDataBuilder {
    private Long id;
    private String nombre;
    private Double valor;

    public ComandoProductoDataBuilder() {

        this.nombre="cerveza";
        this.valor=45000.0;
    }
    public  ComandoProductoDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public ComandoProducto build(){
        return  new ComandoProducto(id, this.nombre,this.valor);
    }
}

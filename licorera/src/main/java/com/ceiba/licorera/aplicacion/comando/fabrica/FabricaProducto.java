package com.ceiba.licorera.aplicacion.comando.fabrica;

import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import com.ceiba.licorera.dominio.modelo.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(comandoProducto.getId(),comandoProducto.getNombre(), comandoProducto.getValor());
    }
}

package com.ceiba.licorera.aplicacion.comando.manejador.producto;

import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import com.ceiba.licorera.aplicacion.comando.fabrica.FabricaProducto;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.servicio.producto.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProducto {
    private final ServicioCrearProducto servicioCrearProducto;
    private final FabricaProducto fabricaProducto;

    public ManejadorCrearProducto(ServicioCrearProducto servicioCrearProducto, FabricaProducto fabricaProducto) {
        this.servicioCrearProducto = servicioCrearProducto;
        this.fabricaProducto = fabricaProducto;
    }

    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        this.servicioCrearProducto.ejecutar(producto);
    }
}

package com.ceiba.licorera.aplicacion.comando.manejador.producto;

import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.dominio.servicio.producto.ServicioConsultarProductos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarProductos {
    private final ServicioConsultarProductos servicioConsultarProductos;

    public ManejadorConsultarProductos(ServicioConsultarProductos servicioConsultarProductos) {
        this.servicioConsultarProductos = servicioConsultarProductos;
    }

    public List<ProductoDto> ejecutar() {
        return this.servicioConsultarProductos.ejecutar();
    }
    public List<ProductoDto> buscarpornombre(String nombre){
        return servicioConsultarProductos.buscarnombre(nombre);
    }
}

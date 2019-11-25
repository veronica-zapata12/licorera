package com.ceiba.licorera.dominio.servicio.producto;

import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioConsultarProductos {
    private RepositorioProducto repositorioProducto;

    public ServicioConsultarProductos(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public List<ProductoDto> ejecutar() {
        return this.repositorioProducto.obtenerProductos();
    }

public List<ProductoDto> buscarnombre(String nombre){
    return this.repositorioProducto.buscarPornombre(nombre);
}
}
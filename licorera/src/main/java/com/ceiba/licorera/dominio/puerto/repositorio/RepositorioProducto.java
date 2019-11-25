package com.ceiba.licorera.dominio.puerto.repositorio;


import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;

import java.util.List;

public interface RepositorioProducto {
    void crear(Producto producto);

    boolean existe(Producto producto);

    List<ProductoDto> buscarPornombre(String nombre);

    Double obtenerValorporNombre(String nombre);

    List<ProductoDto> obtenerProductos();
}

package com.ceiba.licorera.TestDominio.Producto.ProductoTest;

import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioProducto;
import com.ceiba.licorera.dominio.servicio.producto.ServicioConsultarProductos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ProductoServicioConsultarProductos {
    private List<ProductoDto>productoDtoList=new ArrayList<>();
    @Test
    void obtenerProductos(){
        RepositorioProducto repositorioProducto=mock(RepositorioProducto.class);
        ProductoDto producto1 = new ProductoDto(1L, "vodka", 55000.0);
        productoDtoList.add(producto1);
        ProductoDto producto2 = new ProductoDto(1L, "ron", 40000.0);
        productoDtoList.add(producto2);
        Mockito.when(repositorioProducto.obtenerProductos()).thenReturn(productoDtoList);
        //act
        ServicioConsultarProductos servicioConsultarProductos=new ServicioConsultarProductos(repositorioProducto);
        List<ProductoDto>resultado=servicioConsultarProductos.ejecutar();
        //assert
        Assertions.assertFalse(resultado.isEmpty());
    }
    @Test
    void obtenerProductoPornombre(){
        RepositorioProducto repositorioProducto=mock(RepositorioProducto.class);
        ProductoDto producto = new ProductoDto(1L, "vodka", 55000.0);
       // Mockito.when(repositorioProducto.buscarPornombre(producto.getNombre())).thenReturn(producto);
        //act
        ServicioConsultarProductos servicioConsultarProductos=new ServicioConsultarProductos(repositorioProducto);
       // ProductoDto resultado=servicioConsultarProductos.buscarnombre(producto.getNombre());
        //assert
        //Assertions.assertFalse(resultado ==null);
    }
}

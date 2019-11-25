package com.ceiba.licorera.TestDominio.Producto.ProductoTest;

import com.ceiba.licorera.TestDominio.Producto.ProductoDataBuilder.ProductoDataBuilder;
import com.ceiba.licorera.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.licorera.dominio.excepcion.ExcepcionGeneral;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioProducto;
import com.ceiba.licorera.dominio.servicio.producto.ServicioCrearProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class ProductoServicioCrearTest {
    @Test
    void Validarsiexiste() {
        try {
            //arrange
            Producto producto = new ProductoDataBuilder().build();
            RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
            Mockito.when(repositorioProducto.existe(Mockito.any())).thenReturn(true);
            ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
            //act

            servicioCrearProducto.ejecutar(producto);
            Assertions.fail("esperaba que lanzara la excepcion de que ya existe");
        } catch (ExcepcionDuplicidad e) {
            //assert
            Assertions.assertEquals("el producto ya existe", e.getMessage());

        }
    }

    @Test
    void crearProductoValido() {
        //Arrange
        Producto producto = new ProductoDataBuilder().build();
        RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.any())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        try {
            //act
            servicioCrearProducto.ejecutar(producto);

        } catch (ExcepcionGeneral e) {
            Assertions.fail("error en la creacion del producto");
        }
    }

    @Test
    void CrearProductonulo() {
        //Arrange
        RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.any())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        try {
            //act
            servicioCrearProducto.ejecutar(null);
            Assertions.fail("se esperaba la excepcion error en la creacion del producto");

        } catch (ExcepcionGeneral e) {
            //Assert
            Assertions.assertEquals("error en la creacion", e.getMessage());

        }
    }
}

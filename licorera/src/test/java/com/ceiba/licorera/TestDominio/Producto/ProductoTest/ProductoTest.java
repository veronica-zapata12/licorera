package com.ceiba.licorera.TestDominio.Producto.ProductoTest;

import com.ceiba.licorera.TestDominio.Producto.ProductoDataBuilder.ProductoDataBuilder;
import com.ceiba.licorera.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.licorera.dominio.modelo.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductoTest {
    private static final String NOMBRE = "cerveza pilsen";
    private static final Double VALOR = 35000.00;

    @Test
    void NombreNulo() {
        //arrange
        ProductoDataBuilder productoDataBuilder = new ProductoDataBuilder()
                .conNombre(null);
        try {
            //act
            Producto producto = productoDataBuilder.build();
            Assertions.fail("se esperaba que lanzara la excepcion de nombre obligatorio");
        } catch (ExcepcionValorObligatorio e) {
            //assert
            Assertions.assertEquals("el nombre es obligatorio", e.getMessage());

        }
    }

    @Test
    void nombreValido() {
        //arrange
        ProductoDataBuilder productoDataBuilder = new ProductoDataBuilder();
        //act
        Producto producto = productoDataBuilder.build();
        //assert
        Assertions.assertEquals(NOMBRE, producto.getNombre());
    }

    @Test
    void valorInvalido() {
        //arrange
        ProductoDataBuilder productoDataBuilder = new ProductoDataBuilder()
                .conValor(null);
        try {
            //act
            Producto producto = productoDataBuilder.build();
            Assertions.fail("se esperaba la excepcion de valor obligatorio");
        } catch (ExcepcionValorObligatorio e) {
            //assert
            Assertions.assertEquals("el valor es obligatorio", e.getMessage());
        }
    }

    @Test
    void valorValido() {
        //arrange
        ProductoDataBuilder productoDataBuilder = new ProductoDataBuilder();
        //act
        Producto producto = productoDataBuilder.build();
        //assert
        Assertions.assertEquals(VALOR, producto.getValor());

    }
    @Test
    void setter(){
        //arrange
        ProductoDataBuilder productoDataBuilder = new ProductoDataBuilder();
        //act
        Producto producto = productoDataBuilder.build();
        producto.setNombre("ron");
        producto.setIdProducto(100L);
        producto.setValor(35000.0);
        //assert
        Assertions.assertEquals(35000.0, producto.getValor());
        Assertions.assertEquals(100L, producto.getIdProducto());
        Assertions.assertEquals("ron", producto.getNombre());



    }

}

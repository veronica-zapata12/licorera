package com.ceiba.licorera.TestAplicacion.Comando.Manejador;

import com.ceiba.licorera.TestInfraestructura.controladorProducto.controladorProductoDataBuider.ComandoProductoDataBuilder;
import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import com.ceiba.licorera.aplicacion.comando.fabrica.FabricaProducto;
import com.ceiba.licorera.aplicacion.comando.manejador.producto.ManejadorCrearProducto;
import com.ceiba.licorera.dominio.servicio.producto.ServicioCrearProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class ManejadorCrearproductoTest {
@Test
    void ejecutar(){
    //arrange
    ComandoProducto comandoProducto= new ComandoProductoDataBuilder().build();
    ServicioCrearProducto servicioCrearProducto= mock(ServicioCrearProducto.class);
    FabricaProducto fabricaProducto=new FabricaProducto();
    //act
    ManejadorCrearProducto manejadorCrearProducto=new ManejadorCrearProducto(servicioCrearProducto,fabricaProducto);
    //assert
    Assertions.assertDoesNotThrow(() -> manejadorCrearProducto.ejecutar(comandoProducto));
}
}

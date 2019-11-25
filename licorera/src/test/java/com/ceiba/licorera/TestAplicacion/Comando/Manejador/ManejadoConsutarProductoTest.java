package com.ceiba.licorera.TestAplicacion.Comando.Manejador;

import com.ceiba.licorera.TestInfraestructura.controladorProducto.controladorProductoDataBuider.ComandoProductoDataBuilder;
import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import com.ceiba.licorera.aplicacion.comando.manejador.producto.ManejadorConsultarProductos;
import com.ceiba.licorera.dominio.servicio.producto.ServicioConsultarProductos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ManejadoConsutarProductoTest {
@Test
    void consultarProducto(){
    //arrange
    ComandoProducto comandoProducto = new ComandoProductoDataBuilder().build();
    List<ComandoProducto> comandoProductoList = new ArrayList<>();
    comandoProductoList.add(comandoProducto);
    ServicioConsultarProductos servicioConsultarProductos= mock(ServicioConsultarProductos.class);
    doReturn(comandoProductoList).when(servicioConsultarProductos).ejecutar();
    //act
    ManejadorConsultarProductos manejadorConsultarProductos= new ManejadorConsultarProductos(servicioConsultarProductos);
    //assert
    Assertions.assertFalse(manejadorConsultarProductos.ejecutar().isEmpty());
}
}

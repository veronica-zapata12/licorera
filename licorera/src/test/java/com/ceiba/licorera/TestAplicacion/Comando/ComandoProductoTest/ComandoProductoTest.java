package com.ceiba.licorera.TestAplicacion.Comando.ComandoProductoTest;

import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComandoProductoTest {
@Test
    void construirComando(){
    ComandoProducto comandoProducto= new ProductoComandoDataBuilder().build();
    Assertions.assertNotNull(comandoProducto.getId());
    Assertions.assertNotNull(comandoProducto.getNombre());
    Assertions.assertNotNull(comandoProducto.getValor());
}


}

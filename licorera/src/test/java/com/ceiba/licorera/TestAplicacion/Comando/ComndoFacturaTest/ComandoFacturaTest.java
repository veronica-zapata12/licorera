package com.ceiba.licorera.TestAplicacion.Comando.ComndoFacturaTest;

import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComandoFacturaTest {
    @Test
    void construircomando(){
        ComandoFactura comandoFactura=new ComandoFacturaDataBuider().build();
        Assertions.assertNotNull(comandoFactura.getId());
        Assertions.assertNotNull(comandoFactura.getFecha());
        Assertions.assertNotNull(comandoFactura.getDetalleFacturas());

    }
}

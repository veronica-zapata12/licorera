package com.ceiba.licorera.TestAplicacion.Comando.Manejador;

import com.ceiba.licorera.TestAplicacion.Comando.ComndoFacturaTest.ComandoFacturaDataBuider;
import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.aplicacion.comando.fabrica.FabricaFactura;
import com.ceiba.licorera.aplicacion.comando.manejador.factura.ManejadorCrearFactura;
import com.ceiba.licorera.dominio.servicio.factura.ServicioCrearFactura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class ManejadorCrearFacturaTest {
    @Test
    void crear(){
        //arrange
        ComandoFactura comandoFactura =new ComandoFacturaDataBuider().build();
        ServicioCrearFactura servicioCrearFactura  =  mock(ServicioCrearFactura.class);
        FabricaFactura fabricaFactura = new FabricaFactura();
        //act
        ManejadorCrearFactura manejadorCrearFactura =new ManejadorCrearFactura(servicioCrearFactura,fabricaFactura);
        //assert
        Assertions.assertDoesNotThrow(() -> manejadorCrearFactura.ejecutar(comandoFactura));

    }
}

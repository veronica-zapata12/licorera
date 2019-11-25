package com.ceiba.licorera.TestAplicacion.Comando.Manejador;

import com.ceiba.licorera.TestAplicacion.Comando.ComndoFacturaTest.ComandoFacturaDataBuider;
import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.aplicacion.comando.manejador.factura.ManejadorConsultarFacturas;
import com.ceiba.licorera.dominio.servicio.factura.ServicioConsultarFacturas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ManejadorConsultarFacturaTest {
    @Test
            void consultar() {
        //arrange
        ComandoFactura comandoFactura = new ComandoFacturaDataBuider().build();
        List<ComandoFactura> comandoFacturaList = new ArrayList<>();
        comandoFacturaList.add(comandoFactura);
        ServicioConsultarFacturas servicioConsultarFacturas =mock (ServicioConsultarFacturas.class);
        doReturn(comandoFacturaList).when(servicioConsultarFacturas).ejecutar();
        //act
        ManejadorConsultarFacturas manejadorConsultarFacturas = new ManejadorConsultarFacturas(servicioConsultarFacturas);
        //assert
        Assertions.assertFalse(manejadorConsultarFacturas.ejecutar().isEmpty());

    }
}

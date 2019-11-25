package com.ceiba.licorera.TestDominio.DetalleFactura;

import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDetalleFactura {
    @Test
    void calcularvalor() {
        //Arrange
        FacturaDetalleDataBuilder facturaDetalleDataBuilder = new FacturaDetalleDataBuilder();
        //Act
        DetalleFactura detalleFactura = facturaDetalleDataBuilder.build();
        //Assert
        Assertions.assertEquals(70000.00, detalleFactura.cacularValorParcial());
    }
@Test
    void obtenerCanitadad(){
    //Arrange
    FacturaDetalleDataBuilder facturaDetalleDataBuilder = new FacturaDetalleDataBuilder();
    //Act
    DetalleFactura detalleFactura = facturaDetalleDataBuilder.build();
    //Assert
    Assertions.assertEquals(2, detalleFactura.getCantidad());
    }
}

package com.ceiba.licorera.TestDominio.Factura;

import com.ceiba.licorera.dominio.modelo.Factura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFactura {
    @Test
    void calcularTotalFactura() {
        //Arrange
        FacturaDataBuilder facturaDataBuilder = new FacturaDataBuilder();
        //Act
       Factura factura = facturaDataBuilder.build();
        //Assert
       Assertions.assertEquals(292500.0, factura.getTotal());
    }

}

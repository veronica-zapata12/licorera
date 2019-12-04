package com.ceiba.licorera.TestDominio.Factura;

import com.ceiba.licorera.dominio.excepcion.ExcepcionFecha;
import com.ceiba.licorera.dominio.excepcion.ExcepcionHora;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.validador.ValidadorDeArgumento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Test
    void fechaDomingo() throws Exception{
        try{
            //arrange
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            String dateString = format.format( new Date()   );
            Date   date       = format.parse( "2019-12-8" );
            //act
            ValidadorDeArgumento.validarFecha(date,"los domingos no se vende");
            Assertions.fail("se esperaba la excepcion de los domingos no se vende ");
        }catch (ExcepcionFecha e){
            Assertions.assertEquals("los domingos no se vende", e.getMessage());

        }
    }
    @Test
    void horaMala(){
        try {
            int hora =8;
            ValidadorDeArgumento.valiarhora(hora,"antes de las 11 am no se vende");
            Assertions.fail("se esperaba la excepcion de antes de las 11 am no se vende ");

        }catch (ExcepcionHora e){
            Assertions.assertEquals("antes de las 11 am no se vende", e.getMessage());
        }
    }

}

package com.ceiba.licorera.TestDominio.Factura;

import com.ceiba.licorera.TestDominio.BasePrueba;
import com.ceiba.licorera.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.licorera.dominio.excepcion.ExcepcionGeneral;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.licorera.dominio.servicio.factura.ServicioCrearFactura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class FacturaServicioCrearTest {
    @Test
    void facturaExistente(){

            //Arrange
            Factura factura= new FacturaDataBuilder().build();
            RepositorioFactura repositorioFactura= mock(RepositorioFactura.class);
            Mockito.when(repositorioFactura.existe(Mockito.any())).thenReturn(true);
            ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
            //Act
            BasePrueba.assertThrows(() ->servicioCrearFactura.ejecutar(factura),ExcepcionDuplicidad.class,"la factura ya existe");
    }

    @Test
    void crearFacturaValida(){
        //Arrange
        Factura factura = new FacturaDataBuilder().build();
        RepositorioFactura repositorioFactura= mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.existe(Mockito.any())).thenReturn(false);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
            //BasePrueba.assertThrows(() ->servicioCrearFactura.ejecutar(factura),ExcepcionGeneral.class,"error al crear ");
            //Assert
            //Assertions.assertTrue(true);//validar que la factura quede en el repositorio


    }
}

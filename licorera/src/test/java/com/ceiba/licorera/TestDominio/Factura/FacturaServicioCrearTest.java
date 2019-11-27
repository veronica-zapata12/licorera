package com.ceiba.licorera.TestDominio.Factura;

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
        try {
            //act
            servicioCrearFactura.ejecutar(factura);
            Assertions.fail("esperaba que lanzara la excepcion de que ya existe");
        } catch (ExcepcionDuplicidad e) {
            Assertions.assertEquals("la factura ya existe en el sistema", e.getMessage());
        }

    }

    @Test
    void crearFacturaValida(){
        //Arrange
        Factura factura = new FacturaDataBuilder().build();
        RepositorioFactura repositorioFactura= mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.existe(Mockito.any())).thenReturn(false);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
        try{
            //act
            servicioCrearFactura.ejecutar(factura);
        }catch (Exception e){
            Assertions.fail("error en la creacion de la factura");

        }
    }
}

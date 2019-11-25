package com.ceiba.licorera.TestDominio.Factura;

import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioDetalleFactura;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.licorera.dominio.servicio.factura.ServicioConsultarDetallefactura;
import com.ceiba.licorera.dominio.servicio.factura.ServicioConsultarFacturas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class DetalleFacturaServicioConsultarTest {
    private static final Long ID = 1L;
    private Long idfactura;
    private List<DetallefacturaDto> detalleFacturas = new ArrayList<>();

    @Test
    void obtenerDetalle() {
        //Arrange
        RepositorioDetalleFactura repositorioDetalleFactura = mock(RepositorioDetalleFactura.class);
        this.idfactura = ID;
        ProductoDto producto = new ProductoDto(1L, "vodka", 55000.0);
        int cantidad = 2;
        DetallefacturaDto detalleFactura = new DetallefacturaDto(cantidad, producto);
        detalleFacturas.add(detalleFactura);


        Mockito.when(repositorioDetalleFactura.buscarFactura(idfactura)).thenReturn(detalleFacturas);
        //Act
        ServicioConsultarDetallefactura servicioConsultarDetallefactura = new ServicioConsultarDetallefactura(repositorioDetalleFactura);
        List<DetallefacturaDto> resultado =  servicioConsultarDetallefactura.buscarFactura(idfactura);
        //Assert
        Assertions.assertFalse(resultado.isEmpty());
    }
    @Test
    void getters(){
        //arrange
        this.idfactura = ID;
        ProductoDto producto = new ProductoDto(1L, "vodka", 55000.0);
        int cantidad = 2;
        DetallefacturaDto detalleFactura = new DetallefacturaDto(cantidad, producto);
       //act-assert
        Assertions.assertNotNull(detalleFactura.getCantidad());
        Assertions.assertNotNull(detalleFactura.getProducto());



    }


}

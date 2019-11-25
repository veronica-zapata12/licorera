package com.ceiba.licorera.TestDominio.Factura;

import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.licorera.dominio.servicio.factura.ServicioConsultarFacturas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class FacturaServicioConsultarTest {
    private static final Long ID = 1L;
    private Long idfactura;
    private List<DetallefacturaDto> detalleFacturas = new ArrayList<>();

    @Test
    void obtenerFacturas() {
        //Arrange
        RepositorioFactura repositorioFactura = mock(RepositorioFactura.class);
        this.idfactura = ID;
        ProductoDto producto1 = new ProductoDto(1L, "vodka", 55000.0);
        int cantidad1 = 2;
        DetallefacturaDto detalleFactura = new DetallefacturaDto(cantidad1, producto1);
        detalleFacturas.add(detalleFactura);
        ProductoDto producto2 = new ProductoDto(1L, "ron", 40000.0);
        int cantidad2 = 2;
        DetallefacturaDto detalleFactura2 = new DetallefacturaDto(cantidad2, producto2);
        detalleFacturas.add(detalleFactura2);
        FacturaDto facturaDto = new FacturaDto(this.idfactura, this.detalleFacturas);
        List<FacturaDto> facturaDtoList = new ArrayList<>();
        facturaDtoList.add(facturaDto);
        Mockito.when(repositorioFactura.obtenerFacturas()).thenReturn(facturaDtoList);
        //Act
        ServicioConsultarFacturas servicioConsultarFacturas = new ServicioConsultarFacturas(repositorioFactura);
        List<FacturaDto> resultado = servicioConsultarFacturas.ejecutar();
        //assert
        Assertions.assertFalse(resultado.isEmpty());

    }
    @Test
    void obtenerunafactura(){
        //Arrange
        RepositorioFactura repositorioFactura = mock(RepositorioFactura.class);
        this.idfactura = ID;
        ProductoDto producto = new ProductoDto(1L, "vodka", 55000.0);
        int cantidad = 2;
        DetallefacturaDto detalleFactura = new DetallefacturaDto(cantidad, producto);
        detalleFacturas.add(detalleFactura);
        FacturaDto facturaDto = new FacturaDto(this.idfactura, this.detalleFacturas);

        Mockito.when(repositorioFactura.buscarporidfactura(idfactura)).thenReturn(facturaDto);
        //Act
        ServicioConsultarFacturas servicioConsultarFacturas = new ServicioConsultarFacturas(repositorioFactura);
        FacturaDto resultado= servicioConsultarFacturas.buscarporid(idfactura);
        //Assert
        Assertions.assertFalse(resultado ==null);

    }
    @Test
    void getters(){
        this.idfactura = 1L;
        ProductoDto producto1 = new ProductoDto(1L, "vodka", 55000.0);
        int cantidad1 = 2;
        DetallefacturaDto detalleFactura = new DetallefacturaDto(cantidad1, producto1);
        detalleFacturas.add(detalleFactura);
        ProductoDto producto2 = new ProductoDto(1L, "ron", 40000.0);
        int cantidad2 = 2;
        DetallefacturaDto detalleFactura2 = new DetallefacturaDto(cantidad2, producto2);
        detalleFacturas.add(detalleFactura2);
        FacturaDto facturaDto = new FacturaDto(this.idfactura, this.detalleFacturas);
        Assertions.assertNotNull(facturaDto.getId());
        Assertions.assertNotNull(facturaDto.getDetalleFacturas());
        Assertions.assertNull(facturaDto.getFecha());
        Assertions.assertNotNull(facturaDto.getTotal());
    }

}

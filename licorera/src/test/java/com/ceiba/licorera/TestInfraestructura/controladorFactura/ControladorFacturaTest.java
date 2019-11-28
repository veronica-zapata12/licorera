package com.ceiba.licorera.TestInfraestructura.controladorFactura;

import com.ceiba.licorera.LicoreraApplication;
import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.infraestructura.repositorio.DetalleFacturaRepositorio;
import com.ceiba.licorera.infraestructura.repositorio.FacturaRepositorio;
import com.ceiba.licorera.infraestructura.repositorio.ProductoRepositorio;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.AdaptadorDetalleFacturaJpa;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.AdaptadorFacturaJpa;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.AdaptadorProductoJpa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LicoreraApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ControladorFacturaTest {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private FacturaRepositorio facturaRepositorio;
    @Autowired
    private AdaptadorDetalleFacturaJpa adaptadorDetalleFacturaJpa;
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void crearFactura() throws Exception {
        //arrange
        ComandoFactura comandoFactura = new ComandoFacturaDataBuilder().build();
        comandoFactura.setTotal(292500.0);
        //Act-Assert
        mockMvc.perform(post("http://localhost:8080/factura")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoFactura))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listarFacturas() throws Exception {
        //arrange
        AdaptadorProductoJpa adaptadorProductoJpa = new AdaptadorProductoJpa(productoRepositorio);
        AdaptadorFacturaJpa adaptadorFacturaJpa = new AdaptadorFacturaJpa(facturaRepositorio, adaptadorDetalleFacturaJpa);
        List<FacturaDto> facturaDtoList = new ArrayList<>();
        List<DetalleFactura> detalleFacturas = new ArrayList<>();
    Long id = 1L;
    Producto producto1 = new Producto(1L, "vodka", 55000.0);
        adaptadorProductoJpa.crear(producto1);
    int cantidad1 = 3;
    DetalleFactura detalleFactura = new DetalleFactura(cantidad1, producto1);
        detalleFacturas.add(detalleFactura);
    Producto producto2 = new Producto(1L, "ron", 40000.0);
        adaptadorProductoJpa.crear(producto2);
    int cantidad2 = 4;
    DetalleFactura detalleFactura2 = new DetalleFactura(cantidad2, producto2);
        detalleFacturas.add(detalleFactura2);
    Factura factura = new Factura(id, detalleFacturas);
        adaptadorFacturaJpa.crear(factura);
    List<DetallefacturaDto> detalleFacturasDto = new ArrayList<>();
    Long id1 = 1L;
    ProductoDto productoDto1 = new ProductoDto(1L, "vodka", 55000.0);
    int cantidadDto1 = 3;
    DetallefacturaDto detalleFacturaDto = new DetallefacturaDto(cantidadDto1, productoDto1);
        detalleFacturasDto.add(detalleFacturaDto);
    ProductoDto productoDto2 = new ProductoDto(1L, "ron", 40000.0);
    int cantidadDto2 = 4;
    DetallefacturaDto detalleFacturaDto2 = new DetallefacturaDto(cantidadDto2, productoDto2);
        detalleFacturasDto.add(detalleFacturaDto2);

    FacturaDto facturaDto = new FacturaDto(id1, detalleFacturasDto);
        facturaDtoList.add(facturaDto);
        mockMvc.perform(get("http://localhost:8080/factura")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(facturaDtoList)))
            .andDo(print())
            .andExpect(status().isOk());
}
@Test
    void detalleFacturaPorId() throws Exception {
    //arrange
    AdaptadorProductoJpa adaptadorProductoJpa = new AdaptadorProductoJpa(productoRepositorio);
    AdaptadorFacturaJpa adaptadorFacturaJpa = new AdaptadorFacturaJpa(facturaRepositorio, adaptadorDetalleFacturaJpa);
    List<DetalleFactura> detalleFacturas = new ArrayList<>();
    Long id = 1L;
    Producto producto1 = new Producto(1L, "vodka", 55000.0);
    adaptadorProductoJpa.crear(producto1);
    int cantidad1 = 3;
    DetalleFactura detalleFactura = new DetalleFactura(cantidad1, producto1);
    detalleFacturas.add(detalleFactura);
    Producto producto2 = new Producto(1L, "ron", 40000.0);
    adaptadorProductoJpa.crear(producto2);
    int cantidad2 = 4;
    DetalleFactura detalleFactura2 = new DetalleFactura(cantidad2, producto2);
    detalleFacturas.add(detalleFactura2);
    Factura factura = new Factura(id, detalleFacturas);
    adaptadorFacturaJpa.crear(factura);
    List<DetallefacturaDto> detalleFacturasDto = new ArrayList<>();
    ProductoDto productoDto1 = new ProductoDto(1L, "vodka", 55000.0);
    int cantidadDto1 = 3;
    DetallefacturaDto detalleFacturaDto = new DetallefacturaDto(cantidadDto1, productoDto1);
    detalleFacturasDto.add(detalleFacturaDto);
    ProductoDto productoDto2 = new ProductoDto(1L, "ron", 40000.0);
    int cantidadDto2 = 4;
    DetallefacturaDto detalleFacturaDto2 = new DetallefacturaDto(cantidadDto2, productoDto2);
    detalleFacturasDto.add(detalleFacturaDto2);

    mockMvc.perform(get("http://localhost:8080/detallefactura/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(detalleFacturasDto)))
            .andDo(print())
            .andExpect(status().isOk());

}
}

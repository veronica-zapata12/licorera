package com.ceiba.licorera.TestInfraestructura.controladorFactura;

import com.ceiba.licorera.LicoreraApplication;
import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.infraestructura.repositorio.FacturaRepositorioJPA;
import com.ceiba.licorera.infraestructura.repositorio.ProductoRepositorioJPA;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.RepositorioDetalleFacturaPostgres;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.RepositorioFacturaPostgres;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.RepositorioProductoPostgres;
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
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    private FacturaRepositorioJPA facturaRepositorioJPA;
    @Autowired
    private RepositorioDetalleFacturaPostgres repositorioDetalleFacturaPostgres;
    @Autowired
    private ProductoRepositorioJPA productoRepositorioJPA;

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
        RepositorioProductoPostgres repositorioProductoPostgres = new RepositorioProductoPostgres(productoRepositorioJPA);
        RepositorioFacturaPostgres repositorioFacturaPostgres = new RepositorioFacturaPostgres(facturaRepositorioJPA, repositorioDetalleFacturaPostgres);
        List<DetalleFactura> detalleFacturas = new ArrayList<>();
    Long id = 1L;
    Producto producto1 = new Producto(1L, "vodka", 55000.0);
        repositorioProductoPostgres.crear(producto1);
    int cantidad1 = 3;
    DetalleFactura detalleFactura = new DetalleFactura(cantidad1, producto1);
        detalleFacturas.add(detalleFactura);
    Producto producto2 = new Producto(1L, "ron", 40000.0);
        repositorioProductoPostgres.crear(producto2);
    int cantidad2 = 4;
    DetalleFactura detalleFactura2 = new DetalleFactura(cantidad2, producto2);
        detalleFacturas.add(detalleFactura2);
    Factura factura = new Factura(id, detalleFacturas);
        repositorioFacturaPostgres.crear(factura);
        mockMvc.perform(get("http://localhost:8080/factura"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("[0].id").value(1))
                .andExpect(jsonPath("[0].total").value(292500.0))
                .andExpect(jsonPath("[0].hora").value(factura.getHora()))
                .andDo(print());
}
@Test
    void detalleFacturaPorId() throws Exception {
    //arrange
    RepositorioProductoPostgres repositorioProductoPostgres = new RepositorioProductoPostgres(productoRepositorioJPA);
    RepositorioFacturaPostgres repositorioFacturaPostgres = new RepositorioFacturaPostgres(facturaRepositorioJPA, repositorioDetalleFacturaPostgres);
    List<DetalleFactura> detalleFacturas = new ArrayList<>();
    Long id = 1L;
    Producto producto1 = new Producto(1L, "vodka", 55000.0);
    repositorioProductoPostgres.crear(producto1);
    int cantidad1 = 3;
    DetalleFactura detalleFactura = new DetalleFactura(cantidad1, producto1);
    detalleFacturas.add(detalleFactura);
    Producto producto2 = new Producto(1L, "ron", 40000.0);
    repositorioProductoPostgres.crear(producto2);
    int cantidad2 = 4;
    DetalleFactura detalleFactura2 = new DetalleFactura(cantidad2, producto2);
    detalleFacturas.add(detalleFactura2);
    Factura factura = new Factura(id, detalleFacturas);
    repositorioFacturaPostgres.crear(factura);
    mockMvc.perform(get("http://localhost:8080/detallefactura/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("[0].cantidad").value(3))
            .andExpect(jsonPath("[0].producto.nombre").value("vodka"))
            .andExpect(jsonPath("[0].producto.valor").value(55000))
            .andExpect(jsonPath("[1].cantidad").value(4))
            .andExpect(jsonPath("[1].producto.nombre").value("ron"))
            .andExpect(jsonPath("[1].producto.valor").value(40000))
            .andDo(print());

}
}

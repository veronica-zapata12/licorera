package com.ceiba.licorera.TestInfraestructura.controladorProducto;

import com.ceiba.licorera.LicoreraApplication;
import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.infraestructura.repositorio.ProductoRepositorio;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.AdaptadorProductoJpa;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
public class ControladorProductoTest {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void creaProducto() throws Exception {
        //arrange
        ComandoProducto comandoProducto = new ComandoProductoDataBuilder().build();
        //Act-Assert
        mockMvc.perform(post("http://localhost:8080/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProducto))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void listarproductos() throws Exception {
        AdaptadorProductoJpa adaptadorProductoJpa= new AdaptadorProductoJpa(productoRepositorio);
        List<ProductoDto> productoDtoList=new ArrayList<>();

        Producto producto1 = new Producto(1L, "vodka", 55000.0);
       adaptadorProductoJpa.crear(producto1);
        Producto producto2 = new Producto(1L, "ron", 40000.0);
        adaptadorProductoJpa.crear(producto2);
        ProductoDto productoDto1 = new ProductoDto(1L, "vodka", 55000.0);
        ProductoDto productoDto2 = new ProductoDto(1L, "ron", 40000.0);
        productoDtoList.add(productoDto1);
        productoDtoList.add(productoDto2);
        mockMvc.perform(get("http://localhost:8080/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productoDtoList)))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void listarpornombres() throws Exception {
        AdaptadorProductoJpa adaptadorProductoJpa= new AdaptadorProductoJpa(productoRepositorio);
        List<ProductoDto> productoDtoList=new ArrayList<>();

        Producto producto1 = new Producto(1L, "vodka", 55000.0);
        adaptadorProductoJpa.crear(producto1);
        Producto producto2 = new Producto(1L, "ron", 40000.0);
        adaptadorProductoJpa.crear(producto2);
        ProductoDto productoDto1 = new ProductoDto(1L, "vodka", 55000.0);

        productoDtoList.add(productoDto1);
        mockMvc.perform(get("http://localhost:8080/productos/vodka")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productoDtoList)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

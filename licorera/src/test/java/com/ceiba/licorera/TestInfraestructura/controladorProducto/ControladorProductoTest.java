package com.ceiba.licorera.TestInfraestructura.controladorProducto;

import com.ceiba.licorera.LicoreraApplication;
import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.infraestructura.repositorio.ProductoRepositorioJPA;
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
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    private ProductoRepositorioJPA productoRepositorioJPA;

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
        RepositorioProductoPostgres repositorioProductoPostgres = new RepositorioProductoPostgres(productoRepositorioJPA);


        Producto producto1 = new Producto(1L, "vodka", 55000.0);
       repositorioProductoPostgres.crear(producto1);
        Producto producto2 = new Producto(1L, "ron", 40000.0);
        repositorioProductoPostgres.crear(producto2);
        mockMvc.perform(get("http://localhost:8080/productos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("[0].nombre").value("vodka"))
                .andExpect(jsonPath("[0].valor").value(55000.0))
                .andExpect(jsonPath("[1].nombre").value("ron"))
                .andExpect(jsonPath("[1].valor").value(40000))
                .andDo(print());

    }


    @Test
    public void listarpornombres() throws Exception {
        RepositorioProductoPostgres repositorioProductoPostgres = new RepositorioProductoPostgres(productoRepositorioJPA);

        Producto producto1 = new Producto(1L, "vodka", 55000.0);
        repositorioProductoPostgres.crear(producto1);
        Producto producto2 = new Producto(1L, "ron", 40000.0);
        repositorioProductoPostgres.crear(producto2);
        mockMvc.perform(get("http://localhost:8080/productos/{nombre}", "ron"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("[1].nombre").value("ron"))
                .andExpect(jsonPath("[1].valor").value(40000))
                .andDo(print());
    }
}

package com.ceiba.licorera.TestInfraestructura.controladorFactura;

import com.ceiba.licorera.LicoreraApplication;
import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
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
        ComandoFactura comandoFactura = new ComandoFacturaDataBuilder().build();
        comandoFactura.setTotal(292500.0);
        mockMvc.perform(get("http://localhost:8080/factura")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

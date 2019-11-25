package com.ceiba.licorera.infraestructura.controlador;

import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.aplicacion.comando.manejador.factura.ManejadorConsultarFacturas;
import com.ceiba.licorera.aplicacion.comando.manejador.factura.ManejadorCrearFactura;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/factura")
public class ControladorFactura {
    private final ManejadorCrearFactura manejadorFactura;
    private final ManejadorConsultarFacturas manejadorConsultarFacturas;

    public ControladorFactura(ManejadorCrearFactura manejadorFactura, ManejadorConsultarFacturas manejadorConsultarFacturas) {
        this.manejadorFactura = manejadorFactura;
        this.manejadorConsultarFacturas = manejadorConsultarFacturas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody ComandoFactura comandoFactura) {
        this.manejadorFactura.ejecutar(comandoFactura);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<FacturaDto> listarFacturas() {
        return this.manejadorConsultarFacturas.ejecutar();
    }

}
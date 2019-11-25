package com.ceiba.licorera.infraestructura.controlador;

import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.aplicacion.comando.manejador.factura.ManejadorConsultarFacturas;
import com.ceiba.licorera.aplicacion.comando.manejador.factura.ManejadorCrearFactura;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
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
    public void crear(@RequestBody ComandoFactura comandoFactura) {
        this.manejadorFactura.ejecutar(comandoFactura);
    }

    @GetMapping()
    public List<FacturaDto> listarFacturas() {
        return this.manejadorConsultarFacturas.ejecutar();
    }

    @GetMapping(value = "/{id}")
    public FacturaDto buscarporid(@PathVariable Long id) {
        return manejadorConsultarFacturas.buscarporid(id);
    }

}
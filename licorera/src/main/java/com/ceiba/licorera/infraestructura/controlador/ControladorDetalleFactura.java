package com.ceiba.licorera.infraestructura.controlador;

import com.ceiba.licorera.aplicacion.comando.manejador.factura.ManejadorConsultaDetalleFactura;
import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/detallefactura")
public class ControladorDetalleFactura {
    private final ManejadorConsultaDetalleFactura manejadorConsultaDetalleFactura;

    public ControladorDetalleFactura(ManejadorConsultaDetalleFactura manejadorConsultaDetalleFactura) {
        this.manejadorConsultaDetalleFactura = manejadorConsultaDetalleFactura;
    }

    @GetMapping(value = "/{id}")
    public List<DetallefacturaDto> buscarFactura(@PathVariable Long id) {
        return manejadorConsultaDetalleFactura.buscarFactura(id);
    }
}

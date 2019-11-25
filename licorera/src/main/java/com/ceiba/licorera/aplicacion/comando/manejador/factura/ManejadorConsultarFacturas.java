package com.ceiba.licorera.aplicacion.comando.manejador.factura;

import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.servicio.factura.ServicioConsultarFacturas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarFacturas {
    private ServicioConsultarFacturas servicioConsultarFacturas;

    public ManejadorConsultarFacturas(ServicioConsultarFacturas servicioConsultarFacturas) {
        this.servicioConsultarFacturas = servicioConsultarFacturas;
    }

    public List<FacturaDto> ejecutar() {
        return this.servicioConsultarFacturas.ejecutar();
    }

    public FacturaDto buscarporid(Long id) {
        return this.servicioConsultarFacturas.buscarporid(id);
    }
}

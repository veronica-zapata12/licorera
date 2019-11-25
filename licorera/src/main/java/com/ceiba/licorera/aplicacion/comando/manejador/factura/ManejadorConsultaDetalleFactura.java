package com.ceiba.licorera.aplicacion.comando.manejador.factura;

import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.servicio.factura.ServicioConsultarDetallefactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaDetalleFactura {
    private ServicioConsultarDetallefactura servicioConsultarDetallefactura;

    public ManejadorConsultaDetalleFactura(ServicioConsultarDetallefactura servicioConsultarDetallefactura) {
        this.servicioConsultarDetallefactura = servicioConsultarDetallefactura;
    }

    public List<DetallefacturaDto> buscarFactura(Long id) {
        return this.servicioConsultarDetallefactura.buscarFactura(id);
    }
}

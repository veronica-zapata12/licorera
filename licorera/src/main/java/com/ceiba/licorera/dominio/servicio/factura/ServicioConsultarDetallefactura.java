package com.ceiba.licorera.dominio.servicio.factura;

import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioDetalleFactura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioConsultarDetallefactura {
    private RepositorioDetalleFactura repositorioDetalleFactura;

    public ServicioConsultarDetallefactura(RepositorioDetalleFactura repositorioDetalleFactura) {
        this.repositorioDetalleFactura = repositorioDetalleFactura;

    }

    public List<DetallefacturaDto> buscarFactura(Long id) {
        return this.repositorioDetalleFactura.buscarFactura(id);

    }
}

package com.ceiba.licorera.dominio.servicio.factura;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioFactura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServicioConsultarFacturas {
    private RepositorioFactura repositorioFactura;


    public ServicioConsultarFacturas(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public List<FacturaDto> ejecutar() {
        return this.repositorioFactura.obtenerFacturas();
    }
   public FacturaDto buscarporid(Long id){
        return this.repositorioFactura.buscarporidfactura(id);
    }
}


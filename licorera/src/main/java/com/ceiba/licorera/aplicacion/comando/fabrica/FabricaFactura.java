package com.ceiba.licorera.aplicacion.comando.fabrica;

import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.dominio.modelo.Factura;
import org.springframework.stereotype.Component;

@Component
public class FabricaFactura {
    public Factura crear(ComandoFactura comandoFactura) {
        return new Factura(comandoFactura.getId(), comandoFactura.getDetalleFacturas());

    }
}

package com.ceiba.licorera.aplicacion.comando.manejador.factura;

import com.ceiba.licorera.aplicacion.comando.ComandoFactura;
import com.ceiba.licorera.aplicacion.comando.fabrica.FabricaFactura;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.servicio.factura.ServicioCrearFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFactura {
    private final ServicioCrearFactura servicioCrearFactura;
    private final FabricaFactura fabricaFactura;

    public ManejadorCrearFactura(ServicioCrearFactura servicioCrearFactura, FabricaFactura fabricaFactura) {
        this.servicioCrearFactura = servicioCrearFactura;
        this.fabricaFactura = fabricaFactura;
    }

    public void ejecutar(ComandoFactura comandoFactura) {
        Factura factura = this.fabricaFactura.crear(comandoFactura);
        this.servicioCrearFactura.ejecutar(factura);
    }
}

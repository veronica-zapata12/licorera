package com.ceiba.licorera.dominio.puerto.repositorio;

import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;

import java.util.List;

public interface RepositorioFactura {
    void crear(Factura factura);
    boolean existe(Factura factura);
    List<FacturaDto>obtenerFacturas();
    FacturaDto buscarporidfactura(Long id);
}

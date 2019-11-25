package com.ceiba.licorera.dominio.servicio.factura;

import com.ceiba.licorera.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioFactura;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearFactura {
    private static final String LA_FACTURA_YA_EXISTE="la factura ya existe en el sistema";
    private RepositorioFactura repositorioFactura;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura) {
        validarExistenciaPrevia(factura);
        this.repositorioFactura.crear(factura);
    }
    private void validarExistenciaPrevia(Factura factura){
        boolean existe=this.repositorioFactura.existe(factura);
        if (existe){
            throw new ExcepcionDuplicidad(LA_FACTURA_YA_EXISTE);
        }
    }
}

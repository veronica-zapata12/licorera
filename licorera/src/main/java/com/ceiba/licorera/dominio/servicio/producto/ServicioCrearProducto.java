package com.ceiba.licorera.dominio.servicio.producto;

import com.ceiba.licorera.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.licorera.dominio.excepcion.ExcepcionGeneral;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearProducto {
    private static final String EL_PRODUCTO_YA_EXISTE = "el producto ya existe";
    private static final String ERROR_EN_LA_CREACION = "error en la creacion";
    private RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        validarExistenciaPrevia(producto);
        if (producto != null) {
            this.repositorioProducto.crear(producto);
        } else {
            throw new ExcepcionGeneral(ERROR_EN_LA_CREACION);
        }
    }

    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existe(producto);
        if (existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_YA_EXISTE);
        }
    }
}

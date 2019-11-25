package com.ceiba.licorera.infraestructura.repositorio;

import com.ceiba.licorera.infraestructura.repositorio.entity.DetalleFacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFacturaEntity, Serializable> {
    @Query(value = "select * from detalles_factura   where idfactura = :id",nativeQuery = true)
    List<DetalleFacturaEntity> buscarfacturaporid (@PathVariable("id") Long id);
}

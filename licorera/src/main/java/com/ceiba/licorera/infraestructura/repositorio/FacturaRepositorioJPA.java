package com.ceiba.licorera.infraestructura.repositorio;

import com.ceiba.licorera.infraestructura.repositorio.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

public interface FacturaRepositorioJPA extends JpaRepository<FacturaEntity, Serializable> {
    @Query("select p from FacturaEntity  p where p.id = :id")
    FacturaEntity buscarporid (@PathVariable("id") Long id);
}

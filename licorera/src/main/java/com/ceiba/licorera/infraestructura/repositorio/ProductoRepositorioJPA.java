package com.ceiba.licorera.infraestructura.repositorio;

import com.ceiba.licorera.infraestructura.repositorio.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

public interface ProductoRepositorioJPA extends JpaRepository<ProductoEntity, Serializable> {
    @Query("select p from ProductoEntity  p where p.nombre like ?1%")
    ProductoEntity buscarpornombre(@Param("nombre") String nombre);
}

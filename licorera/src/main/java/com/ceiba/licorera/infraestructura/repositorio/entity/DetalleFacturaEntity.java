package com.ceiba.licorera.infraestructura.repositorio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalles_factura")
public class DetalleFacturaEntity implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(name = "cantidad", nullable = false, length = 500)
    private Integer cantidad;
    @ManyToOne()
    @JoinColumn(name = "nombre")
    private ProductoEntity productoEntity;


    public DetalleFacturaEntity() {
    }

    public DetalleFacturaEntity(Long id, Integer cantidad, ProductoEntity productoEntity) {
        this.id = id;
        this.cantidad = cantidad;
        this.productoEntity = productoEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoEntity getProductoEntity() {
        return productoEntity;
    }

    public void setProductoEntity(ProductoEntity productoEntity) {
        this.productoEntity = productoEntity;
    }
    private static final Long serialVersionUID = 1L;
}

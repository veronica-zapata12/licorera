package com.ceiba.licorera.infraestructura.repositorio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class FacturaEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column
    private String hora;
    @Column
    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idfactura")
    private List<DetalleFacturaEntity> detalleFacturaEntities;


    public FacturaEntity() {
        detalleFacturaEntities = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DetalleFacturaEntity> getDetalleFacturaEntities() {
        return detalleFacturaEntities;
    }

    public void setDetalleFacturaEntities(List<DetalleFacturaEntity> detalleFacturaEntities) {
        this.detalleFacturaEntities = detalleFacturaEntities;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    private static final Long serialVersionUID = 1L;
}
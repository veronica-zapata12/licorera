package com.ceiba.licorera.aplicacion.comando;

import com.ceiba.licorera.dominio.modelo.DetalleFactura;

import java.util.Date;
import java.util.List;

public class ComandoFactura {
    private Long id;
    private Double total;
    private Date fecha;
    private List<DetalleFactura> detalleFacturas;

    public ComandoFactura(Long id, List<DetalleFactura> detalleFacturas) {
        this.id = id;
        this.fecha = new Date();
        this.detalleFacturas = detalleFacturas;
    }

    public Long getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }
}

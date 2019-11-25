package com.ceiba.licorera.dominio.modelo.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturaDto {
    private Long id;
    private Double total = 0.0;
    private Date fecha;
    private String hora;
    private List<DetallefacturaDto> detalleFacturas;

    public FacturaDto() {
        detalleFacturas=new ArrayList<>();
    }

    public FacturaDto(Long id, List<DetallefacturaDto> detalleFacturas) {
        this.id = id;
        this.detalleFacturas = detalleFacturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<DetallefacturaDto> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetallefacturaDto> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }
}

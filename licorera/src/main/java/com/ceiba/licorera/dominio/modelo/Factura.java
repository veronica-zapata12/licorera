package com.ceiba.licorera.dominio.modelo;

import com.ceiba.licorera.dominio.validador.ValidadorDeArgumento;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Factura {

    private static String LO_DOMINGOS_NO_SE_VENDE = "los domingos no se vende";
    private static String ANTES_DE_LAS_11AM_NO_SE_VENDE = "antes de las 11 am no se vende";
    private Long id;
    private Double total = 0.0;
    private Date fecha;
    private String hora;
    private List<DetalleFactura> detalleFacturas;

    public Factura(Long id, List<DetalleFactura> detalleFacturas) {
        fecha = new Date();
        ValidadorDeArgumento.validarFecha(fecha, LO_DOMINGOS_NO_SE_VENDE);
        Calendar calendar = Calendar.getInstance();
        int horas = calendar.get(Calendar.HOUR_OF_DAY);
        int minutos = calendar.get(Calendar.MINUTE);
        int segundos = calendar.get(Calendar.SECOND);
        hora = horas + ":" + minutos + ":" + segundos;
        //ValidadorDeArgumento.valiarhora(horas, ANTES_DE_LAS_11AM_NO_SE_VENDE);
        this.id = id;
        this.detalleFacturas = detalleFacturas;

    }

    public Long getId() {
        return id;
    }


    public Double setTotal(double total) {
        this.total = total;
        return total;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }


    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public Double getTotal() {
        int topeParaDescuento = 300000;
        int porcentajeDescuento = 10;
        for (DetalleFactura detalleFactura : detalleFacturas) {
            total += detalleFactura.cacularValorParcial();
        }
        if (total >= topeParaDescuento) {
            Double descuento = (porcentajeDescuento * total) / 100;
            total = total - descuento;
        }
        return setTotal(total);
    }
}

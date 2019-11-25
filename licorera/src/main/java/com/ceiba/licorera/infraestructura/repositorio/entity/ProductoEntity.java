package com.ceiba.licorera.infraestructura.repositorio.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "productos")
public class ProductoEntity{

    @Id
    @Column
    private String nombre;
    @Column
    private Double valor;

    public ProductoEntity() {
    }

    public ProductoEntity( String nombre, Double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

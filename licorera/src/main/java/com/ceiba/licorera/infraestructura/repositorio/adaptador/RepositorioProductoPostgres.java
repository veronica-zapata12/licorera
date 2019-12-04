package com.ceiba.licorera.infraestructura.repositorio.adaptador;

import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioProducto;
import com.ceiba.licorera.infraestructura.repositorio.ProductoRepositorioJPA;
import com.ceiba.licorera.infraestructura.repositorio.entity.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioProductoPostgres implements RepositorioProducto {
    private ProductoRepositorioJPA productoRepositorioJPA;
    private ModelMapper modelMapper = new ModelMapper();

    public RepositorioProductoPostgres(ProductoRepositorioJPA productoRepositorioJPA) {
        this.productoRepositorioJPA = productoRepositorioJPA;

    }

    @Override
    public void crear(Producto producto) {
        ProductoEntity productoEntity = modelMapper.map(producto, ProductoEntity.class);
        productoRepositorioJPA.save(productoEntity);

    }

    @Override
    public boolean existe(Producto producto) {
        String nombre = producto.getNombre();
        return (productoRepositorioJPA.buscarpornombre(nombre)) != null ? true : false;
    }

    @Override
    public List<ProductoDto> buscarPornombre(String nombre) {
        List<ProductoEntity> productoEntidadLista = productoRepositorioJPA.findAll();
        List<ProductoDto> productoLista = new ArrayList<>();
        for (ProductoEntity productoEntity : productoEntidadLista) {
            ProductoDto productoDto = modelMapper.map(productoEntity, ProductoDto.class);
            productoLista.add(productoDto);
        }
        return productoLista;


    }


    @Override
    public List<ProductoDto> obtenerProductos() {
        List<ProductoEntity> productoEntidadLista = productoRepositorioJPA.findAll();
        List<ProductoDto> productoLista = new ArrayList<>();
        for (ProductoEntity productoEntity : productoEntidadLista) {
            ProductoDto productoDto = modelMapper.map(productoEntity, ProductoDto.class);
            productoLista.add(productoDto);
        }
        return productoLista;
    }


}

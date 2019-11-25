package com.ceiba.licorera.infraestructura.repositorio.adaptador;

import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioProducto;
import com.ceiba.licorera.infraestructura.repositorio.ProductoRepositorio;
import com.ceiba.licorera.infraestructura.repositorio.entity.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdaptadorProductoJpa implements RepositorioProducto {
    private ProductoRepositorio productoRepositorio;
    private ModelMapper modelMapper = new ModelMapper();

    public AdaptadorProductoJpa(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;

    }

    @Override
    public void crear(Producto producto) {
        ProductoEntity productoEntity = modelMapper.map(producto, ProductoEntity.class);
        productoRepositorio.save(productoEntity);

    }

    @Override
    public boolean existe(Producto producto) {
        String nombre = producto.getNombre();
        return (productoRepositorio.buscarpornombre(nombre)) != null ? true : false;
    }

    @Override
    public List<ProductoDto> buscarPornombre(String nombre) {
        List<ProductoEntity> productoEntidadLista = productoRepositorio.findAll();
        List<ProductoDto> productoLista = new ArrayList<>();
        for (ProductoEntity productoEntity : productoEntidadLista) {
            ProductoDto productoDto = modelMapper.map(productoEntity, ProductoDto.class);
            productoLista.add(productoDto);
        }
        return productoLista;


    }

    @Override
    public Double obtenerValorporNombre(String nombre) {
        ProductoEntity productoEntity = productoRepositorio.buscarpornombre(nombre);
        Producto producto = modelMapper.map(productoEntity, Producto.class);
        return producto.getValor();
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        List<ProductoEntity> productoEntidadLista = productoRepositorio.findAll();
        List<ProductoDto> productoLista = new ArrayList<>();
        for (ProductoEntity productoEntity : productoEntidadLista) {
            ProductoDto productoDto = modelMapper.map(productoEntity, ProductoDto.class);
            productoLista.add(productoDto);
        }
        return productoLista;
    }


}

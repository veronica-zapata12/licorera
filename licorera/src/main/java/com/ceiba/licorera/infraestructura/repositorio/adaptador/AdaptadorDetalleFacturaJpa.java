package com.ceiba.licorera.infraestructura.repositorio.adaptador;

import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import com.ceiba.licorera.dominio.modelo.Producto;
import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioDetalleFactura;
import com.ceiba.licorera.infraestructura.repositorio.DetalleFacturaRepositorio;
import com.ceiba.licorera.infraestructura.repositorio.entity.DetalleFacturaEntity;
import com.ceiba.licorera.infraestructura.repositorio.entity.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AdaptadorDetalleFacturaJpa implements RepositorioDetalleFactura {

    private ModelMapper modelMapper = new ModelMapper();
    private DetalleFacturaRepositorio detalleFacturaRepositorio;

    public AdaptadorDetalleFacturaJpa(DetalleFacturaRepositorio detalleFacturaRepositorio) {
        this.detalleFacturaRepositorio = detalleFacturaRepositorio;
    }


    public DetalleFacturaEntity convertir(DetalleFactura detalleFactura) {
        Producto producto = detalleFactura.getProducto();
        ProductoEntity productoEntity = modelMapper.map(producto, ProductoEntity.class);
        DetalleFacturaEntity detalleFacturaEntity = modelMapper.map(detalleFactura, DetalleFacturaEntity.class);
        detalleFacturaEntity.setProductoEntity(productoEntity);
        return detalleFacturaEntity;
    }

    @Override
    public List<DetallefacturaDto> buscarFactura(Long id) {
        List<DetalleFacturaEntity> detalleFacturaEntitylist=detalleFacturaRepositorio.buscarfacturaporid(id);
        List<DetallefacturaDto> detallefacturaDtoList = new ArrayList<>();
        for( DetalleFacturaEntity detalleFacturaEntity : detalleFacturaEntitylist ) {
            DetallefacturaDto detallefacturaDto = modelMapper.map(detalleFacturaEntity, DetallefacturaDto.class);
                detallefacturaDtoList.add(detallefacturaDto);
        }
        return detallefacturaDtoList;
    }
}

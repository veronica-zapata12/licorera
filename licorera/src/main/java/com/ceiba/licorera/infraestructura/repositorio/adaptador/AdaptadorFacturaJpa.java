package com.ceiba.licorera.infraestructura.repositorio.adaptador;

import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.licorera.infraestructura.repositorio.FacturaRepositorio;
import com.ceiba.licorera.infraestructura.repositorio.entity.DetalleFacturaEntity;
import com.ceiba.licorera.infraestructura.repositorio.entity.FacturaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AdaptadorFacturaJpa implements RepositorioFactura {
    private ModelMapper modelMapper = new ModelMapper();
    private FacturaRepositorio facturaRepositorio;
    private AdaptadorDetalleFacturaJpa adaptadorDetalleFacturaJpa;

    public AdaptadorFacturaJpa(FacturaRepositorio facturaRepositorio, AdaptadorDetalleFacturaJpa adaptadorDetalleFacturaJpa) {
        this.facturaRepositorio = facturaRepositorio;
        this.adaptadorDetalleFacturaJpa = adaptadorDetalleFacturaJpa;
    }

    @Override
    public void crear(Factura factura) {
        List<DetalleFacturaEntity> detalleFacturaEntitiesEmergente = new ArrayList<>();
        FacturaEntity facturaEntity = modelMapper.map(factura, FacturaEntity.class);
        for (DetalleFactura detalleFactura : factura.getDetalleFacturas()) {
            detalleFacturaEntitiesEmergente.add(adaptadorDetalleFacturaJpa.convertir(detalleFactura));
        }
        facturaEntity.setDetalleFacturaEntities(detalleFacturaEntitiesEmergente);
        facturaRepositorio.save(facturaEntity);


    }

    @Override
    public boolean existe(Factura factura) {
        Long id=factura.getId();
        return (facturaRepositorio.buscarporid(id))!= null ? true : false;
    }

    @Override
    public List<FacturaDto> obtenerFacturas() {
        List<FacturaEntity> facturaEntityLista = facturaRepositorio.findAll();
        List<FacturaDto> facturaLista = new ArrayList<>();
        for (FacturaEntity facturaEntity : facturaEntityLista) {
            FacturaDto facturaDto = modelMapper.map(facturaEntity, FacturaDto.class);
            facturaLista.add(facturaDto);
        }
        return facturaLista;
    }

    @Override
    public FacturaDto buscarporidfactura(Long id) {
        FacturaEntity facturaEntity= facturaRepositorio.buscarporid(id);
        FacturaDto facturaDto= modelMapper.map(facturaEntity,FacturaDto.class);
        return facturaDto;
    }
}

package com.ceiba.licorera.infraestructura.repositorio.adaptador;

import com.ceiba.licorera.dominio.modelo.DetalleFactura;
import com.ceiba.licorera.dominio.modelo.Factura;
import com.ceiba.licorera.dominio.modelo.dto.FacturaDto;
import com.ceiba.licorera.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.licorera.infraestructura.repositorio.FacturaRepositorioJPA;
import com.ceiba.licorera.infraestructura.repositorio.entity.DetalleFacturaEntity;
import com.ceiba.licorera.infraestructura.repositorio.entity.FacturaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class RepositorioFacturaPostgres implements RepositorioFactura {
    private ModelMapper modelMapper = new ModelMapper();
    private FacturaRepositorioJPA facturaRepositorioJPA;
    private RepositorioDetalleFacturaPostgres repositorioDetalleFacturaPostgres;

    public RepositorioFacturaPostgres(FacturaRepositorioJPA facturaRepositorioJPA, RepositorioDetalleFacturaPostgres repositorioDetalleFacturaPostgres) {
        this.facturaRepositorioJPA = facturaRepositorioJPA;
        this.repositorioDetalleFacturaPostgres = repositorioDetalleFacturaPostgres;
    }

    @Override
    public void crear(Factura factura) {
        List<DetalleFacturaEntity> detalleFacturaEntitiesEmergente = new ArrayList<>();
        FacturaEntity facturaEntity = modelMapper.map(factura, FacturaEntity.class);
        for (DetalleFactura detalleFactura : factura.getDetalleFacturas()) {
            detalleFacturaEntitiesEmergente.add(repositorioDetalleFacturaPostgres.convertir(detalleFactura));
        }
        facturaEntity.setDetalleFacturaEntities(detalleFacturaEntitiesEmergente);
        facturaRepositorioJPA.save(facturaEntity);


    }

    @Override
    public boolean existe(Factura factura) {
        Long id=factura.getId();
        return (facturaRepositorioJPA.buscarporid(id))!= null ? true : false;
    }

    @Override
    public List<FacturaDto> obtenerFacturas() {
        List<FacturaEntity> facturaEntityLista = facturaRepositorioJPA.findAll();
        List<FacturaDto> facturaLista = new ArrayList<>();
        for (FacturaEntity facturaEntity : facturaEntityLista) {
            FacturaDto facturaDto = modelMapper.map(facturaEntity, FacturaDto.class);
            facturaLista.add(facturaDto);
        }
        return facturaLista;
    }

    @Override
    public FacturaDto buscarporidfactura(Long id) {
        FacturaEntity facturaEntity= facturaRepositorioJPA.buscarporid(id);
        FacturaDto facturaDto= modelMapper.map(facturaEntity,FacturaDto.class);
        return facturaDto;
    }
}

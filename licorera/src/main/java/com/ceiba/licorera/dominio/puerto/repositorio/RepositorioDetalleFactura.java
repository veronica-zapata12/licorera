package com.ceiba.licorera.dominio.puerto.repositorio;
import com.ceiba.licorera.dominio.modelo.dto.DetallefacturaDto;
import java.util.List;


public interface RepositorioDetalleFactura {
    List<DetallefacturaDto> buscarFactura(Long id);



}

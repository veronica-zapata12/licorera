package com.ceiba.licorera.infraestructura.controlador;

import com.ceiba.licorera.aplicacion.comando.ComandoProducto;
import com.ceiba.licorera.aplicacion.comando.manejador.producto.ManejadorConsultarProductos;
import com.ceiba.licorera.aplicacion.comando.manejador.producto.ManejadorCrearProducto;
import com.ceiba.licorera.dominio.modelo.dto.ProductoDto;
import com.ceiba.licorera.infraestructura.repositorio.adaptador.AdaptadorProductoJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/productos")
public class ControladorProducto {
    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorConsultarProductos manejadorConsultarProductos;


    public ControladorProducto(ManejadorCrearProducto manejadorCrearProducto, ManejadorConsultarProductos manejadorConsultarProductos) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorConsultarProductos = manejadorConsultarProductos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @GetMapping(value = "/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoDto> buscarPorNombre(@PathVariable String nombre) {
        return manejadorConsultarProductos.buscarpornombre(nombre);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoDto> listarProductos() {
        return manejadorConsultarProductos.ejecutar();
    }

}


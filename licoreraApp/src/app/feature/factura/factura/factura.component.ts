import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import {map, flatMap} from 'rxjs/operators';
import { ServiceService } from '../../shared/service/service.service';
import { Producto } from '../../shared/model/producto';
import { MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';
import { factura } from '../../shared/model/factura';
import { DetalleFactura } from '../../shared/model/detalle-factura';
import { ServiceFacturaService } from '../../shared/service/service-factura.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {
 factura: any;
 total:number;
  constructor(private router: Router,private productoService:ServiceService,private facturaService:ServiceFacturaService) { }

  autocompleteControl = new FormControl();
  productosFiltrados: Observable<Producto[]>;

  ngOnInit() {
    this.factura=new factura()
    this.productosFiltrados = this.autocompleteControl.valueChanges
      .pipe(
        map(value=> typeof value ==='string'? value: value.nombre ),
        flatMap(value => value ? this._filter(value): [])
      );
  }

  private _filter(value: string): Observable<Producto[]> {
    const filterValue = value.toLowerCase();

    return this.productoService.filtrarproductos(filterValue);
  }
  mostrarNombre(producto?:Producto): string | undefined{
    return producto ? producto.nombre: undefined;
  }
  selecionarProducto(event: MatAutocompleteSelectedEvent):void{
    let producto = event.option.value as Producto;
    if(this.existeItem(producto.nombre)){
      this.incrementaCantidad(producto.nombre)
    }else{
    let nuevoDetalle= new DetalleFactura();
    nuevoDetalle.producto = producto;
    this.factura.detalleFacturas.push(nuevoDetalle);
    }
    this.autocompleteControl.setValue('');
    event.option.focus();
    event.option.deselect();
    
  }
  actualizarCantidad(nombre:string, event:any):void{
    let cantidad:number= event.target.value as number;
    this.factura.detalleFacturas=this.factura.detalleFacturas.map((detalle:DetalleFactura)=>{
      if(nombre == detalle.producto.nombre){
        detalle.cantidad=cantidad;
      }
      return detalle;
    });
  }
  existeItem(nombre: string): boolean {
    let existe = false;
    this.factura.detalleFacturas.forEach((detalle: DetalleFactura) => {
      if (nombre === detalle.producto.nombre) {
        existe = true;
      }
    });
    return existe;
  }

  incrementaCantidad(nombre: string): void {
    this.factura.detalleFacturas = this.factura.detalleFacturas.map((detalle: DetalleFactura) => {
      if (nombre === detalle.producto.nombre) {
        ++detalle.cantidad;
      }
      return detalle;
    });
  }
 


calcularTotal(): number{
 
    this.total=0;
this.factura.detalleFacturas.forEach((detalle:DetalleFactura)=>{
    this.total+=detalle.calcularSubTotal();
});
if (this.total >= 300000) {
  let descuento = (10 * this.total) / 100;
  this.total = this.total - descuento;
}
return this.total;
}
eliminarItemFactura(nombre:string): void {
  this.factura.detalleFacturas = this.factura.detalleFacturas.filter((detalle:DetalleFactura) => nombre !== detalle.producto.nombre);
}
  crear(){
    this.facturaService.create(this.factura).subscribe(factura=>{
      this.router.navigate(['/listarfacturas']); 
      Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'La factura ha sido creado con éxito',
      showConfirmButton: true,
      
    }) 
    });
  }

}

import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Producto } from 'src/app/feature/shared/model/producto';
import { ServiceService } from 'src/app/feature/shared/service/service.service';


@Component({
  
  templateUrl: './crear-producto.component.html',
})
export class CrearProductoComponent implements OnInit {

  producto: Producto=new Producto;
  form:NgForm;

  constructor(private productoService: ServiceService ,private router: Router) { }

  ngOnInit() { }

  OnSubmit(form:NgForm){
    console.log(this.producto);
    this.productoService.agregarproducto(this.producto).subscribe(producto =>{
      this.router.navigate(['/listarproductos']); 
      Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'El producto ha sido creado con éxito',
      showConfirmButton: true,
      
    }) 
           
           
     });  

  }


}

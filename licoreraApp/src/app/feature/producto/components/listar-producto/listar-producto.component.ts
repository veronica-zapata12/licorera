import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/feature/shared/service/service.service';


@Component({
  selector: 'app-listar-producto',
  templateUrl: './listar-producto.component.html',
  styleUrls: ['./listar-producto.component.css']
})
export class ListarProductoComponent implements OnInit {
  producto: any[];
  constructor(private productoService: ServiceService) { }

  ngOnInit() {
    this.getProductos();
  }
getProductos(){
  this.productoService.getPorductos().subscribe((data: any) => {
    data.forEach(obj => obj.selector = false);
    this.producto = data;
  });
}  
}

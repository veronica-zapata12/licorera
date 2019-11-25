import { Component, OnInit } from '@angular/core';
import { ServiceFacturaService } from '../../shared/service/service-factura.service';

@Component({
  selector: 'app-listar-factura',
  templateUrl: './listar-factura.component.html',
  styleUrls: ['./listar-factura.component.css']
})
export class ListarFacturaComponent implements OnInit {
factura:any[];


constructor(private facturaService:ServiceFacturaService) { }

  ngOnInit() {
    this.getFacturas();
  }

getFacturas(){
  this.facturaService.getFactura().subscribe((data: any) => {
    data.forEach(obj => obj.selector = false);
    this.factura = data;
  });

}

}

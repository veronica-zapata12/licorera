import { Component, OnInit } from '@angular/core';
import { ServiceDetalleFacturaService } from '../../shared/service/service-detalle-factura.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalle-factura',
  templateUrl: './detalle-factura.component.html',
  styleUrls: ['./detalle-factura.component.css']
})
export class DetalleFacturaComponent implements OnInit {
  Detalle:any[];
  detalles:any[];
  detalleID:number;
  
  constructor(private DetalleService:ServiceDetalleFacturaService,private activatedRouter:ActivatedRoute) { }

  ngOnInit() {
    this.activatedRouter.params.subscribe(params => {
      if (params["id"] == undefined) {
        return;
      }
      this.detalleID = params["id"]
      this.getfacturaporid();

      
    });
  }
  getfacturaporid(){
    let detalle=this.detalleID
    this.DetalleService.getFacturaporid(detalle).subscribe((data: any) => {
      data.forEach(obj => obj.selector = false);
      this.detalles = data;});
  }

}

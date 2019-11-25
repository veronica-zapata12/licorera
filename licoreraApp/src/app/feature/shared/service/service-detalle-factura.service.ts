import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlRuta } from '../urlRuta';

@Injectable({
  providedIn: 'root'
})
export class ServiceDetalleFacturaService {
  constructor(private http:HttpClient,private urlRuta:UrlRuta) {}
  readonly route =this.urlRuta.getRuta();
  getFacturaporid(idFactura: number){
    return this.http.get(this.route +'/detallefactura/'+ idFactura)
  }
}

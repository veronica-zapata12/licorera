import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlRuta } from '../urlRuta';

@Injectable({
  providedIn: 'root'
})
export class ServiceDetalleFacturaService {
  constructor(private http:HttpClient) {}
  getFacturaporid(idFactura: number){
    return this.http.get('api/detallefactura/'+ idFactura)
  }
}

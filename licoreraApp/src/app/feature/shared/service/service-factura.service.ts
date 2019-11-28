import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { factura } from '../model/factura';
import { UrlRuta } from '../urlRuta';

@Injectable({
  providedIn: 'root'
})
export class ServiceFacturaService {

  constructor(private http:HttpClient,private urlRuta:UrlRuta) {}
  readonly route =this.urlRuta.getRuta();
    create(factura: factura){
      
      return this.http.post<factura>( 'api/factura', factura);
    }
  
  getFactura(){
    return this.http.get( 'api/factura')
  }
}

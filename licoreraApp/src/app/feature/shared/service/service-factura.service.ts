import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { factura } from '../model/factura';


@Injectable({
  providedIn: 'root'
})
export class ServiceFacturaService {

  constructor(private http:HttpClient) {}

    create(factura: factura){
      
      return this.http.post<factura>( 'api/factura', factura);
    }
  
  getFactura(){
    return this.http.get( 'api/factura')
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../model/producto';
import { UrlRuta } from '../urlRuta';
import { Observable } from 'rxjs';

@Injectable()
export class ServiceService {

  constructor(private http:HttpClient,private urlRuta:UrlRuta) {}
    readonly route =this.urlRuta.getRuta();

    agregarproducto(producto : Producto){
      const sendProducto: Producto={
      nombre:producto.nombre,
        valor:producto.valor

      };
      return this.http.post(this.route + '/productos',sendProducto)

    }
    getPorductos(){
      return this.http.get(this.route + '/productos')
    }
filtrarproductos(nombre:string):Observable<Producto[]>{
  return this.http.get<Producto[]>(this.route + '/productos/'+ nombre)
}


   
}

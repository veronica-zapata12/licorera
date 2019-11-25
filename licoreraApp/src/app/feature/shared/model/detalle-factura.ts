import {Producto} from './producto'
export class DetalleFactura{
    producto: Producto;
    cantidad: number=1;
    subtotal: number;
    public calcularSubTotal():number{
        return this.cantidad * this.producto.valor;
    }
}
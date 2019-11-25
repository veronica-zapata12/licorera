import { Routes } from '@angular/router';
import { CrearProductoComponent } from './feature/producto/components/crear-producto/crear-producto.component';
import { ListarProductoComponent } from './feature/producto/components/listar-producto/listar-producto.component';
import { ListarFacturaComponent } from './feature/factura/listar-factura/listar-factura.component';
import { DetalleFacturaComponent } from './feature/factura/detalle-factura/detalle-factura.component';
import { FacturaComponent } from './feature/factura/factura/factura.component';

export const appRutas: Routes=[
    {path:"agregarproducto", component:CrearProductoComponent},
    {path:"listarproductos", component:ListarProductoComponent},
    {path:"listarfacturas",component:ListarFacturaComponent},
    {path:"facturas/:id",component:DetalleFacturaComponent},
    {path:"facturar",component:FacturaComponent}

]
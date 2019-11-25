import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { ListarProductoComponent } from './feature/producto/components/listar-producto/listar-producto.component';
import { CrearProductoComponent } from './feature/producto/components/crear-producto/crear-producto.component';
import { appRutas } from './rutas';
import { HttpClientModule } from '@angular/common/http';
import { DetalleFacturaComponent } from './feature/factura/detalle-factura/detalle-factura.component';
import { FacturaComponent } from './feature/factura/factura/factura.component';
import { ListarFacturaComponent } from './feature/factura/listar-factura/listar-factura.component';
import { ServiceService } from './feature/shared/service/service.service';
import { UrlRuta } from './feature/shared/urlRuta';
import { ServiceFacturaService } from './feature/shared/service/service-factura.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';

@NgModule({
  declarations: [
    AppComponent,
    
    ListarProductoComponent,
    CrearProductoComponent,
    DetalleFacturaComponent,
    FacturaComponent,
    ListarFacturaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule.forRoot(appRutas),
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatInputModule,
    MatFormFieldModule
    
  ],
  providers: [ServiceService,UrlRuta,ServiceFacturaService],
  
  bootstrap: [AppComponent]
})
export class AppModule { }

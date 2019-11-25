import { TestBed } from '@angular/core/testing';

import { ServiceDetalleFacturaService } from './service-detalle-factura.service';

describe('ServiceDetalleFacturaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ServiceDetalleFacturaService = TestBed.get(ServiceDetalleFacturaService);
    expect(service).toBeTruthy();
  });
});

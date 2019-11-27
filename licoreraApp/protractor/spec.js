describe('Prueba flujo principal', function() {
    it('should have a title', function() {
      browser.get('http://localhost:4200/');
  
      expect(browser.getTitle()).toEqual('LicoreraApp');
    });
  });
  describe('Crear producto', function() {
    it('Crear producto', function() {
      browser.get('http://localhost:4200/agregarproducto');
      browser.sleep( 1000 );
      element(by.name("nombre")).sendKeys("lo que sea5")
      element(by.name('valor')).sendKeys(455522);
      element(by.id('Guardar')).click();
      browser.sleep( 1000);
      element(by.buttonText('OK')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/listarproductos'); 
      browser.sleep( 2000);
      element(by.id('devolverse')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/agregarproducto'); 
      browser.sleep( 2000);
    });
  })

  describe('ir a lista de facturas', function() {
    it('ir a lista de facturas', function() {
      browser.get('http://localhost:4200/facturar');
      browser.sleep( 1000 );
      element(by.id('ir a')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/listarfacturas') ; 
      browser.sleep( 2000);
      element(by.id('ver')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/facturas/1'); 
      browser.sleep( 2000);
    });
  })
  
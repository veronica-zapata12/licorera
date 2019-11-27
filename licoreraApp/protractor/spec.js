describe('Prueba flujo principal', function() {
    it('should have a title', function() {
      browser.get('http://localhost:4200/');
  
      expect(browser.getTitle()).toEqual('BIENVENIDOS A LA LICORERA');
      browser.sleep( 1000 );
    });
  });
  describe('productos', function() {
    it('productos', function() {
      browser.get('http://localhost:4200/agregarproducto');
      browser.sleep( 1000 );
      element(by.name("nombre")).sendKeys("lo que sea1")
      element(by.name('valor')).sendKeys(455522);
      element(by.id('Guardar')).click();
      browser.sleep( 1000);
      element(by.buttonText('OK')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/listarproductos'); 
      browser.sleep( 2000);
      element(by.id('devolverse')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/agregarproducto'); 
      browser.sleep( 2000);
      element(by.id('home')).click();
      browser.sleep( 2000);
    });
  })

  describe('facturas', function() {
    it('facturas', function() {
      browser.get('http://localhost:4200/facturar');
      browser.sleep( 1000 );
      element(by.id('ir a')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/listarfacturas') ; 
      browser.sleep( 2000);
      element(by.id('ver')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/facturas/1516'); 
      browser.sleep( 2000);
      element(by.id('home')).click();
      browser.sleep( 2000);
    });
  })
  
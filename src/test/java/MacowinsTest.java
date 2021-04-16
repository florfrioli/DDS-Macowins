import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class MacowinsTest {
  @Test
  public void precioPrendaEnLiquidacion() {
    Prenda saco = new Prenda(400, new Liquidacion());
    Assertions.assertEquals(200, saco.precio());
  }

  @Test
  public void precioPrendaNueva() {
    Prenda camisa = new Prenda(500, new Nuevo());
    Assertions.assertEquals(500, camisa.precio());
  }

  @Test
  public void precioPrendaEnPromocion() {
    Prenda pantalon = new Prenda(400, new Promocion(100));
    Assertions.assertEquals(300, pantalon.precio());
  }

  @Test
  public void montoDelItem() {
    Prenda pantalon = new Prenda(400, new Promocion(100));
    ItemVenta item1 = new ItemVenta(pantalon, 2);
    Assertions.assertEquals(600, item1.montoItem());
  }

  @Test
  public void montoTotalDeUnaVentaEnEfectivo() {
    Prenda pantalon = new Prenda(400, new Promocion(100));
    Prenda camisa = new Prenda(500, new Nuevo());
    ItemVenta item1 = new ItemVenta(pantalon, 2);
    ItemVenta item2 = new ItemVenta(camisa, 3);
    List<ItemVenta> itemsVendidos = new ArrayList<>();
    itemsVendidos.add(item1);
    itemsVendidos.add(item2);
    Venta venta = new Venta(itemsVendidos, new Efectivo());
    Assertions.assertEquals(2100, venta.montoTotal());
  }

  @Test
  public void recargoPagoConTarjeta() {
    Prenda pantalon = new Prenda(400, new Promocion(100));
    Prenda camisa = new Prenda(500, new Nuevo());
    ItemVenta item1 = new ItemVenta(pantalon, 2);
    ItemVenta item2 = new ItemVenta(camisa, 3);
    List<ItemVenta> itemsVendidos = new ArrayList<>();
    itemsVendidos.add(item1);
    itemsVendidos.add(item2);
    Tarjeta tarjeta1 = new Tarjeta(2); // Pago con tarjeta 2 cuotas monto fijo 0.2
    Assertions.assertEquals(21.4, tarjeta1.recargo(itemsVendidos));
  }

  @Test
  public void montoFinalPagoTarjeta() {
    Prenda pantalon = new Prenda(400, new Promocion(100));
    Prenda camisa = new Prenda(500, new Nuevo());
    ItemVenta item1 = new ItemVenta(pantalon, 2);
    ItemVenta item2 = new ItemVenta(camisa, 3);
    List<ItemVenta> itemsVendidos = new ArrayList<>();
    itemsVendidos.add(item1);
    itemsVendidos.add(item2);
    Tarjeta tarjeta1 = new Tarjeta(2); // Pago con tarjeta 2 cuotas monto fijo 0.2
    Venta venta = new Venta(itemsVendidos, tarjeta1);
    Assertions.assertEquals(2121.4, venta.montoACobrar());
  }


}

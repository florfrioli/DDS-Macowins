import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
  private List<ItemVenta> items = new ArrayList<>();
  private Date fecha = new Date(); // ver como modelar la fecha
  private MedioDePago medioDePago;

  public Venta(List<ItemVenta> items, MedioDePago medioDePago){
    this.items = items;
    this.medioDePago = medioDePago;
  }

  public double montoTotal(){
    double sum = this.items.stream()
        .mapToDouble(item -> item.montoItem())
        .sum();
    return sum; // recorrer los items --> item.montoItem() y sumarlos
  }

  public double montoACobrar(){
    return this.montoTotal() + medioDePago.recargo(this.items);
  }
}

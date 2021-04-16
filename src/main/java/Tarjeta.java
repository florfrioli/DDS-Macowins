import java.util.List;

public class Tarjeta implements MedioDePago {
  private int cuotas;
  private double coeficienteFijo = 0.2;

  public Tarjeta(int cuotas) {
    this.cuotas = cuotas;
  }

  public double recargo(List<ItemVenta> itemsVendidos) {
    double recargoDeLaPrenda = itemsVendidos.stream()
        .mapToDouble(item -> item.montoItem() * 0.01)
        .sum();
    return this.cuotas * this.coeficienteFijo + recargoDeLaPrenda;
  }
}

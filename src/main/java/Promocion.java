public class Promocion implements Estado {
  private double montoDescuento;

  public Promocion(double montoDescuento) {
    this.montoDescuento = montoDescuento;
  }

  public double descuento(double precio) {
    return this.montoDescuento;
  }
}


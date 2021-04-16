public class Liquidacion implements Estado {
  private double montoDescuento = 0.5;

  public double descuento(double precio) {

    return this.montoDescuento * precio;
  }
}

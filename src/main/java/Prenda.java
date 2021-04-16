public class Prenda {
  private double precio;
  private Estado estado;

  public Prenda( double precio, Estado estado ){
    this.precio = precio;
    this.estado = estado;
  }

  public double precio(){
    return this.precio - this.estado.descuento(this.precio);
  }
}

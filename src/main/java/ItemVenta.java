public class ItemVenta {
  private Prenda prenda;
  private int cantidad;

  public Prenda getPrenda() {
    return prenda;
  }

  public ItemVenta(Prenda prenda, int cantidad){
    this.prenda = prenda;
    this.cantidad = cantidad;
  }

  public double montoItem(){
    return this.prenda.precio()*cantidad;
  }
}

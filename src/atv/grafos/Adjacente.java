package atv.grafos;

public class Adjacente {
  public int cor;
  private int id;
  private double peso;

  public Adjacente(int id, double peso){
    this.id = id;
    this.peso = peso;
  }
  public int getId(){
    return this.id;
  }
  public double getPeso(){
    return this.peso;
  }

}

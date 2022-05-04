package atv.grafos;

public class ListaAdjacentes {
	 int vertice;
	 int peso;
	
	public ListaAdjacentes(int vertice, int peso) {
		this.vertice = vertice;
		this.peso = peso;
				
	}
	
	public int getVertice() {
		return this.vertice;
	}
	
	public int getPeso() {
		return this.peso;
	}

	@Override
	public String toString() {
		return "ListaAdjacentes [vertice=" + vertice + ", peso=" + peso + "]";
	}
	
}

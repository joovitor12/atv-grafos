package atv.grafos;

public class MenorCaminho {
	public int distancia[];
	public int caminho[];
	public MenorCaminho(int[] distancia, int[] caminho) {
		super();
		this.distancia = distancia;
		this.caminho = caminho;
	}
	public int[] getDistancia() {
		return distancia;
	}
	public void setDistancia(int[] distancia) {
		this.distancia = distancia;
	}
	public int[] getCaminho() {
		return caminho;
	}
	public void setCaminho(int[] caminho) {
		this.caminho = caminho;
	}
	
	
	
	
	
}

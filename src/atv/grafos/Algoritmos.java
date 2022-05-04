package atv.grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algoritmos {
	
	public void criaGrafo(LinkedList<Vertice> vertices, ArrayList<ArrayList<ListaAdjacentes>> grafo) {
		for (int i = 0; i < vertices.size(); i++) {
			grafo.add(new ArrayList<>());
		}
	}
	
	public void setAdjacentes(LinkedList<Vertice> vertices, LinkedList<Arestas> arestas, ArrayList<ArrayList<ListaAdjacentes>> grafo) {
		for(int i = 0; i < vertices.size(); i++) {
			Vertice vertice = vertices.get(i);
			for(int j = 0; j < arestas.size(); j++) {
				Arestas aresta = arestas.get(j);
				if(aresta.getIdVerticeOrigem() == vertice.getId()) {
					grafo.get(i).add(new ListaAdjacentes(aresta.getIdVerticeDestino(),aresta.getPeso()));
					
				}else if(aresta.getIdVerticeDestino() == vertice.getId()) {
					grafo.get(i).add(new ListaAdjacentes(aresta.getIdVerticeOrigem(), aresta.getPeso()));
				}
			}
		}
	}
	public void printarAdjacentes(ArrayList<ArrayList<ListaAdjacentes>> grafo) {
		for(int i = 0; i < grafo.size(); i++) {
			int vertice = i + 1;
			System.out.println("Vértice " + vertice + " possui os seguintes adjacentes...");
			for(int j = 0; j < grafo.get(i).size(); j++) {
				System.out.println("Vértice -> " + grafo.get(i).get(j).getVertice());
				System.out.println("Peso -> " + grafo.get(i).get(j).getPeso());
			}
			System.out.println();
		}
	}
	public static MenorCaminho algoritmo_dijkstra(int dist, ArrayList<ArrayList<ListaAdjacentes>> grafo, int fonte) {
		int[] distancia = new int[dist];
		int[] anterior = new int[dist];

		for (int i = 0; i < dist; i++)
			distancia[i] = Integer.MAX_VALUE;
		//distancia[fonte] = 0;

		PriorityQueue<ListaAdjacentes> fila = new PriorityQueue<>((v1, v2) -> v1.getPeso() - v2.getPeso());
		fila.add(new ListaAdjacentes(fonte, 0));

		while (fila.size() > 0) {
			ListaAdjacentes vertice = fila.poll();
			ArrayList<ListaAdjacentes> lista = grafo.get(vertice.getVertice() - 1);
			for (ListaAdjacentes v : lista) {
				if (distancia[vertice.getVertice() - 1] + v.getPeso() < distancia[v.getVertice() - 1]) {
					anterior[v.getVertice() - 1] = vertice.getVertice();

					distancia[v.getVertice() - 1] = v.getPeso() + distancia[vertice.getVertice() - 1];
					fila.add(new ListaAdjacentes(v.getVertice(), distancia[v.getVertice() - 1]));

				}
			}
		}
		distancia[fonte - 1] = 0;
		anterior[fonte - 1] = 0;

		MenorCaminho caminho = new MenorCaminho(distancia, anterior);
		return caminho;
	}
	public static MenorCaminho busca_em_largura(int dist, ArrayList<ArrayList<ListaAdjacentes>> grafo, int fonte) {
		int[] distancia = new int[dist];
		int[] anterior = new int[dist];
		int[] cor = new int[dist];
		for (int i = 0; i < dist; i++) {
			distancia[i] = -1;
			cor[i] = 1;
			anterior[i] = -1;
		}
		distancia[fonte - 1] = 0;
		cor[fonte - 1] = 0;
		
		ArrayList<ListaAdjacentes> verticeFonte = grafo.get(fonte-1);
		Queue<ArrayList<ListaAdjacentes>> fila = new LinkedList<ArrayList<ListaAdjacentes>>();
		fila.add(verticeFonte);
		
		
		while(!fila.isEmpty()) {
			ArrayList<ListaAdjacentes> adjacentes = fila.poll();
			int indiceVerticeAdj = grafo.indexOf(adjacentes);
			
			for(ListaAdjacentes lista : adjacentes) {
				int indiceVertice = lista.getVertice() - 1;
				if(cor[indiceVertice] == 1) {
					
					fila.add(grafo.get(indiceVertice));
					cor[indiceVertice] = 2;
					distancia[indiceVertice] = distancia[indiceVerticeAdj] + 1;
					anterior[indiceVertice] = indiceVerticeAdj + 1;
				}
			}
			cor[indiceVerticeAdj] = 3;
		}
		
		distancia[fonte-1] = 0;
		anterior[fonte-1]= 0;
		MenorCaminho menorCaminho = new MenorCaminho(distancia, anterior);
		return menorCaminho;
	}
	public void printMenorCaminhoBL(int tamanho, ArrayList<ArrayList<ListaAdjacentes>> grafo, int vertice, LinkedList<Vertice> vertices) {
		MenorCaminho buscaEmLargura = busca_em_largura(tamanho, grafo, vertice);
		int[] menorDistanciaBL = buscaEmLargura.getDistancia();
		int[] menorCaminhoBL = buscaEmLargura.getCaminho();
		
		System.out.println("-------------------BUSCA EM LARGURA---------------");
		for(int i = 0; i < tamanho; i++) {
			if(menorDistanciaBL[i] == Integer.MAX_VALUE) {
				System.out.println("Distância do vértice " + vertices.get(i).getId() + " para o vértice " + vertice
						+ " : INFINITO");
			} else if(vertices.get(i).getId() == 1) {
				System.out.println("Distância do vértice " + vertices.get(i).getId() + " para o vértice " + vertice + " : 0");
			} else {
				System.out.println("Distância do vértice "+ vertices.get(i).getId() + " para o vértice " + vertice + " : " 
			+ menorDistanciaBL[i]);
				System.out.println("Menor caminho: " + menorCaminhoBL[i]);
			}
		
	}
	}
	public void printMenorCaminhoDijkstra(int tamanho, ArrayList<ArrayList<ListaAdjacentes>> grafo, int vertice, LinkedList<Vertice> vertices) {	
		MenorCaminho dijkstra = algoritmo_dijkstra(tamanho, grafo, vertice);
		int[] menorCaminho = dijkstra.getCaminho();
		int[] menorDistancia = dijkstra.getDistancia();
		for (int i = 0; i < tamanho; i++) {
			if (menorDistancia[i] == Integer.MAX_VALUE) {
				System.out.println("Distância do vértice " + vertices.get(i).getId() + " para o vértice " + vertice
						+ " : INFINITO");
				System.out.println("Caminho inexistente");
			} else if (vertices.get(i).getId() == 1) {
				System.out.println(
						"Distância do vértice " + vertices.get(i).getId() + " para o vértice " + vertice + " : 0");
			} else if (vertices.get(i).getId() == 1 + 1) {
				System.out.println("Distância do vértice " + vertices.get(i).getId() + " para o vértice " + vertice
						+ " : " + (menorDistancia[i] + Integer.MAX_VALUE + 2));
				System.out.println("Menor caminho: " + menorCaminho[i]);
			} else {
				System.out.println("Distância do vértice " + vertices.get(i).getId() + " para o vértice " + vertice
						+ " : " + (menorDistancia[i] + Integer.MAX_VALUE + 2));
				System.out.println("Menor caminho: " + menorCaminho[i]);
			}
		}
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atv.grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Program {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner in = new Scanner(System.in);
		File arquivo;
		Scanner leitor;
		Algoritmos a = new Algoritmos();
		LinkedList<Vertice> vertices = new LinkedList<Vertice>();
		LinkedList<Arestas> arestas = new LinkedList<Arestas>();
		int op;
		int verticeFonte = 1;
		arquivo = new File("vertices.txt");
		leitor = new Scanner(arquivo);
		while (leitor.hasNextLine()) {
			String dados = leitor.nextLine();
			String[] dadosFiltrados = dados.split(",");
			int id = Integer.parseInt(dadosFiltrados[0]);
			String nome = dadosFiltrados[1];
			Vertice vertice = new Vertice(id, nome);
			vertices.add(vertice);
		}
		leitor.close();
		File arquivoArestas = new File("arestas.txt");
		leitor = new Scanner(arquivoArestas);
		while (leitor.hasNextLine()) {
			String dados = leitor.nextLine();
			String[] dadosFiltrados = dados.split(",");
			int id = Integer.parseInt(dadosFiltrados[0]);
			int idVerticeOrigem = Integer.parseInt(dadosFiltrados[1]);
			int idVerticeDestino = Integer.parseInt(dadosFiltrados[2]);
			int peso = Integer.parseInt(dadosFiltrados[3]);
			Arestas aresta = new Arestas(id, idVerticeOrigem, idVerticeDestino, peso);
			arestas.add(aresta);
		}
		leitor.close();

		int tamanho = vertices.size();
		ArrayList<ArrayList<ListaAdjacentes>> grafo = new ArrayList<>();
		a.criaGrafo(vertices, grafo);
		a.setAdjacentes(vertices, arestas, grafo);

		do {
			menu();
			op = in.nextInt();
			switch (op) {
				case 1:
					a.printarAdjacentes(grafo);
					break;
				case 2:
					System.out.println("Qual v�rtice voc� deseja calcular o menor caminho? 1-26");
					verticeFonte = in.nextInt();
					while (verticeFonte < 1 || verticeFonte > 26) {
						System.out.println("V�rtice inv�lido");
						System.out.println("Qual v�rtice voc� deseja calcular o menor caminho? 1-26");
						verticeFonte = in.nextInt();
					}
					a.printMenorCaminhoDijkstra(tamanho, grafo, verticeFonte, vertices);
					break;
				case 3:
					System.out.println("Qual v�rtice voc� deseja calcular o menor caminho? 1-26");
					verticeFonte = in.nextInt();
					while (verticeFonte < 1 || verticeFonte > 26) {
						System.out.println("V�rtice inv�lido");
						System.out.println("Qual v�rtice voc� deseja calcular o menor caminho? 1-26");
						verticeFonte = in.nextInt();
					}
					a.printMenorCaminhoBL(tamanho, grafo, verticeFonte, vertices);
					break;

			}
		} while (op != 0);
		//////////////////////// ADICIONANDO OS ADJACENTES////////////////////////

		// a.printarAdjacentes(grafo);

		/////////////////////// DIJKSTRA////////////////////////////////////////////
		// a.printMenorCaminhoDijkstra(tamanho, grafo, verticeFonte, vertices);
		/////////////////// BUSCA EM LARGURA///////////////////////////////////////
		// a.printMenorCaminhoBL(tamanho, grafo, verticeFonte, vertices);

	}

	public static void menu() {
		System.out.println("BEM VINDO");
		System.out.println("1 - Exibir grafo e seus v�rtices ( com adjac�ncia )");
		System.out.println("2 - Aplicar o algoritmo de Dijkstra");
		System.out.println("3 - Aplicar o algoritmo da busca em largura");
		System.out.println("0 - Encerrar");
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atv.grafos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author aluno
 */
public class Vertice {

    public Vertice(int id, String nome, Adjacente[] adjacentes) {
		super();
		this.id = id;
		this.nome = nome;
		this.adjacentes = adjacentes;
	}

	public Vertice(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    
    
    private int id;
    private String nome;
    private Adjacente[] adjacentes;
    private ArrayList<Arestas> arestasEntrada;
    private ArrayList<Arestas> arestasSaida;
    
    
    public void adicionarArestaEntrada(Arestas aresta) {
    	this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Arestas aresta) {
    	this.arestasSaida.add(aresta);
    }
  
    public ArrayList<Arestas> getArestasEntrada() {
		return arestasEntrada;
	}

	public void setArestasEntrada(ArrayList<Arestas> arestasEntrada) {
		this.arestasEntrada = arestasEntrada;
	}

	public ArrayList<Arestas> getArestasSaida() {
		return arestasSaida;
	}

	public void setArestasSaida(ArrayList<Arestas> arestasSaida) {
		this.arestasSaida = arestasSaida;
	}

	public Adjacente[] getAdjacentes() {
		return adjacentes;
	}

	public void setAdjacentes(Adjacente[] adjacentes) {
		this.adjacentes = adjacentes;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
   

	@Override
	public String toString() {
		return "Vertice [id=" + id + ", nome=" + nome + ", adjacentes=" + Arrays.toString(adjacentes) + "]";
	}
	
	public void adicionarAdjacente(int id, double peso){
        Adjacente[] adjacente = new Adjacente[adjacentes.length + 1];
        for(int i = 0; i < adjacentes.length; i++){
            adjacente[i] = adjacentes[i];
        }
        adjacente[adjacentes.length] = new Adjacente(id, peso);
        adjacentes = adjacente;
    }

    
    
    
    
}

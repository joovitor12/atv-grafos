/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atv.grafos;

/**
 *
 * @author aluno
 */
public class Arestas {
    private int id;
    private int idVerticeOrigem;
    private int idVerticeDestino;
    private int peso;

    public Arestas(int id, int idVerticeOrigem, int idVerticeDestino, int peso) {
        this.id = id;
        this.idVerticeOrigem = idVerticeOrigem;
        this.idVerticeDestino = idVerticeDestino;
        this.peso = peso;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVerticeOrigem() {
        return idVerticeOrigem;
    }

    public void setIdVerticeOrigem(int idVerticeOrigem) {
        this.idVerticeOrigem = idVerticeOrigem;
    }

    public int getIdVerticeDestino() {
        return idVerticeDestino;
    }

    public void setIdVerticeDestino(int idVerticeDestino) {
        this.idVerticeDestino = idVerticeDestino;
    }
   

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Arestas{" + "id=" + id + ", idVerticeOrigem=" + idVerticeOrigem + ", idVerticeDestino=" + idVerticeDestino + ", peso=" + peso + '}';
    }
    
    
}

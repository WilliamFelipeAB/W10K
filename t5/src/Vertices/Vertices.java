package Vertices;

import Arestas.Arestas;
import java.util.LinkedList;
import javafx.scene.shape.Circle;

public class Vertices {
    public Circle vertice;
    public LinkedList<Arestas> ligacao;

    public Vertices(Circle c, LinkedList<Arestas> nova) {
        this.vertice = c;
        this.ligacao = nova;
    }

    public Circle getVertice() {
        return vertice;
    }

    public void setVertice(Circle vertice) {
        this.vertice = vertice;
    }

    public LinkedList<Arestas> getLigacao() {
        return ligacao;
    }

    public void setLigacao(LinkedList<Arestas> ligacao) {
        this.ligacao = ligacao;
    }
}

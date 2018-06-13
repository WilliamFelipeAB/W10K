package Vertices;

import Arestas.Arestas;
import java.util.LinkedList;
import javafx.scene.shape.Circle;

public class Vertices {
    String Id;
    Circle c;
    LinkedList <Arestas> Arestas;

    public Vertices(String Id, Circle c, LinkedList<Arestas> Arestas) {
        this.Id = Id;
        this.c = c;
        this.Arestas = Arestas;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Circle getC() {
        return c;
    }

    public void setC(Circle c) {
        this.c = c;
    }

    public LinkedList<Arestas> getArestas() {
        return Arestas;
    }

    public void setArestas(LinkedList<Arestas> Arestas) {
        this.Arestas = Arestas;
    }
}

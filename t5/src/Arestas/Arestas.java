package Arestas;

import Vertices.Vertices;
import javafx.scene.shape.Line;

public class Arestas {
    public Vertices inicio;
    public Vertices fim;
    public Line aresta;

    public Vertices getInicio() {
        return inicio;
    }

    public void setInicio(Vertices inicio) {
        this.inicio = inicio;
    }

    public Vertices getFim() {
        return fim;
    }

    public void setFim(Vertices fim) {
        this.fim = fim;
    }

    public Line getAresta() {
        return aresta;
    }

    public void setAresta(Line aresta) {
        this.aresta = aresta;
    }
}

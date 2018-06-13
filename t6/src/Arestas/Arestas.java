package Arestas;

import Vertices.Vertices;
import javafx.scene.shape.Line;

public class Arestas {
    public Vertices ini;
    public Vertices fim;
    public Line l;

    public Arestas(Vertices ini, Vertices fim, Line l) {
        this.ini = ini;
        this.fim = fim;
        this.l = l;
    }

    public Vertices getIni() {
        return ini;
    }

    public void setIni(Vertices ini) {
        this.ini = ini;
    }

    public Vertices getFim() {
        return fim;
    }

    public void setFim(Vertices fim) {
        this.fim = fim;
    }

    public Line getL() {
        return l;
    }

    public void setL(Line l) {
        this.l = l;
    }
}

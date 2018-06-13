package Grafo;

import Arestas.Arestas;
import Vertices.Vertices;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Grafo {
    public LinkedList <Vertices> Vertices;

    public Grafo() {
        this.Vertices = new LinkedList<>();
    }

    public LinkedList<Vertices> getVertices() {
        return Vertices;
    }

    public void setVertices(LinkedList<Vertices> Vertices) {
        this.Vertices = Vertices;
    }
    public void inserir_vert(Vertices v)
    {
        this.Vertices.add(v);
    }
    public void inserir_ares(int index, Arestas a)
    {
        this.Vertices.get(index).getArestas().add(a);
    }
    public int intersec(LinkedList<Arestas> a)
    {
        int i=0;
        int j=0;
        int inter=0;
        for(i=0;i<a.size();i++)
        {
            Line l = a.get(i).getL();
            for(j=0;j<a.size();j++)
            {
                Line l2 = a.get(j).getL();
                if(Line2D.linesIntersect(l.getStartX(), 
                                          l.getStartY(), 
                                          l.getEndX(),
                                          l.getEndY(), 
                                          l2.getStartX(), 
                                          l2.getStartY(), 
                                          l2.getEndX(),
                                          l2.getEndY())
                                          && a.get(i).getIni() != a.get(j).getIni()
                                          && a.get(i).getIni() != a.get(j).getFim()
                                          && a.get(i).getFim() != a.get(j).getIni()
                                          && a.get(i).getFim() != a.get(j).getFim())
                {
                    inter++;
                }
            }
        }
        return inter/2;
    }
    public int qtd_vert(LinkedList<Vertices> v)
    {
        return v.size();
    }
    public int qtd_ares(LinkedList<Vertices> v)
    {
        int qtd = 0;
        for(int i=0;i<v.size();i++)
        {
            for(int j=0;j<v.get(i).getArestas().size();j++)
            {
                qtd++;
            }
        }
        return qtd;
    }
    
    public void gerar_vertices(int n, double width, double height)
    {
        Random random = new Random();
        Vertices.clear();
        for(int i=0;i<n;i++)
        {
            LinkedList<Arestas> a = new LinkedList<>();
            int ranX = random.nextInt((int)width); 
            int ranY = random.nextInt((int)height);
            if(ranX-20<0)
            {
                ranX+=20;
            }
            if(ranY-20<0)
            {
                ranY+=20;
            }
            if(ranX+20>width)
            {
                ranX-=20;
            }
            if(ranY+20>height)
            {
                ranY-=20;
            }
            Circle c = new Circle(ranX, ranY, 10, Color.GREENYELLOW);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(2.5);
            Vertices vert = new Vertices(null, c, a);
            Vertices.add(vert);
        }
    }
    
    public LinkedList<Arestas> gerar_arestas(LinkedList<Vertices> v)
    {
        LinkedList<Arestas> arest = new LinkedList<>();
        for(int i=0;i<Vertices.size();i++)
        {
            Vertices ini = Vertices.get(i);
            Vertices fim;
            if(ini == Vertices.getLast())
            {
                fim = Vertices.getFirst();
            }
            else
            {
                fim = Vertices.get(i+1);
            }
            Line l = new Line(ini.getC().getCenterX(), ini.getC().getCenterY(), fim.getC().getCenterX(), fim.getC().getCenterY());
            l.setStroke(Color.WHITESMOKE);
            l.setStrokeWidth(5);
            Arestas a = new Arestas(ini, fim, l);
            ini.getArestas().add(a);
            arest.add(a);
        }
        for(int i=0;i+2<Vertices.size();i++)
        {
            Vertices ini = Vertices.get(i);
            Vertices fim = Vertices.get(i+2);
            
            Line l = new Line(ini.getC().getCenterX(), ini.getC().getCenterY(), fim.getC().getCenterX(), fim.getC().getCenterY());
            l.setStroke(Color.WHITESMOKE);
            l.setStrokeWidth(5);
            Arestas a = new Arestas(ini, fim, l);
            ini.getArestas().add(a);
            arest.add(a);
        }
        return arest;
    }
}

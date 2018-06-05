package grafo;

import Arestas.Arestas;
import Vertices.Vertices;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Grafo extends Application {
    
    Circle c;
    Line l;
    int qtd_vert = 0;
    int qtd_ares = 0;
    int qtd_intr = 0;
    public LinkedList<Vertices> Vertices;
    
    @Override
    public void start(Stage primaryStage) {
        
        Button sair = new Button();
        Button criar = new Button();
        Button salvar = new Button();
        
        HBox h1 = new HBox(10);
        HBox h2 = new HBox(10);
        VBox v1 = new VBox(10);
        VBox v2 = new VBox(1);
        VBox v3 = new VBox(10);
        
        BorderPane bp = new BorderPane();
        
        RadioButton v = new RadioButton();
        RadioButton a = new RadioButton(); 
        
        ColorPicker cpv = new ColorPicker(Color.BLACK);
        ColorPicker cp2v = new ColorPicker(Color.BLACK);
        ColorPicker cpa = new ColorPicker(Color.BLACK);
        
        Slider sv = new Slider();
        Slider sv2 = new Slider();
        Slider sa = new Slider();
        
        ToggleGroup gp = new ToggleGroup();
        
        StackPane root = new StackPane();
        Pane pane = new Pane();
        
        Label vert = new Label("Vértices: " + qtd_vert);
        Label ares = new Label("Arestas: " + qtd_ares);
        Label inter = new Label("Intersecções entre arestas: " + qtd_intr);
        Label vb = new Label("Cor Borda:");
        Label vc = new Label("Cor Circulo:");
        Label vbt = new Label("Tamanho Borda:");
        Label vct = new Label("Tamanho Circulo:");
        Label ac =  new Label("Cor Linha:");
        Label at =  new Label("Largura Linha:");
        
        String style = "-fx-background-color: rgba(0, 0, 0, 1);";
        String style2 = "-fx-background-color: rgba(39, 231, 29, 1);";
        
        sair.setText("SAIR");
        criar.setText("CRIAR");
        salvar.setText("SALVAR");
        
        h1.setStyle(style2);
        h2.setStyle(style2);
        v1.setStyle(style);
        v3.setStyle(style);
        
        
        v.setText("Vértice");
        v.setTextFill(Color.GREEN);
        v.setToggleGroup(gp);
        v.setVisible(false);
        
        a.setText("Aresta");
        a.setTextFill(Color.GREEN);
        a.setToggleGroup(gp);
        a.setVisible(false);
        
        sv.setMin(0);
        sv.setMax(10);
        sv.setValue(5);
        sv.setShowTickLabels(true);
        sv.setShowTickMarks(true);
        sv.setMajorTickUnit(2.5f);
        sv.setBlockIncrement(1);
        sv.setVisible(false);
        
        sv2.setMin(0);
        sv2.setMax(10);
        sv2.setValue(5);
        sv2.setShowTickLabels(true);
        sv2.setShowTickMarks(true);
        sv2.setMajorTickUnit(2.5f);
        sv2.setBlockIncrement(1);
        sv2.setVisible(false);
        
        vb.setVisible(false);
        vc.setVisible(false);
        vbt.setVisible(false);
        vct.setVisible(false);
        ac.setVisible(false);
        at.setVisible(false);
        
        vb.setTextFill(Color.GREEN);
        vc.setTextFill(Color.GREEN);
        vbt.setTextFill(Color.GREEN);
        vct.setTextFill(Color.GREEN);
        ac.setTextFill(Color.GREEN);
        at.setTextFill(Color.GREEN);
        
        sa.setMin(0);
        sa.setMax(10);
        sa.setValue(5);
        sa.setShowTickLabels(true);
        sa.setShowTickMarks(true);
        sa.setMajorTickUnit(2.5f);
        sa.setBlockIncrement(1);
        sa.setVisible(false);
        
        bp.setTop(h1);
        bp.setLeft(v1);
        bp.setRight(v3);
        bp.setCenter(pane);
        bp.setBottom(h2);
        
         
        cpv.setStyle("-fx-color-label-visible: false ");
        cpv.setVisible(false);
        cp2v.setStyle("-fx-color-label-visible: false ");
        cp2v.setVisible(false);
        
        cpa.setStyle("-fx-color-label-visible: false ");
        cpa.setVisible(false);
        
        root.getChildren().add(bp);
        
        h1.getChildren().add(criar);
        h1.getChildren().add(salvar);
        h1.getChildren().add(sair);
        
        h2.getChildren().add(v2);
        
        v2.getChildren().add(vert);
        v2.getChildren().add(ares);
        v2.getChildren().add(inter);
        
        v1.getChildren().add(v);
        v1.getChildren().add(vc);
        v1.getChildren().add(cpv);
        v1.getChildren().add(vb);
        v1.getChildren().add(cp2v);
        v1.getChildren().add(vct);
        v1.getChildren().add(sv);
        v1.getChildren().add(vbt);
        v1.getChildren().add(sv2);
        
        v3.getChildren().add(a);
        v3.getChildren().add(ac);
        v3.getChildren().add(cpa);
        v3.getChildren().add(at);
        v3.getChildren().add(sa);
       
        pane.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                if (v.isSelected()) {            
                    c = new Circle();
                    c.setCenterX(e.getX());
                    c.setCenterY(e.getY());
                    c.setRadius(sv.getValue());
                    c.setFill(cpv.getValue());
                    c.setStrokeWidth(sv2.getValue());
                    c.setStroke(cp2v.getValue());
                    pane.getChildren().add(c);
                    qtd_vert++;
                    vert.setText("Vértices: " + qtd_vert);
                    LinkedList<Arestas> nova = new LinkedList<Arestas>();
                    Vertices novo;
                    novo = new Vertices(c, nova);
                }
                else if(a.isSelected())
                {
                    l = new Line(e.getX(), e.getY(), e.getX(), e.getY());
                    l.setStroke(cpa.getValue());
                    l.setStrokeWidth(sa.getValue());
                    pane.getChildren().add(l);
                    qtd_ares++;
                    ares.setText("Arestas: " + qtd_ares);
                    
                }
            }
        });
        
        pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (a.isSelected()) {
                    l.setEndX(e.getX());
                    l.setEndY(e.getY());
                } 
            }
        });
        
        sair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        criar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a.setVisible(true);
                v.setVisible(true);
                vc.setVisible(true);
                vb.setVisible(true);
                vct.setVisible(true);
                vbt.setVisible(true);
                ac.setVisible(true);
                at.setVisible(true);
                cpv.setVisible(true);
                cp2v.setVisible(true);
                cpa.setVisible(true);
                sa.setVisible(true);
                sv.setVisible(true);
                sv2.setVisible(true);
                
                if(v.isSelected())
                {
                    a.setSelected(false);
                }
            }
        });
        salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
 
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Editor De Grafos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

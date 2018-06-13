package t6;

import Arestas.Arestas;
import Grafo.Grafo;
import Vertices.Vertices;
import java.util.LinkedList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class T6 extends Application {
    public int nivel = 4;
    public int fase = 1;
    public Grafo grafo;
    public LinkedList<Arestas> arest = new LinkedList<>();
    @Override
    public void start(Stage primaryStage) {
        Button novo = new Button("Play");
        Button sair = new Button("Exit");
        Button check = new Button("Check");
        Button info = new Button("Info");
        ToolBar tb = new ToolBar(novo, check, info, sair);
        Label intersect = new Label("Intersecções: " + 0);
        Label fs = new Label("Fase: " + fase);
        VBox v1 = new VBox(5);
        ToolBar tl = new ToolBar(v1);
        BorderPane root = new BorderPane();
        Pane p1 = new Pane();
        
        p1.setStyle("-fx-background-color: #414141");
        fs.setTextFill(Color.GREENYELLOW);
        intersect.setTextFill(Color.GREENYELLOW);
        tl.setStyle("-fx-background-color: #000000");
        tb.setStyle("-fx-background-color: #000000");
        
        check.setDisable(true);
        
        intersect.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        fs.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        novo.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        sair.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        check.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        info.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        v1.getChildren().addAll(intersect,fs);
        
        root.setTop(tb);
        root.setCenter(p1);
        root.setBottom(tl);
        
        novo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                grafo = new Grafo();
                p1.getChildren().clear();
                arest.clear();
                check.setDisable(false);
                while(grafo.intersec(arest) == 0)
                {
                    grafo.gerar_vertices(nivel, p1.getWidth(), p1.getHeight());
                    arest = grafo.gerar_arestas(grafo.getVertices());
                }
                intersect.setText("Intersecções: " + grafo.intersec(arest));
                LinkedList<Vertices> vert = grafo.getVertices();
                for(int i=0;i<vert.size();i++)
                {
                    p1.getChildren().add(vert.get(i).getC());
                    for(int j=0;j<vert.get(i).getArestas().size();j++)
                    {
                        p1.getChildren().add(0,vert.get(i).getArestas().get(j).getL());
                    }
                }
            }
        });
        
        info.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert criar_novo = new Alert(Alert.AlertType.INFORMATION);
                criar_novo.setTitle("AJUDA");
                criar_novo.setHeaderText(null);
                criar_novo.setContentText("O JOGO TEM COMO OBJETIVO MOVINMETAR OS VÉRTICES ATÈ QUE O NÚMERO DE INTERSECÇÔES ENTRE\nARESTAS SEJA ZERO.\n\nPARA CHECAR SE VOCÊ OBTEVE ÊXITO NO NÌVEL\nCLIQUE EM 'Check' NA PARTE SUPERIOR DA TELA");
                DialogPane dialogPane = criar_novo.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                dialogPane.getStyleClass().add("Style");

                criar_novo.showAndWait();
            }
        });
        
        sair.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.close();
            }
        });
        
        p1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                LinkedList<Vertices> vert = grafo.getVertices();
                for(int i=0;i<vert.size();i++)
                {
                    if(event.getTarget() == vert.get(i).getC())
                    {
                        vert.get(i).getC().setFill(Color.RED);
                    }
                }
            }
        });
        
        p1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                LinkedList<Vertices> vert = grafo.getVertices();
                for(int i=0;i<vert.size();i++)
                {
                    if(event.getTarget() == vert.get(i).getC() && event.getX() < p1.getWidth() - 10 && event.getX() > 10 && event.getY() < p1.getHeight() -10 && event.getY() > 10)
                    {
                        vert.get(i).getC().setCenterX(event.getX());
                        vert.get(i).getC().setCenterY(event.getY());
                        vert.get(i).getC().setFill(Color.RED);
                        for(int j=0;j<arest.size();j++)
                        {
                            if(arest.get(j).getIni() == vert.get(i))
                            {
                                arest.get(j).getL().setStartX(event.getX());
                                arest.get(j).getL().setStartY(event.getY());
                            }
                            if(arest.get(j).getFim() == vert.get(i))
                            {
                                arest.get(j).getL().setEndX(event.getX());
                                arest.get(j).getL().setEndY(event.getY());
                            }
                        }
                    }
                }
                intersect.setText("Intersecções: " + grafo.intersec(arest));
            }
        });
        
        p1.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                LinkedList<Vertices> vert = grafo.getVertices();
                for(int i=0;i<vert.size();i++)
                {
                    if(event.getTarget() == vert.get(i).getC())
                    {
                        vert.get(i).getC().setFill(Color.GREENYELLOW);
                        grafo.intersec(arest);
                    }
                }
            }
        });
        
        check.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                LinkedList<Vertices> vert = grafo.getVertices();
                if(grafo.intersec(arest) == 0)
                {
                    Alert criar_novo = new Alert(Alert.AlertType.INFORMATION);
                    criar_novo.setTitle("NÍVEL CONCLUÍDO");
                    criar_novo.setHeaderText(null);
                    criar_novo.setContentText("VOCÊ CONCLUIU O NÍVEL " + fase + ".\nPARABÉNS!!!\nAVANCE PARA O PRÓXIMO NÍVEL.");
                    DialogPane dialogPane = criar_novo.getDialogPane();
                    dialogPane.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    dialogPane.getStyleClass().add("Style");
                    
                    Optional<ButtonType> op = criar_novo.showAndWait();
                    if(op.isPresent())
                    {
                        if(op.get().equals(ButtonType.OK))
                        {
                            grafo = new Grafo();
                            p1.getChildren().clear();
                            arest.clear();
                            nivel++;
                            fase++;
                            while(grafo.intersec(arest) == 0)
                            {
                                grafo.gerar_vertices(nivel, p1.getWidth(), p1.getHeight());
                                arest = grafo.gerar_arestas(grafo.getVertices());
                            }
                            intersect.setText("Intersecções: " + grafo.intersec(arest));
                            fs.setText("Fase: " + fase);
                            vert = grafo.getVertices();
                            for(int i=0;i<vert.size();i++)
                            {
                                p1.getChildren().add(vert.get(i).getC());
                                for(int j=0;j<vert.get(i).getArestas().size();j++)
                                {
                                    p1.getChildren().add(0,vert.get(i).getArestas().get(j).getL());
                                }
                            }
                        }
                    }
                    else
                    {
                        criar_novo.close();
                    }
                }
                else
                {
                    Alert criar_novo = new Alert(Alert.AlertType.INFORMATION);
                    criar_novo.setTitle("NÍVEL INCONCLUÍDO");
                    criar_novo.setHeaderText(null);
                    criar_novo.setContentText("VOCÊ NÃO CONCLUIU O NÍVEL " + fase + ".\nAINDA FALTA(M) RESOLVER " + grafo.intersec(arest) + " INTERSECÇÃO(ÕES).");
                    DialogPane dialogPane = criar_novo.getDialogPane();
                    dialogPane.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    dialogPane.getStyleClass().add("Style");
                    
                    criar_novo.showAndWait();
                }
            }
        });
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Planarity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
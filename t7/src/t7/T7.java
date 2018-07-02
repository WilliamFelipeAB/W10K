package t7;

import Controller.Controller;
import Data.Data;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T7 extends Application {
    Controller control = new Controller();
    BorderPane root = new BorderPane();
    TableView<Data> Tabela = new TableView<>();
    LinkedList<Label> info;
    Button DadosOnline = new Button("Pesquisar Online");
    Button DadosOffline = new Button("Pesquisar Offline");
    BarChart<String, Number> Chart;
    PieChart pie;
    VBox v1 = new VBox(15);
    VBox v2 = new VBox(15);
    VBox v3 = new VBox(15);
    VBox v4 = new VBox(15);
    HBox h1= new HBox(15);
    
    @Override
    public void start(Stage primaryStage) {
        InicializaTable();
        InicializaPizza();
        InicializaBarra();
        InicializaLabel();
        
        Button bt1 = control.DadosOnline(Tabela, pie, Chart, info);
        Button bt2 = control.DadosOffline(Tabela, pie, Chart, info, primaryStage);
        Button bt3 = control.DadosPorLinha(Tabela, pie, Chart, info);
        Button bt4 = control.PosicaoOnibus(Tabela, pie, Chart, info);
        
        bt1.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        bt2.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        bt3.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        bt4.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        root.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        h1.getChildren().addAll(bt1, bt2, bt3, bt4);
        v1.getChildren().addAll(pie);
        v2.getChildren().addAll(Tabela,h1,v4);
        v3.getChildren().addAll(Chart);
        v4.getChildren().addAll(info);
        
        root.setLeft(v1);
        root.setCenter(v2);
        root.setRight(v3);
        
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("Stye.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);
    }
    
    public void InicializaLabel(){
        info = new LinkedList<>();
        info.add(new Label()); //ultima leitura
        info.add(new Label()); //datahora mais recente
        info.add(new Label()); //datahora menos recente
        info.add(new Label()); //qtd veiculos
        for (int i = 0;i<info.size();i++)
        {
            info.get(i).getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        }
        control.AtualizaLabels(info);
    }

    public void InicializaPizza() {
        pie = new PieChart();
        pie.setPrefWidth(440);
        pie.setMinWidth(440);
        control.Pie(pie);
    }

    public void InicializaBarra() {
        CategoryAxis X = new CategoryAxis();
        NumberAxis Y = new NumberAxis();
        X.setLabel("Linha do Veiculo");       
        Y.setLabel("Qtd. de veiculos em movimento na linha");
 
        Chart = new BarChart<>(X,Y);
        Chart.setTitle("Movimentação na linha");
        Chart.setMinWidth(445);
        Chart.setPrefWidth(445);
        Chart.setLegendVisible(false);
        
        control.Barras(Chart);
    }

    public void InicializaTable() {
        Tabela = new TableView<>();

        TableColumn<Data,String> Data = new TableColumn<>("DATA");
        Data.setCellValueFactory(cellData -> cellData.getValue().DataProperty());
        Tabela.getColumns().add(Data);

        TableColumn<Data,String> Ordem = new TableColumn<>("ORDEM");
        Ordem.setCellValueFactory(cellData -> cellData.getValue().OrdemProperty());
        Tabela.getColumns().add(Ordem);

        TableColumn<Data,String> Linha = new TableColumn<>("LINHA");
        Linha.setCellValueFactory(cellData -> cellData.getValue().LinhaProperty());
        Tabela.getColumns().add(Linha);

        TableColumn<Data,String> Latitude = new TableColumn<>("LATITUDE");
        Latitude.setCellValueFactory(cellData -> cellData.getValue().LatitudeProperty());
        Tabela.getColumns().add(Latitude);

        TableColumn<Data,String> Longitude = new TableColumn<>("LONGITUDE");
        Longitude.setCellValueFactory(cellData -> cellData.getValue().LongitudeProperty());
        Tabela.getColumns().add(Longitude);

        TableColumn<Data,String> Velocidade = new TableColumn<>("VELOCIDADE");
        Velocidade.setCellValueFactory(cellData -> cellData.getValue().VelocidadeProperty());
        Tabela.getColumns().add(Velocidade);
        
        Tabela.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

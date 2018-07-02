package Controller;

import Data.Data;
import Model.Model;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    Model novo = new Model();
    
    public void AtualizaLabels(LinkedList<Label> info){
        info.get(0).setText("Ultima leitura: " + novo.UltimaLeituraServer());
        info.get(1).setText("Data/Hora mais recente: " + novo.DataHoraMaisRecente());
        info.get(2).setText("Data/Hora menos recente: " + novo.DataHoraMenosRecente());
        info.get(3).setText("Quantidade de Veiculos: " + novo.QuantVeiculos());
    }


    public void Pie(PieChart grapico) {
        int qtd_parados = novo.QuantVeiculosParados();
        
        
        grapico.setTitle("Movimentação");
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data(qtd_parados + " veiculos parado(s)", qtd_parados),
                new PieChart.Data(novo.QuantVeiculosEmMovimento() + " veiculos em movimento", novo.QuantVeiculosEmMovimento()));
        
        grapico.setData(pieChartData);
        
    }

    
    public void Barras(BarChart bar) {
        XYChart.Series<String,Number> barras = new XYChart.Series<>();

        LinkedList<String> linhas_veiculos = novo.Linhas();
        for (int i=0;i<linhas_veiculos.size();i++) {
            int qtd_veiculos = novo.QuantVeiculosEmMovimentoPorLinha(linhas_veiculos.get(i));
            if (qtd_veiculos > 0)
                barras.getData().add(new XYChart.Data<>(linhas_veiculos.get(i), qtd_veiculos));
        }

        bar.getData().clear();
        bar.getData().add(barras);
    }

    public Button DadosOffline(TableView<Data> table, PieChart pie, BarChart bar, LinkedList<Label> Info, Stage stage) {
        FileChooser fc = new FileChooser();
        Button btn = new Button("Search Offline");
        btn.setFont(new Font("Arial", 14));
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ObservableList<Data> observable = FXCollections.observableArrayList();
                File file = fc.showOpenDialog(stage);
                if (file != null) {
                    for (Data D : novo.DadosOfflineLeitura(file))
                    {
                        observable.add(D);
                    }
                    table.setItems(observable);
                    AtualizaLabels(Info);
                    Pie(pie);
                    Barras(bar);
                }
            }
        });

        return btn;
    }
    
    public Button DadosOnline(TableView<Data> table, PieChart pie, BarChart bar, LinkedList<Label> info) {
        Button btn = new Button("Search Online");
        btn.setFont(new Font("Arial", 14));
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ObservableList<Data> list = FXCollections.observableArrayList();
                for(Data d : TodosVeiculos())
                {
                    list.add(d);
                }
                table.setItems(list);
                AtualizaLabels(info);
                Pie(pie);
                Barras(bar);
            }
        });

        return btn;
    }
    
    public Button DadosPorLinha(TableView<Data> table, PieChart pie, BarChart bar, LinkedList<Label> info) {
        Button btn = new Button("Buscar linha");
        btn.setFont(new Font("Arial", 14));
    
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Linha");
                dialog.setHeaderText("Informe a linha a qual deseja buscar!");
                dialog.setContentText("Digite a linha:");
                
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    ObservableList<Data> lista = FXCollections.observableArrayList();
                    for(int i =0;i<TodosVeiculosLinha(result.get()).size();i++)
                    {
                        lista.add(TodosVeiculosLinha(result.get()).get(i));
                    }
                    table.setItems(lista);
                    AtualizaLabels(info);
                    Pie(pie);
                    Barras(bar);
                }
            }
        });

        return btn;
    }

    public Button PosicaoOnibus(TableView<Data> table, PieChart pie, BarChart bar, LinkedList<Label> info) {
        Button btn = new Button("Buscar onibus");
        btn.setFont(new Font("Arial", 14));

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Onibus");
                dialog.setHeaderText(null);
                dialog.setContentText("Digite a ordem do onibus a qual deseja buscar:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    ObservableList<Data> lista = FXCollections.observableArrayList();
                    for(int i=0;i<PosicoesOnibus(result.get()).size();i++)
                    {
                        lista.add(PosicoesOnibus(result.get()).get(i));
                    }
                    table.setItems(lista);
                    AtualizaLabels(info);
                    Pie(pie);
                    Barras(bar);
                }
            }
        });

        return btn;
    }
    public LinkedList<Data> TodosVeiculos() 
    {   
        Map Dados = novo.jsonMap("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterTodasPosicoes");
        return novo.preencherArrayDados(Dados);
    }

    public LinkedList<Data> TodosVeiculosLinha(String linha) {
        Map Dados = novo.jsonMap("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterPosicoesDaLinha/" + linha);
        return novo.preencherArrayDados(Dados);
    }

    public LinkedList<Data> PosicoesOnibus(String ordem) {
        Map Dados = novo.jsonMap("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterPosicoesDoOnibus/" + ordem);
        return novo.preencherArrayDados(Dados);
    }
}

package Model;

import Data.Data;
import Json.HttpJSONService;
import Json.JSONParsing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.scene.control.Alert;
import javax.script.ScriptException;

public class Model{
    
    HttpJSONService http = new HttpJSONService();
    LinkedList<Data> Dados = new LinkedList<>();
    
    public LinkedList<Data> preencherArrayDados(Map lista)
    {
        Dados.clear();
       
        if(lista == null)
        {
            return null;
        }
        else
        {
            for (Object l : (List)lista.get("DATA"))
            {
                Dados.add(new Data((List)l));
            }
            return Dados;
        }
    }
    
    public LinkedList<Data> DadosOfflineLeitura(File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            preencherArrayDados(new JSONParsing().parseJSON(br.readLine()));
        } catch (IOException | ScriptException e1) {
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e3) {
            }
        }
        return Dados;
    }
    public boolean comparaData(String d1, String d2)
    {
        SimpleDateFormat data = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        try {
            if(data.parse(d1).before(data.parse(d2)))
            {
                return true;
            }
        } catch (ParseException ex) {
            System.out.println("ERRO");
        }
        return false;
    }
    public String DataHoraMaisRecente()
    {
        System.out.println("AAAAAAAAAAAA");
        if(Dados.isEmpty())
        {
             return "00/00/0000 00:00:00";
        }
        String DataHoraMaisRecente = Dados.get(0).getData();
        
        for(int i =0;i<Dados.size();i++)
        {
            
            if(comparaData(DataHoraMaisRecente, Dados.get(i).getData()))
            {
                DataHoraMaisRecente = Dados.get(i).getData();
            }
        }
        return  DataHoraMaisRecente;
    }
    
    public String DataHoraMenosRecente()
    {
        
        if(Dados.isEmpty())
        {
            return "00/00/0000 00:00:00";
        }
        String DataHoraMenosRecente = (String)Dados.get(0).getData();
        
        for(int i =0;i<Dados.size();i++)
        {
            if(comparaData(Dados.get(i).getData(), DataHoraMenosRecente))
            {
                DataHoraMenosRecente = Dados.get(i).getData();
            }
        }
        return  DataHoraMenosRecente;
    }
    
    public int QuantVeiculos()
    {
        return Dados.size();
    }
    
    public int QuantVeiculosParados()
    {
        int parados = 0;
        for(int i=0;i<Dados.size();i++)
        {
            if(Dados.get(i).getVelocidade() == 0.0)
            {
                parados++;
            }
        }
        return  parados;
    }
    
    public int QuantVeiculosEmMovimento()
    {
        return QuantVeiculos() - QuantVeiculosParados();
    }
    
    public int QuantVeiculosEmMovimentoPorLinha(String Linha)
    {
        int EmMovimento = 0;
        for(int i=0;i<Dados.size();i++)
        {
            if(Dados.get(i).getLinha().equals(Linha) && Dados.get(i).getVelocidade() > 0.0)
            {
                EmMovimento++;
            }
        }
        return  EmMovimento;
    }
    
    public LinkedList<String> Linhas() {
        
        LinkedList<String> linhas = new LinkedList<>();
        for (int i=0;i<Dados.size();i++) {
            if (!linhas.contains(Dados.get(i).getLinha()))
                linhas.add(Dados.get(i).getLinha());
        }
        linhas.remove("");
        return linhas;
    }
    
    public String UltimaLeituraServer()
    {
        return new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }
    
    public Map jsonMap(String Url)
    {    
        Map json = null;
        try {
          json = http.sendGet(Url);
        } catch (Exception e) {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning");
          alert.setHeaderText("Connection failed");
          alert.setContentText("Please check your Internet connection!");
          alert.showAndWait();
        }
        return json;
    }
}
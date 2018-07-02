package Data;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class Data {
    SimpleStringProperty Data;
    SimpleStringProperty Ordem;
    SimpleStringProperty Linha;
    SimpleStringProperty Latitude;
    SimpleStringProperty Longitude;
    SimpleStringProperty Velocidade;
    
    public Data(List dados) {
        this.Data = new SimpleStringProperty((String)dados.get(0));
        this.Ordem = new SimpleStringProperty((String)dados.get(1));
        this.Linha = new SimpleStringProperty(String.valueOf(dados.get(2)));
        this.Latitude = new SimpleStringProperty(String.valueOf(dados.get(3)));
        this.Longitude = new SimpleStringProperty(String.valueOf(dados.get(4)));
        this.Velocidade = new SimpleStringProperty(String.valueOf(dados.get(5)));
    }

    public SimpleStringProperty DataProperty() {
        return Data;
    }

    public String getData(){
        return Data.get();
    }
    
    public void setData(String Data) {
        this.Data.set(Data);
    }

    public SimpleStringProperty OrdemProperty() {
        return Ordem;
    }
    
    public String getOrdem() {
        return Ordem.get();
    }
    
    public void setOrdem(String Ordem) {
        this.Ordem.set(Ordem);
    }

    public SimpleStringProperty LinhaProperty() {
        return Linha;
    }
    
    public String getLinha() {
        return Linha.get();
    }
        
    public void setLinha(String Linha) {
        this.Linha.set(Linha);
    }

    public SimpleStringProperty LatitudeProperty() {
        return Latitude;
    }
    
    public double getLatitude() {
        return Double.parseDouble(Latitude.get());
    }
        
    public void setLatitude(String Latitude) {
        this.Latitude.set(Latitude);
    }

    public SimpleStringProperty LongitudeProperty() {
        return Longitude;
    }
    
    public double getLongitude() {
        return Double.parseDouble(Longitude.get());
    }
    
    public void setLongitude(String Longitude) {
        this.Longitude.set(Longitude);
    }

    public SimpleStringProperty VelocidadeProperty() {
        return Velocidade;
    }
    
    public double getVelocidade() {
        return Double.parseDouble(Velocidade.get());
    }
        
    public void setVelocidade(String Velocidade) {
        this.Velocidade.set(Velocidade);
    }
}

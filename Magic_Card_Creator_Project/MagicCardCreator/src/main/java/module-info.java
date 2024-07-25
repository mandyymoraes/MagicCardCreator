module projetomagic.magiccardcreator {
    requires javafx.controls; //Adiciona os controls -> linkar um arquivo com uma função como controller de um fxml
    requires javafx.fxml; // importa o fxml em si 
    requires java.base;
    requires transitive java.desktop; //Adicionado pois para tirar print da tela era necessário a dependencia ImageIO e ela faz parte desse pacote
    requires transitive javafx.base; 
    requires transitive javafx.graphics;
    requires org.apache.poi.ooxml;   //Adicionado pois a criação de documentos word via requisição do apache está linkado nesse pacote
    requires java.net.http; //Adicionado para que seja possivel realizar a requisição HTTP que vai comunicar o LeonardoAI sobre qual carta é para ser gerada
    requires jakarta.json;
    

    opens projetomagic.magiccardcreator to javafx.fxml;
    exports projetomagic.magiccardcreator;
}

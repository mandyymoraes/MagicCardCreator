package projetomagic.magiccardcreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;



/**
 * JavaFX App
 */
public class App extends Application {
    
 
    private static Scene scene;
    private String tituloModal = "Magic The Gathering Card Creator";

    @Override
    public void start(Stage stage) throws IOException { // função que começa o projeto e abre os modais na tela
        scene = new Scene(loadFXML("HomeFX")); //coloca na tela o javaFX da página home
        stage.setTitle(tituloModal);//coloca o título na janela
        Image icon = new Image(getClass().getResourceAsStream("favicon.jpg")); //adiciona o favicon para a janela
        stage.getIcons().add(icon);
        stage.setY(5);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {// função responsavel por rodar os FXML que são passados para ele, faz uma junção de string (nomeArquivo.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}

package projetomagic.magiccardcreator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private Button escolherCriatura;
    @FXML
    private Button escolherCategoria;
    @FXML
    private TextField nomeCarta;
    @FXML
    private TextField autorCarta;
    @FXML
    private TextField manaBranca;
    @FXML
    private TextField manaVermelha;
    @FXML
    private TextField manaAzul;
    @FXML
    private TextField manaVerde;
    @FXML
    private TextField manaIncolor;
    @FXML
    private TextField danoAtaque;
    @FXML
    private TextArea descricaoCarta;
    @FXML
    private TextArea descricaoImagem;
    @FXML
    private TextField nomeCartaFinalizado;
    @FXML
    private TextArea descricaoCartaFinalizado;
    @FXML
    private TextField autorCartaFinalizado;
    @FXML
    private TextField ataqueDanoFinalizado;
    @FXML
    private TextField manaBrancaFinalizado;
    @FXML
    private TextField manaVermelhaFinalizado;
    @FXML
    private TextField manaVerdeFinalizado;
    @FXML
    private TextField manaAzulFinalizado;
    @FXML
    private TextField manaIncolorFinalizado;
    @FXML
    private Button printBtn;
    @FXML
    private ImageView imagemGerada;

    String danoAtaqueValue = "-/-";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void abrirModalCriatura() {
        try {
            FXMLLoader carregarPaginaCriatura = new FXMLLoader(getClass().getResource("CriaturaFX.fxml"));
            Parent pagina = carregarPaginaCriatura.load();
            Stage stage = (Stage) escolherCriatura.getScene().getWindow();
            stage.setScene(new Scene(pagina));
            danoAtaque = (TextField) pagina.lookup("#danoAtaque");
            if (danoAtaque != null) {
                danoAtaqueValue = danoAtaque.getText(); // ou qualquer valor inicial que vocÃª deseja
            }
            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }

    public void abrirModalCategoria() {
        try {
            FXMLLoader carregarPaginaCategoria = new FXMLLoader(getClass().getResource("SelecionarCategoria.fxml"));
            Parent pagina = carregarPaginaCategoria.load();
            Stage stage = (Stage) escolherCategoria.getScene().getWindow();
            stage.setScene(new Scene(pagina));
            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirModalInstantanea() {
        try {
            FXMLLoader carregarPaginaInstantanea = new FXMLLoader(getClass().getResource("InstantaneaFX.fxml"));
            Parent pagina = carregarPaginaInstantanea.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pagina));
            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }

    public void abrirModalFeitico() {
        try {
            FXMLLoader carregarPaginaFeitico = new FXMLLoader(getClass().getResource("FeiticoFX.fxml"));
            Parent pagina = carregarPaginaFeitico.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pagina));
            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }

    public void abrirModalArtefato() {
        try {
            FXMLLoader carregarPaginaArtefato = new FXMLLoader(getClass().getResource("ArtefatoFX.fxml"));
            Parent pagina = carregarPaginaArtefato.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pagina));
            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }

    String nomeCartaValue;
    String autorCartaValue;
    String manaBrancaValue;
    String manaVermelhaValue;
    String manaAzulValue;
    String manaVerdeValue;
    String manaIncolorValue;
    String descricaoImagemValue;
    String descricaoCartaValue;

    @FXML
    public void capturarDados() {
        nomeCartaValue = nomeCarta.getText();
        autorCartaValue = autorCarta.getText();
        manaBrancaValue = manaBranca.getText();
        manaVermelhaValue = manaVermelha.getText();
        manaAzulValue = manaAzul.getText();
        manaVerdeValue = manaVerde.getText();
        manaIncolorValue = manaIncolor.getText();
        descricaoImagemValue = descricaoImagem.getText();
        descricaoCartaValue = descricaoCarta.getText();

        DadosCarta carta = new DadosCarta(
                nomeCartaValue, autorCartaValue, descricaoImagemValue, descricaoCartaValue, manaBrancaValue, manaIncolorValue,
                manaVerdeValue, manaVermelhaValue, manaAzulValue, danoAtaqueValue);
        RepositorioCartasCriadas repositorio = new RepositorioCartasCriadas();
        repositorio.inserirCartaRepositorio(carta);
    }
    @FXML
    public void abrirModalArtefatoFinalizada() throws InterruptedException {
        try {
            FXMLLoader carregarPaginaArtefato = new FXMLLoader(getClass().getResource("CartaFinalizadaArtefatoMolde.fxml"));
            Parent pagina = carregarPaginaArtefato.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pagina));
            nomeCartaFinalizado = (TextField) pagina.lookup("#nomeCartaFinalizado");
            descricaoCartaFinalizado = (TextArea) pagina.lookup("#descricaoCartaFinalizado");
            autorCartaFinalizado = (TextField) pagina.lookup("#autorCartaFinalizado");
            ataqueDanoFinalizado = (TextField) pagina.lookup("#ataqueDanoFinalizado");
            manaBrancaFinalizado = (TextField) pagina.lookup("#manaBrancaFinalizado");
            manaVermelhaFinalizado = (TextField) pagina.lookup("#manaVermelhaFinalizado");
            manaAzulFinalizado = (TextField) pagina.lookup("#manaAzulFinalizado");
            manaVerdeFinalizado = (TextField) pagina.lookup("#manaVerdeFinalizado");
            manaIncolorFinalizado = (TextField) pagina.lookup("#manaIncolorFinalizado");
            imagemGerada = (ImageView) pagina.lookup("#imagemGerada");

            nomeCartaFinalizado.setText(nomeCartaValue);
            descricaoCartaFinalizado.setText(descricaoCartaValue);
            autorCartaFinalizado.setText(autorCartaValue);
            manaBrancaFinalizado.setText(manaBrancaValue);
            manaVermelhaFinalizado.setText(manaVermelhaValue);
            manaAzulFinalizado.setText(manaAzulValue);
            manaVerdeFinalizado.setText(manaVerdeValue);
            manaIncolorFinalizado.setText(manaIncolorValue);

            GerarImagem imagem = new GerarImagem();
            String url = imagem.gerarImagem(descricaoImagemValue);
            System.out.println(url);
            //String url = "https://cdn.leonardo.ai/users/84c83f5a-9ba2-4d9e-96e6-e21adb41ab92/generations/"+id+"/Default_SUN_0.jpg"; 
            Image image = new Image(url);
            imagemGerada.setImage(image);

            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }
    @FXML
    public void abrirModalFeiticoFinalizada() throws InterruptedException {
        try {
            FXMLLoader carregarPaginaArtefato = new FXMLLoader(getClass().getResource("CartaFinalizadaFeiticoMolde.fxml"));
            Parent pagina = carregarPaginaArtefato.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pagina));
            nomeCartaFinalizado = (TextField) pagina.lookup("#nomeCartaFinalizado");
            descricaoCartaFinalizado = (TextArea) pagina.lookup("#descricaoCartaFinalizado");
            autorCartaFinalizado = (TextField) pagina.lookup("#autorCartaFinalizado");
            ataqueDanoFinalizado = (TextField) pagina.lookup("#ataqueDanoFinalizado");
            manaBrancaFinalizado = (TextField) pagina.lookup("#manaBrancaFinalizado");
            manaVermelhaFinalizado = (TextField) pagina.lookup("#manaVermelhaFinalizado");
            manaAzulFinalizado = (TextField) pagina.lookup("#manaAzulFinalizado");
            manaVerdeFinalizado = (TextField) pagina.lookup("#manaVerdeFinalizado");
            manaIncolorFinalizado = (TextField) pagina.lookup("#manaIncolorFinalizado");
            imagemGerada = (ImageView) pagina.lookup("#imagemGerada");

            nomeCartaFinalizado.setText(nomeCartaValue);
            descricaoCartaFinalizado.setText(descricaoCartaValue);
            autorCartaFinalizado.setText(autorCartaValue);
            manaBrancaFinalizado.setText(manaBrancaValue);
            manaVermelhaFinalizado.setText(manaVermelhaValue);
            manaAzulFinalizado.setText(manaAzulValue);
            manaVerdeFinalizado.setText(manaVerdeValue);
            manaIncolorFinalizado.setText(manaIncolorValue);

            GerarImagem imagem = new GerarImagem();
            String url = imagem.gerarImagem(descricaoImagemValue);
            System.out.println(url);
            //String url = "https://cdn.leonardo.ai/users/84c83f5a-9ba2-4d9e-96e6-e21adb41ab92/generations/"+id+"/Default_SUN_0.jpg"; 
            Image image = new Image(url);
            imagemGerada.setImage(image);

            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }
    @FXML
    public void abrirModalInstantaneaFinalizada() throws InterruptedException{
        try {
            FXMLLoader carregarPaginaArtefato = new FXMLLoader(getClass().getResource("CartaFinalizadaInstantaneaMolde.fxml"));
            Parent pagina = carregarPaginaArtefato.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pagina));
            nomeCartaFinalizado = (TextField) pagina.lookup("#nomeCartaFinalizado");
            descricaoCartaFinalizado = (TextArea) pagina.lookup("#descricaoCartaFinalizado");
            autorCartaFinalizado = (TextField) pagina.lookup("#autorCartaFinalizado");
            ataqueDanoFinalizado = (TextField) pagina.lookup("#ataqueDanoFinalizado");
            manaBrancaFinalizado = (TextField) pagina.lookup("#manaBrancaFinalizado");
            manaVermelhaFinalizado = (TextField) pagina.lookup("#manaVermelhaFinalizado");
            manaAzulFinalizado = (TextField) pagina.lookup("#manaAzulFinalizado");
            manaVerdeFinalizado = (TextField) pagina.lookup("#manaVerdeFinalizado");
            manaIncolorFinalizado = (TextField) pagina.lookup("#manaIncolorFinalizado");
            imagemGerada = (ImageView) pagina.lookup("#imagemGerada");

            nomeCartaFinalizado.setText(nomeCartaValue);
            descricaoCartaFinalizado.setText(descricaoCartaValue);
            autorCartaFinalizado.setText(autorCartaValue);
            manaBrancaFinalizado.setText(manaBrancaValue);
            manaVermelhaFinalizado.setText(manaVermelhaValue);
            manaAzulFinalizado.setText(manaAzulValue);
            manaVerdeFinalizado.setText(manaVerdeValue);
            manaIncolorFinalizado.setText(manaIncolorValue);

            GerarImagem imagem = new GerarImagem();
            String url = imagem.gerarImagem(descricaoImagemValue);
            System.out.println(url);
            //String url = "https://cdn.leonardo.ai/users/84c83f5a-9ba2-4d9e-96e6-e21adb41ab92/generations/"+id+"/Default_SUN_0.jpg"; 
            Image image = new Image(url);
            imagemGerada.setImage(image);

            stage.show();
        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirModalCartaCriaturaFinalizada() throws InterruptedException {
        try {
            FXMLLoader carregarPaginaCriatura = new FXMLLoader(getClass().getResource("CartaFinalizadaCriaturaMolde.fxml"));
            Parent pagina = carregarPaginaCriatura.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pagina));
            nomeCartaFinalizado = (TextField) pagina.lookup("#nomeCartaFinalizado");
            descricaoCartaFinalizado = (TextArea) pagina.lookup("#descricaoCartaFinalizado");
            autorCartaFinalizado = (TextField) pagina.lookup("#autorCartaFinalizado");
            ataqueDanoFinalizado = (TextField) pagina.lookup("#ataqueDanoFinalizado");
            manaBrancaFinalizado = (TextField) pagina.lookup("#manaBrancaFinalizado");
            manaVermelhaFinalizado = (TextField) pagina.lookup("#manaVermelhaFinalizado");
            manaAzulFinalizado = (TextField) pagina.lookup("#manaAzulFinalizado");
            manaVerdeFinalizado = (TextField) pagina.lookup("#manaVerdeFinalizado");
            manaIncolorFinalizado = (TextField) pagina.lookup("#manaIncolorFinalizado");
            ataqueDanoFinalizado = (TextField) pagina.lookup("#ataqueDanoFinalizado");
            imagemGerada = (ImageView) pagina.lookup("#imagemGerada");

            nomeCartaFinalizado.setText(nomeCartaValue);
            descricaoCartaFinalizado.setText(descricaoCartaValue);
            autorCartaFinalizado.setText(autorCartaValue);
            manaBrancaFinalizado.setText(manaBrancaValue);
            manaVermelhaFinalizado.setText(manaVermelhaValue);
            manaAzulFinalizado.setText(manaAzulValue);
            manaVerdeFinalizado.setText(manaVerdeValue);
            manaIncolorFinalizado.setText(manaIncolorValue);
            ataqueDanoFinalizado.setText(danoAtaqueValue);

            GerarImagem imagem = new GerarImagem();
            String url = imagem.gerarImagem(descricaoImagemValue);
            System.out.println(url);
            //String url = "https://cdn.leonardo.ai/users/84c83f5a-9ba2-4d9e-96e6-e21adb41ab92/generations/"+id+"/Default_SUN_0.jpg"; 
            Image image = new Image(url);
            imagemGerada.setImage(image);

            stage.show();

        } catch (IOException e) {
            System.out.println("Algo deu errado!");
            e.printStackTrace();
        }

    }

    @FXML
    public void tirarPrint() {
        printBtn.setOnMouseClicked(event -> {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            TirarPrint print = new TirarPrint();
            CriarWordsCarta wordCarta = new CriarWordsCarta();

            try {
                WritableImage snapshot = print.captureStageScreenshot(stage);
                print.showScreenshotInNewStage(snapshot);
                print.saveAsJPEG(snapshot, "Carta");
                String imagePath = "src/main/resources/Carta.png";
                wordCarta.criarWord(imagePath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        );

    }

}

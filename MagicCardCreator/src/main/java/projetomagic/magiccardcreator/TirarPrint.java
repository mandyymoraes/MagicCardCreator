package projetomagic.magiccardcreator;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class TirarPrint {
    
    String tituloArquivoScreenshot = "PrintTelaCarta";
    double larguraImagem;
    double alturaImagem;
    
     public WritableImage captureStageScreenshot(Stage stage) {
        Scene scene = stage.getScene();
        larguraImagem = scene.getWidth();
        alturaImagem = scene.getHeight();
        WritableImage writableImage = new WritableImage((int) larguraImagem, (int) alturaImagem); // 
        scene.snapshot(writableImage);
        return writableImage;
    }

    // Função para exibir a imagem capturada em um novo Stage
    public void showScreenshotInNewStage(WritableImage image) {
        ImageView imageView = new ImageView(image);
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(imageView);

        Scene secondScene = new Scene(secondaryLayout, larguraImagem, alturaImagem);//

        // Novo Stage
        Stage newWindow = new Stage();
        newWindow.setTitle("Captured Screenshot");
        newWindow.setScene(secondScene);

        // Define a posição do novo Stage
        newWindow.setX(50);
        newWindow.setY(100);

        newWindow.show();
    }
    
    public static void saveAsJPEG(WritableImage image, String filename) { //TIVE QUE COPIAR DO GPT PORQUE DAVA PROBLEMA NA BIBLITOECA SWINGFXUTILS NÃO ACHAVA O PACTOE E NEM AS IMPORTAÇÕES. MEXI NO MODULE MAS NÃO ADIANTAVA, MUDOU DE LUGAR A EXTEN~SOA MAS MESMO MEXENDO NO POM NÇÃO ACHAVA E A PASTA NÃO EXISTIA
        // Cria o arquivo de saída
        String resourcesPath = "src/main/resources/";
        File outputFile = new File(resourcesPath + filename + ".png");

        // Cria um BufferedImage
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        BufferedImage bufferedImage = new java.awt.image.BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Preenche o BufferedImage com os pixels da WritableImage
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                bufferedImage.setRGB(x, y, image.getPixelReader().getArgb(x, y));
            }
        }

        // Salva como JPEG usando ImageIO
        try {
            ImageIO.write(bufferedImage, "png", outputFile);
            System.out.println("Imagem salva como " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar imagem: " + e.getMessage());
        }

    

    }
}
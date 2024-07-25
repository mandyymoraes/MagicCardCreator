/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetomagic.magiccardcreator;

import java.io.FileInputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.util.Units;

public class CriarWordsCarta {
    
    String nomeArquivo = "CartaGerada.docx";
    String textoInserirCarta = "Carta Gerada";
    
    public void criarWord(String imagePath) { //Funçao responsavel em criar o arquivo word para que a imagem possa ser inserida nele 
        // Criar um novo documento Word
        XWPFDocument document = new XWPFDocument();// cria o documento word
        XWPFParagraph paragraph = document.createParagraph();// cria uma linha de texto no arquivo
        XWPFRun run = paragraph.createRun();//coloca no arquivo
        run.setText(textoInserirCarta); // gera o texto
         
        try (InputStream is = new FileInputStream(imagePath)){// busca a imagem que foi gerada do print na pasta
            run.addBreak();// adiciona uma quebra de linha
            run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imagePath, Units.toEMU(200), Units.toEMU(200));// insere a imagem
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Salvar o documento
        try (FileOutputStream arquivoFinal = new FileOutputStream(nomeArquivo)) { //gera o arquivo com o nome passado de parametro, normalmente vai gerar ele na pasta raiz do projeto
            document.write(arquivoFinal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fechar o documento
        try {
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

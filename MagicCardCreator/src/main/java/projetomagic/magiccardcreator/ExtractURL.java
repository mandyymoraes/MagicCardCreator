package projetomagic.magiccardcreator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractURL {
    
    

    public static String getUrlFromJson(String jsonString) { //funçao responsavel por separar a URL da imagem do body do json que volta depois da requisição POST para que a imagem seja criada 
       // String regexFormula = "\"url\":\"([^\"]+)\""; //formula padrão regex para conseguir capturar do json o campo da URL
       int qualGrupoDoJsonPegar = 1; // precisamos apenas do primeio grupo de strings que ele encontrar e dar match, por a posição da url dentro do json está nas posições anteriores, então o primeiro campo que ele encontrar com o nome URL está com a url correta
       String erro = "Houve um erro na Classe ExtractURL"; // utilizei esse atributo para me guiar durante os troubleshoting porque como muitas classes estão integradas a outra e constantemente era necessário saber se a requisiçao estava sendo extraida corretamente
       // indicar se algo deu errado com uma string autoexplicativa poupa muito tempo 
       
        Pattern pattern = Pattern.compile("\"url\":\"([^\"]+)\""); //utiliza da dependencia regex pattern para encontrar o campo
        Matcher matcher = pattern.matcher(jsonString);
        if (matcher.find()) {
            return matcher.group(qualGrupoDoJsonPegar); // Retorna o resultado do match
        }
        else{
            System.out.println(erro);
        }
        return null;

    }
}

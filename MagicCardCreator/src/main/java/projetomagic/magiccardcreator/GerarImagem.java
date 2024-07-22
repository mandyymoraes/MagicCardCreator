/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetomagic.magiccardcreator;

/**
 *
 * @author amand
 */
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GerarImagem {
    
    String regexImageId = "\"generationId\":\"([^\"]+)\"";
    String apiKey = "add008ba-f6db-4472-a578-6d5426c61996";
   
    // FUNÇÃO DO REGEX PRA SEPARAR O ID DO OBJETO DE RETORNO QUE GEROU A IMAGEM
    private String extractImageId(String json) { //era static
        // Usando expressão regular para encontrar o valor do generationId
        Pattern pattern = Pattern.compile(regexImageId);
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return matcher.group(1); // Retorna o primeiro grupo capturado pela expressão regular
        }
        return null;

    }

    public String gerarImagem(String descricao) throws IOException, InterruptedException { //era static
        // Tratar a descrição: substituir espaços por underlines e cortar em 58 caracteres
        String descricao2 = descricao.replaceAll(" ", "_");
        descricao2 = descricao2.length() > 58 ? descricao2.substring(0, 58) : descricao2;

        // Construir JSON de forma segura
        String json = String.format(
                "{\"alchemy\":true,\"height\":768,\"modelId\":\"b24e16ff-06e3-43eb-8d33-4416c2d75876\",\"num_images\":1,\"presetStyle\":\"DYNAMIC\",\"prompt\":\"%s\",\"width\":1024}",
                descricao2
        );
        
        System.out.println(json);

        // ------------------------------ AQUI É PRA GERAR A IMAGEM
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://cloud.leonardo.ai/api/rest/v1/generations"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("authorization", "Bearer add008ba-f6db-4472-a578-6d5426c61996")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response body: " + response.body());

        String responseBody = response.body(); // EXTRAI O ID DO OBJETO QUE RETORNA
        String imageId = extractImageId(responseBody);

        if (imageId == null) {
            throw new IllegalStateException("Failed to extract generationId from response: " + responseBody);
        }

        // AQUI É PRA PEGAR A IMAGEM GERADA EM CIMA
        String imageUrl = null;
        int i = 0;
        while (imageUrl == null && i < 12) {  // Loop até obter a URL, até 1 minuto
            HttpRequest statusRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://cloud.leonardo.ai/api/rest/v1/generations/" + imageId))
                    .header("accept", "application/json")
                    .header("authorization", "Bearer "+apiKey)
                    .GET()
                    .build();

            HttpResponse<String> statusResponse = HttpClient.newHttpClient().send(statusRequest, HttpResponse.BodyHandlers.ofString());
            String statusJson = statusResponse.body();
            System.out.println("Status response: " + statusJson);

            // Chama a função para verificar o status e obter a URL
            imageUrl = ExtractURL.getUrlFromJson(statusJson);

            if (imageUrl == null) {
                System.out.println("Status ainda não está completo. Esperando...");
                Thread.sleep(5000);  // Aguarda 5 segundos antes de tentar novamente
            }
            i++;
        }

        System.out.println("Imagem disponível em: " + imageUrl);
        return imageUrl;

    }
        
    
}

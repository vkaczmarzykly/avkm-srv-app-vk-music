package br.com.vkly.alura.music.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPTService {

    public static String buscaInfoArtista(String artista) {
        OpenAiService service = new OpenAiService("sk-proj-jpSKXXvM6sv60VggfM5ll427kG2Z-Op6V0qSe220xZpJZb_" +
                "LsvhrEJBHTDD78McQZtcsbdMTdiT3BlbkFJ-ilt1ySEHbrBqP-ulihLJ-YmfD4GCSeQdLvKZehw4fQyRPZ200OpD9" +
                "ySnmKjGqXPO9X2GGsuwA");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traga as informações do artista: " + artista)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}

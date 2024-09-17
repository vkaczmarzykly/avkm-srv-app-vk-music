package br.com.vkly.alura.music.view;

import br.com.vkly.alura.music.controller.AppVkMusicController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FrontEnd implements CommandLineRunner {


    private final AppVkMusicController api = new AppVkMusicController();

    private final Scanner leitura = new Scanner(System.in);

    private Integer opcaoEscolhida = -1;

    public static void main(String[] args) {
        SpringApplication.run(FrontEnd.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        while (opcaoEscolhida != 0) {
            opcaoEscolhida = exibeMenuPrincipal();
            api.controller(opcaoEscolhida);
        }
    }
    public Integer exibeMenuPrincipal() {

        var menu = """
                *** AVKM - App VK Music ***
                
                1 - Cadastrar Artista
                2 - Cadastrar Músicas
                3 - Listar Músicas
                4 - Buscar Músicas Por Artistas
                5 - Pesquisar Dados Sobre um Artista
                
                0 - Sair
                
                """;

        System.out.println(menu);
        return leitura.nextInt();
    }
}
package br.com.vkly.alura.music.view;

import br.com.vkly.alura.music.controller.AppVkMusicController;
import br.com.vkly.alura.music.model.ComposicaoArtista;
import br.com.vkly.alura.music.model.Dados;
import br.com.vkly.alura.music.model.DadosArtista;
import br.com.vkly.alura.music.repository.ArtistaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FrontEnd {

    private Scanner leitura = new Scanner(System.in);

    private final DadosArtista dadosArtista = new DadosArtista();

    private Integer opcaoEscolhida = -1;

    private ArtistaRepository repository;

    public FrontEnd(ArtistaRepository repositorio) {
        this.repository = repositorio;
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontEnd.class, args);
    }

    public void inicio() {

        while (opcaoEscolhida != 0) {
            opcaoEscolhida = exibeMenuPrincipal();
            DadosArtista dados = (DadosArtista) verificaMenu(opcaoEscolhida);

            var apiAvkm = new AppVkMusicController(repository);
            apiAvkm.controller(opcaoEscolhida, dados);
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
    private Dados verificaMenu(Integer opcaoEscolhida) {
        switch (opcaoEscolhida) {
            case 1:
               return exibeMenuArtista();
        }
        return null;
    }

    private Dados exibeMenuArtista()  {

        System.out.println("Informe o nome do artista: ");
        leitura.nextLine();
        var nomeArtista = leitura.nextLine();

        System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
        var tipoArtista = leitura.nextLine();

        dadosArtista.setNomeArtista(nomeArtista);
        dadosArtista.setComposicaoArtista(ComposicaoArtista.valueOf(tipoArtista.toUpperCase()));

        return dadosArtista;
    }

    private void exibeMenuArtistaTipo() {
          leitura.nextLine();
          System.out.println("Informe o tipo desse artista: (solo, dupla, banda): ");
          var tipoArtista = leitura.nextLine();
        System.out.println(tipoArtista);
    }
}

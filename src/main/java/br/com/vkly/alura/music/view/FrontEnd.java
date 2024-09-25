package br.com.vkly.alura.music.view;

import br.com.vkly.alura.music.controller.AppVkMusicController;
import br.com.vkly.alura.music.model.*;
import br.com.vkly.alura.music.repository.ArtistaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FrontEnd {

    private Scanner leitura = new Scanner(System.in);

    private final DadosArtista dadosArtista = new DadosArtista();

    private Integer opcaoEscolhida = -1;

    private ArtistaRepository artistaRepository;

    public FrontEnd(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public static void main(java.lang.String[] args) {
        SpringApplication.run(FrontEnd.class, args);
    }

    public void inicio() {

        while (opcaoEscolhida != 0) {
            exibeMenuPrincipal();
        }
    }

    public void exibeMenuPrincipal() {

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

        try {
            opcaoEscolhida = leitura.nextInt();
            verificaMenu(opcaoEscolhida);
        } catch (InputMismatchException e) {
            System.out.println("Opção deve ser númerica!");
            opcaoEscolhida = 0;
        }
    }

    private  void verificaMenu(Integer opcaoEscolhida) {
        switch (opcaoEscolhida) {
            case 1:
               exibeMenuArtista();
               break;
            case 2:
               exibeMenuMusica();
               break;
            case 3:
               listaMusicas();
               break;
            case 4:
               buscaMusicasArtista();
               break;
            case 5:
               buscaInfoArtista();
               break;
            case 0:
               break;
            default:
                System.out.println("Opção Inválida");
        }
    }

    private void exibeMenuArtista()  {

        var cadastrarOutroArtista = "S";

        while(cadastrarOutroArtista.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do artista: ");
            leitura.nextLine();
            var nomeArtista = leitura.nextLine();

            System.out.println("Informe o tipo desse artista (solo, dupla, banda)");
            var tipoArtista = leitura.nextLine();

            dadosArtista.setNomeArtista(nomeArtista);
            dadosArtista.setComposicaoArtista(ComposicaoArtista.valueOf(tipoArtista.toUpperCase()));

            var apiAvkm = new AppVkMusicController(artistaRepository);
            apiAvkm.cadastraArtista(dadosArtista);

            System.out.println("Deseja cadastrar outro artista? (S/N)");
            cadastrarOutroArtista = leitura.next();
        }
    }
    private void exibeMenuMusica() {

        System.out.println("Informe o nome da musica: ");
        leitura.nextLine();
        var nomeMusica = leitura.nextLine();

        System.out.println("Informe o album da musica: ");
        var nomeAlbum = leitura.nextLine();

        System.out.println("A musica é de qual Artista? ");
        var artista = leitura.nextLine();

        var apiAvkm = new AppVkMusicController(artistaRepository);
        var artistaBuscado = apiAvkm.buscaArtista(artista);

        Musica musica = new Musica(nomeMusica, nomeAlbum);
        musica.setArtista(artistaBuscado.get());

        artistaBuscado.get().getMusicas().add(musica);

        apiAvkm.cadastraMusica(artistaBuscado.get());
    }

    private void listaMusicas() {
        var apiAvkm = new AppVkMusicController(artistaRepository);
        List<Artista> artistas = apiAvkm.buscaTodosArtistas();

        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void buscaMusicasArtista() {
        System.out.println("Informe o artista para visualizar as suas musicas: ");
        leitura.nextLine();
        var artista = leitura.nextLine();

        var apiAvkm = new AppVkMusicController(artistaRepository);
        var artistaBuscado = apiAvkm.buscaArtista(artista);

        artistaBuscado.get().getMusicas().forEach(System.out::println);
    }

    private void buscaInfoArtista() {
        System.out.println("Informe o artista para visualizar suas informações: ");
        leitura.nextLine();
        var artista = leitura.nextLine();

        var apiAvkm = new AppVkMusicController(artistaRepository);
        var infoArtista = apiAvkm.buscaInfoArtista(artista);

        System.out.println(infoArtista);

    }
}

package br.com.vkly.alura.music.controller;

import br.com.vkly.alura.music.model.DadosArtista;
import br.com.vkly.alura.music.repository.ArtistaRepository;
import br.com.vkly.alura.music.service.ArtistaService;

public class AppVkMusicController {

    private ArtistaRepository repository;

    public AppVkMusicController(ArtistaRepository repository) { this.repository = repository; }

    public void controller(Integer opcaoEscolhida, DadosArtista dadosArtista) {
        switch (opcaoEscolhida) {
            case 1:
                var artistaService = new ArtistaService(repository);
                artistaService.cadastraArtistaService(dadosArtista);
            case 2:
                break;
        }
    }
}

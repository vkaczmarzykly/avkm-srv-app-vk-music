package br.com.vkly.alura.music.controller;

import br.com.vkly.alura.music.model.Artista;
import br.com.vkly.alura.music.model.DadosArtista;
import br.com.vkly.alura.music.repository.ArtistaRepository;
import br.com.vkly.alura.music.service.ArtistaService;
import br.com.vkly.alura.music.service.MusicaService;

import java.util.Optional;

public class AppVkMusicController {

    private ArtistaRepository artistaRepository;

    private ArtistaService artistaService;
    private MusicaService musicaService;

    public AppVkMusicController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public void cadastraArtista(DadosArtista dadosArtista) {
        artistaService = new ArtistaService(artistaRepository);
        artistaService.cadastraArtistaService(dadosArtista);
    }

    public Optional<Artista> buscaArtista(String artista) {
        artistaService = new ArtistaService(artistaRepository);
        return  artistaService.buscaArtistaService(artista);
    }

    public void cadastraMusica(Artista artista) {
        musicaService = new MusicaService(artistaRepository);
        musicaService.cadastraMusicaService(artista);
    }
}


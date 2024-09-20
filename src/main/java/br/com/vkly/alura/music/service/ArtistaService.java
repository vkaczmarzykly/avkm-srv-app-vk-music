package br.com.vkly.alura.music.service;

import br.com.vkly.alura.music.model.Artista;
import br.com.vkly.alura.music.model.DadosArtista;
import br.com.vkly.alura.music.repository.ArtistaRepository;

public class ArtistaService {

    private ArtistaRepository repository;

    public ArtistaService(ArtistaRepository repository) { this.repository = repository; }

    public void cadastraArtistaService(DadosArtista dadosArtista) {
        var artista = new Artista(dadosArtista);
        this.repository.save(artista);

    }
}

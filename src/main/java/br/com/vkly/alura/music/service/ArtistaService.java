package br.com.vkly.alura.music.service;

import br.com.vkly.alura.music.model.Artista;
import br.com.vkly.alura.music.model.DadosArtista;
import br.com.vkly.alura.music.repository.ArtistaRepository;

import java.util.Optional;

public class ArtistaService {

    private ArtistaRepository repository;

    public ArtistaService(ArtistaRepository repository) { this.repository = repository; }

    public void cadastraArtistaService(DadosArtista dadosArtista) {
        var artista = new Artista(dadosArtista);
        repository.save(artista);
    }

    public Optional<Artista> buscaArtistaService(String nomeArtista) {
        return repository.findByNomeArtistaContainingIgnoreCase(nomeArtista);
    }
}

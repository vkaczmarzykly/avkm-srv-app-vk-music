package br.com.vkly.alura.music.service;

import br.com.vkly.alura.music.model.Artista;
import br.com.vkly.alura.music.model.Musica;
import br.com.vkly.alura.music.repository.ArtistaRepository;

import java.util.List;

public class MusicaService {

    private ArtistaRepository repository;

    public MusicaService(ArtistaRepository repository) {
        this.repository = repository;
    }

    public void cadastraMusicaService(Artista artista) {
        repository.save(artista);
    }

}
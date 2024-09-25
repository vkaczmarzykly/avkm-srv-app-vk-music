package br.com.vkly.alura.music.repository;

import br.com.vkly.alura.music.model.Artista;
import br.com.vkly.alura.music.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeArtistaContainingIgnoreCase(String nomeArtista);

}

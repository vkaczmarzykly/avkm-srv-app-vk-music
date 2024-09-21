package br.com.vkly.alura.music.repository;

import br.com.vkly.alura.music.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeArtistaContainingIgnoreCase(String nomeArtista);

}

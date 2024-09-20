package br.com.vkly.alura.music.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avkm_artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeArtista;

    @Enumerated(EnumType.STRING)
    private ComposicaoArtista composicaoArtista;

    public Artista(DadosArtista dadosArtista) {
        this.nomeArtista = dadosArtista.getNomeArtista();
        this.composicaoArtista = dadosArtista.getComposicaoArtista();
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public ComposicaoArtista getComposicaoArtista() {
        return composicaoArtista;
    }

    public void setComposicaoArtista(ComposicaoArtista composicaoArtista) {
        this.composicaoArtista = composicaoArtista;
    }
}

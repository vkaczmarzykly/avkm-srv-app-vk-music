package br.com.vkly.alura.music.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avkm_artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeArtista;

    @Enumerated(EnumType.STRING)
    private ComposicaoArtista composicaoArtista;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public Artista() {}
    public Artista(DadosArtista dadosArtista) {
        this.nomeArtista = dadosArtista.getNomeArtista();
        this.composicaoArtista = dadosArtista.getComposicaoArtista();
    }

    public Long getId() {
        return id;
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

//    @Override
//    public String toString() {
//        return "Artista{" +
//                "nomeArtista='" + nomeArtista + '\'' +
//                ", composicaoArtista=" + composicaoArtista +
//                ", musicas=" + musicas +
//                '}';
//    }
}

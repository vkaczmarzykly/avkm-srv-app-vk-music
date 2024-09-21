package br.com.vkly.alura.music.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avkm_musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMusica;

    private String album;

    public Musica() {}
    public Musica(String nomeMusica, String album) {
        this.nomeMusica = nomeMusica;
        this.album = album;
    }

    @ManyToOne
    private Artista artista;

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}

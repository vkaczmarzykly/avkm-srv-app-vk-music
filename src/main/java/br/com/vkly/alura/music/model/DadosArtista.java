package br.com.vkly.alura.music.model;

public class DadosArtista extends Dados {

    private String nomeArtista;

    private ComposicaoArtista composicaoArtista;

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

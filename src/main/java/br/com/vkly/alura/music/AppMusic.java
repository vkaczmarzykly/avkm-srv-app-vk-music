package br.com.vkly.alura.music;

import br.com.vkly.alura.music.repository.ArtistaRepository;
import br.com.vkly.alura.music.view.FrontEnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMusic implements CommandLineRunner {

    @Autowired
    private ArtistaRepository artistaRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppMusic.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FrontEnd frontEnd = new FrontEnd(artistaRepository);
        frontEnd.inicio();
    }
}
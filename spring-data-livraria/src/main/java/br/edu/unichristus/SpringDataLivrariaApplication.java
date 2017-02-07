package br.edu.unichristus;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.Livro;
import br.edu.unichristus.LivroService;

@SpringBootApplication
public class SpringDataLivrariaApplication implements CommandLineRunner {
	
	@Autowired
	private LivroService servico;
	
	@Override
	public void run(String... args) {
		Livro livro = new Livro("Java Como Programar", new Date(), 250, new BigDecimal("15.00"));
		this.servico.save(livro);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplication.class, args);
	}
}

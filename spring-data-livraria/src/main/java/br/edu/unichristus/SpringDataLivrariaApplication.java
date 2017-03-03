package br.edu.unichristus;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class SpringDataLivrariaApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;
	
	@Autowired
	private AutorService servicoAutores;

	@Override
	public void run(String... args) throws ParseException {

		Editora editora = servicoEditoras.buscarPeloNome("Campus");
		List<Livro> livrosCampus = servicoLivros.buscarPelaEditora(editora);
		
		for (Livro livro : livrosCampus) {
			System.out.println(livro.toString());
		}
		
		List<Livro> livrosInglaterra = servicoLivros.buscarPeloAutorPais("Inglaterra");
		
		livrosInglaterra.forEach(l -> System.out.println(l) );
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplication.class, args);
	}
}

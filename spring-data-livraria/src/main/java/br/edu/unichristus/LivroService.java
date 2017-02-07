package br.edu.unichristus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;

	public void save(Livro livro) {
		this.repo.save(livro);
	}
}


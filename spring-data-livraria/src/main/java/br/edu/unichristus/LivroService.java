package br.edu.unichristus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;

	/* MÉTODOS CRUD */

	public void salvar(Livro livro) {
		this.repo.save(livro);
	}

	public Livro buscarPeloID(Long idLivro) {
		return this.repo.findOne(idLivro);
	}

	public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
		return this.repo.findAll(idsLivros);
	}

	public void remover(Long idLivro) {
		this.repo.delete(idLivro);
	}

	public void remover(Livro livro) {
		this.repo.delete(livro);
	}

	/* MÉTODOS DE PESQUISA COM STRINGS */

	public Livro buscarPeloTitulo(String titulo) {
		return this.repo.findByTitulo(titulo);
	}

	public List<Livro> buscarPeloTituloLike(String titulo) {
		return this.repo.findByTituloLike(titulo);
	}

	public List<Livro> buscarPeloTituloContendo(String titulo) {
		return this.repo.findByTituloContaining(titulo);
	}

	public List<Livro> buscarPeloTituloComecandoCom(String titulo) {
		return this.repo.findByTituloStartingWith(titulo);
	}

	public List<Livro> buscarPeloTituloTerminandoCom(String titulo) {
		return this.repo.findByTituloEndingWith(titulo);
	}

	public List<Livro> buscarPeloTituloIgnorandoCaixa(String titulo) {
		return this.repo.findByTituloIgnoreCase(titulo);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES RELACIONAIS */
	public List<Livro> buscarPeloNumeroDePaginas(int numeroPaginas) {
		return this.repo.findByNumeroPaginasEquals(numeroPaginas);
	}

	public List<Livro> buscarPeloNumeroDePaginasMaiorQue(int numeroPaginas) {
		return this.repo.findByNumeroPaginasGreaterThan(numeroPaginas);
	}

	public List<Livro> buscarPeloNumeroDePaginasIntervalo(int min, int max) {
		return this.repo.findByNumeroPaginasBetween(min, max);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES LÓGICOS */
	public List<Livro> buscarPeloTituloContendo1ou2(String titulo1, String titulo2) {
		return this.repo.findByTituloContainingOrTituloContaining(titulo1, titulo2);
	}

	public List<Livro> buscarPeloTituloDiferenteDe(String titulo) {
		return this.repo.findByTituloNot(titulo);
	}

	public List<Livro> buscarPeloTituloContendoENumeroDePaginasMaiorQue(String titulo, int numeroPaginas) {
		return this.repo.findByTituloContainingAndNumeroPaginasGreaterThan(titulo, numeroPaginas);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES DE DATA */
	public List<Livro> buscarPelaDataPublicacaoDepoisDe(Date dataPublicacao) {
		return this.repo.findByDataPublicacaoAfter(dataPublicacao);
	}

	public List<Livro> buscarPelaDataPublicacaoAntesDe(Date dataPublicacao) {
		return this.repo.findByDataPublicacaoBefore(dataPublicacao);
	}

	public List<Livro> buscarPelaDataPublicacaoEntre(Date dataPublicacao1, Date dataPublicacao2) {
		return this.repo.findByDataPublicacaoBetween(dataPublicacao1, dataPublicacao2);
	}

	/* MÉTODOS DE ORDENAÇÃO */
	public List<Livro> buscarPeloTituloContendoOrdemCrescente(String titulo) {
		return this.repo.findByTituloContainingOrderByTituloAsc(titulo);
	}

	public List<Livro> buscarPeloTituloContendoOrdemDecrescente(String titulo) {
		return this.repo.findByTituloContainingOrderByTituloDesc(titulo);
	}
}

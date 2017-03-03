package br.edu.unichristus;

import java.time.LocalDate;
import java.util.ArrayList;
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
		System.out.println("LIVRO " + livro.getLivroID() + " SALVO!");
	}

	public Livro buscarPeloID(Long idLivro) {
		System.out.println("OBTENDO O LIVRO COM O ID = " + idLivro);
		return this.repo.findOne(idLivro);
	}

	public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
		System.out.println("OBTENDO OS LIVROS COM OS IDS " + idsLivros.toString());
		return this.repo.findAll(idsLivros);
	}

	public void remover(Long idLivro) {
		this.repo.delete(idLivro);
		System.out.println("REMOVIDO O LIVRO COM ID = " + idLivro);
	}

	public void remover(Livro livro) {
		this.repo.delete(livro);
		System.out.println("REMOVIDO O LIVRO COM ID = " + livro.getLivroID());
	}

	/* MÉTODOS DE PESQUISA COM STRINGS */

	public Livro buscarPeloTitulo(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO " + titulo);
		return this.repo.findByTitulo(titulo);
	}

	public List<Livro> buscarPeloTituloLike(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO LIKE " + titulo);
		return this.repo.findByTituloLike(titulo);
	}

	public List<Livro> buscarPeloTituloContendo(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO CONTENDO " + titulo);
		return this.repo.findByTituloContaining(titulo);
	}

	public List<Livro> buscarPeloTituloComecandoCom(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO COMEÇANDO COM " + titulo);
		return this.repo.findByTituloStartingWith(titulo);
	}

	public List<Livro> buscarPeloTituloTerminandoCom(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO TERMINANDO EM " + titulo);
		return this.repo.findByTituloEndingWith(titulo);
	}

	public List<Livro> buscarPeloTituloIgnorandoCaixa(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO " + titulo + " IGNORANDO A CAPITALIZAÇÃO");
		return this.repo.findByTituloIgnoreCase(titulo);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES RELACIONAIS */
	public List<Livro> buscarPeloNumeroDePaginas(int numeroPaginas) {
		System.out.println("BUSCANDO OS LIVROS COM O NÚMERO DE PÁGINAS IGUAL A  " + numeroPaginas);
		return this.repo.findByNumeroPaginasEquals(numeroPaginas);
	}

	public List<Livro> buscarPeloNumeroDePaginasMaiorQue(int numeroPaginas) {
		System.out.println("BUSCANDO OS LIVROS COM O NÚMERO DE PÁGINAS MAIOR QUE  " + numeroPaginas);
	return this.repo.findByNumeroPaginasGreaterThan(numeroPaginas);
	}

	public List<Livro> buscarPeloNumeroDePaginasIntervalo(int min, int max) {
		System.out.println("BUSCANDO OS LIVROS COM O NÚMERO DE PÁGINAS ENTRE  " + min + " E " + max);
		return this.repo.findByNumeroPaginasBetween(min, max);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES LÓGICOS */
	public List<Livro> buscarPeloTituloContendo1ou2(String titulo1, String titulo2) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO CONTENDO " + titulo1 + " OU " + titulo2);
		return this.repo.findByTituloContainingOrTituloContaining(titulo1, titulo2);
	}

	public List<Livro> buscarPeloTituloDiferenteDe(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO DIFERENTE DE " + titulo);
		return this.repo.findByTituloNot(titulo);
	}

	public List<Livro> buscarPeloTituloContendoENumeroDePaginasMaiorQue(String titulo, int numeroPaginas) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO IGUAL A " + titulo + " E NÚMERO DE PÁGINAS MAIOR QUE " + numeroPaginas);
		return this.repo.findByTituloContainingAndNumeroPaginasGreaterThan(titulo, numeroPaginas);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES DE DATA */
	public List<Livro> buscarPelaDataPublicacaoDepoisDe(LocalDate dataPublicacao) {
		System.out.println("BUSCANDO OS LIVROS COM DATA DE PUBLICAÇÃO DEPOIS DE " + dataPublicacao);
		return this.repo.findByDataPublicacaoAfter(dataPublicacao);
	}

	public List<Livro> buscarPelaDataPublicacaoAntesDe(LocalDate dataPublicacao) {
		System.out.println("BUSCANDO OS LIVROS COM DATA DE PUBLICAÇÃO ANTES DE " + dataPublicacao);
		return this.repo.findByDataPublicacaoBefore(dataPublicacao);
	}

	public List<Livro> buscarPelaDataPublicacaoEntre(LocalDate dataPublicacao1, LocalDate dataPublicacao2) {
		System.out.println("BUSCANDO OS LIVROS COM DATA DE PUBLICAÇÃO ENTRE " + dataPublicacao1 + " E " + dataPublicacao2);
		return this.repo.findByDataPublicacaoBetween(dataPublicacao1, dataPublicacao2);
	}

	/* MÉTODOS DE ORDENAÇÃO */
	public List<Livro> buscarPeloTituloContendoOrdemCrescente(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM TÍTULO CONTENDO " + titulo + " EM ORDEM CRESCENTE");
		return this.repo.findByTituloContainingOrderByTituloAsc(titulo);
	}

	public List<Livro> buscarPeloTituloContendoOrdemDecrescente(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM TÍTULO CONTENDO " + titulo + " EM ORDEM DECRESCENTE");
		return this.repo.findByTituloContainingOrderByTituloDesc(titulo);
	}
	
	public List<Livro> buscarPelaEditora(Editora editora){
		System.out.println("BUSCANDO OS LIVROS DA EDITORA " + editora.getNome());
		return this.repo.findByEditora(editora);
	}
	
	public List<Livro> buscarPeloAutorPais(String pais) {
		System.out.println("BUSCANDO OS LIVROS DOS AUTORES DO PAIS " + pais);
		return this.repo.findByAutoresPais(pais);
	}
}

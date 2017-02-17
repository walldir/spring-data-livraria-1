package br.edu.unichristus;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public Editora buscarPeloNome(String nome) {
		System.out.println("BUSCANDO EDITORA COM O NOME " + nome);
		return this.repo.findByNome(nome);
	}
	
	public List<Editora> buscarPorAnoEntre(int anoInicial, int anoFinal){
		System.out.println("OBTENDO EDITORAS ENTRE " + anoInicial + " e " + anoFinal);
		return this.repo.findByAnoFundacaoBetween(anoInicial, anoFinal);
	}
	
	public List<Editora> buscarPorCidade(String cidade){
		System.out.println("OBTENDO EDITORAS DE " + cidade);
		return this.repo.findByCidade(cidade);
	}
	
	public List<Editora> buscarPorNomeIniciandoCom(String inicioNome, String inicioNome2){
		System.out.println("BUSCANDO EDITORAS COM O NOME INICIANDO COM " + inicioNome + " OU " + inicioNome2);
		return this.repo.findByNomeStartingWithOrNomeStartingWith(inicioNome, inicioNome2);
	}
	
	public List<Editora> buscarPorCidadeEAnoFundacaoMaiorQue(String cidade, int ano){
		System.out.println("BUSCANDO EDITORAS FUNDADAS EM " + cidade + " NO ANO DE " + ano);
		return this.repo.findByCidadeAndAnoFundacaoAfter(cidade, ano);
	}
	
	public void salvar(Editora e) {
		this.repo.save(e);
	}
	
	public void remover(Editora e) {
		this.repo.delete(e);
		System.out.println("REMOVIDO A EDITORA " + e.getNome());
	}
}

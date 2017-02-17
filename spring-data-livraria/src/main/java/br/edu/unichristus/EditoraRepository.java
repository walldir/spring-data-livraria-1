package br.edu.unichristus;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
	public Editora findByNome(String nome);
	
	public Editora findByNomeLike(String nome);
	
	public List<Editora> findByAnoFundacaoBetween(int anoInicial, int anoFinal);
	
	public List<Editora> findByCidade(String cidade);
	
	public List<Editora> findByNomeStartingWithOrNomeStartingWith(String inicio, String inicio2);
	
	public List<Editora> findByCidadeAndAnoFundacaoAfter(String cidade, int anoApos);
}

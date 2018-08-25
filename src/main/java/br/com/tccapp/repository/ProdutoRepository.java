package br.com.tccapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tccapp.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByCodigoProduto(long codigoProduto);
	
}

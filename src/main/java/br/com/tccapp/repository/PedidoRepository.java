package br.com.tccapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tccapp.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>  {
	
}

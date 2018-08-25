package br.com.tccapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tccapp.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente findByEmail (String email);
	
	Cliente findByCpf(long cpf);
	
}

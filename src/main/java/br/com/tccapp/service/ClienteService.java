package br.com.tccapp.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tccapp.model.Cliente;
import br.com.tccapp.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository ;
	
	 @Autowired
	 private  EntityManager manager;
	
	
	
	public Cliente buscarCliente(String email) {
		
		String hql = "from Cliente c where c.email = :email";	
		Cliente cli= new Cliente();

		try {
			cli = (Cliente) manager.createQuery(hql)
							.setParameter("email", email).getSingleResult();
		}catch (NoResultException e) {
			cli = null;
		} 
			
		return cli;
	}
	
	
	public Cliente buscarClienteCpf(Cliente cli) {	
		return repository.findByCpf(cli.getCpf()) ;
	}
	
	public void salvar(Cliente cliente) {
		repository.save(cliente);
	}
}

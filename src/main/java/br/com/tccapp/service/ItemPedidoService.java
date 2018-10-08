package br.com.tccapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tccapp.model.Itenspedido;
import br.com.tccapp.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository repository;
	
	@Autowired
	 private  EntityManager manager;
	
	
	public void excluirItemPedido(long codigoPedido) {
		
		List<Itenspedido> itensPedido = new ArrayList<>();
		
		String hql = "from Itenspedido p where p.pedido.codigoPedido = :idPedido";
		
		itensPedido = manager.createQuery(hql)
				.setParameter("idPedido", codigoPedido).getResultList();
		
		
		for (Itenspedido item : itensPedido) {
			repository.deleteById(item.getId_itenspedido());
		}
		
	}
	
}

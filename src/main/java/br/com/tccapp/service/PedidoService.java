package br.com.tccapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tccapp.model.Pedido;
import br.com.tccapp.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repoPedido;
	
	@Autowired
	private  EntityManager manager;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	 
	 public boolean excluirPedido(long cpfCliente) {
		 boolean retorno = true;
		 
		 try {
			 
			 List<Pedido> pedidos = new ArrayList<>();
			 String hqlPedido = "from Pedido p where p.cliente.cpf = :cpf";	
			 
			 pedidos =  manager.createQuery(hqlPedido)
						.setParameter("cpf", cpfCliente).getResultList();
			 
			 for(Pedido itemPedido : pedidos) {
				 itemPedidoService.excluirItemPedido(itemPedido.getCodigoPedido());
				 repoPedido.deleteById(itemPedido.getCodigoPedido());
			 }
			 
		 }catch (Exception e) {
			 retorno = false;
			 System.out.println(e.getMessage());
		}
		 
		 
		 return retorno;
	 }
	 
}

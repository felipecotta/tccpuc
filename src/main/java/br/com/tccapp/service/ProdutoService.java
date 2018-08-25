package br.com.tccapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tccapp.model.Produto;
import br.com.tccapp.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	 @Autowired
	 private  EntityManager manager;
	 
	 
	 public void salvar(Produto produto) {
		 repository.save(produto);
	 }
	 
	@SuppressWarnings("unchecked")
	public List<Produto>listarProdutos(){
		 
		 List<Produto> produtos = new ArrayList<>(); 
		
	   try {
			produtos = (List<Produto>) manager.createNamedQuery("Produto.findAll");
		}catch (NoResultException e) {
			produtos = null;
		}
		 
		 return produtos;
	 }
	 
}

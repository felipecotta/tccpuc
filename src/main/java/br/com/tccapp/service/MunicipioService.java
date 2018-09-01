package br.com.tccapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tccapp.model.Municipio;
import br.com.tccapp.repository.MunicipioRepository;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository repository;
	
	 @Autowired
	 private  EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<String> listarPorUf(String estado){
		
		List<Municipio>listaMunicipio = new ArrayList<>();
		List<String>  resultado = new ArrayList<>();
		
		
		String hql = "from Municipio m where m.uf = :uf";	
				
		Query query = manager.createQuery(hql)
								.setParameter("uf", estado) ;
		
		listaMunicipio.addAll(query.getResultList());
		
		
		for(Municipio item : listaMunicipio) {
			resultado.add(item.getMunicipio());
		}
		
		
		
		return resultado;
	}
}

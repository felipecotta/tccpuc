package br.com.tccapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tccapp.service.MunicipioService;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

	@Autowired
	private MunicipioService service;
	
	@ResponseStatus(HttpStatus.OK) 
	@RequestMapping(method = RequestMethod.GET, value = "listar",  
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> listar(@RequestParam("uf")String uf){
		return service.listarPorUf(uf);
	}
	
}

package br.com.tccapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tccapp.model.Cliente;
import br.com.tccapp.service.ClienteService;
import br.com.tccapp.util.PerfilEnum;
import br.com.tccapp.util.Resposta;
import br.com.tccapp.util.TipoErroEnum;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "verificarEmail")// consumes= {"text/plain", "application/*"} )
	public Cliente verificarEmail(@RequestParam("email") String email , Model model) {		
	   Cliente cli;
		cli = service.buscarCliente(email);
		return cli;
	}
	
	@ResponseStatus(HttpStatus.OK) 
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value="verificarCpf")
	public Cliente verificarCpf(@RequestBody Cliente cliente) {
		 return service.buscarClienteCpf(cliente);
	}
	
	@ResponseStatus(HttpStatus.OK)//@ResponseBody
	@RequestMapping(value = "salvar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
	public Resposta salvar(@RequestBody Cliente cliente , Model model) {
		
		Resposta resp = new Resposta();
		
		try {
			Cliente cli = cliente;
			cli.setPerfil(PerfilEnum.USUARIO.getPerfil());
			
//	********************		Validações  *********************************************************
			if(cli.getCpf() == 0L ) 
				resp.getMsgErro().add("CPF deve ser preenchido");
			
			if(cli.getEmail()== null || cli.getEmail().trim().equals("")) 
				resp.getMsgErro().add("O email deve ser preenchido");
			
			if(cli.getNomeCliente() == null || cli.getNomeCliente().trim().equals(""))
				resp.getMsgErro().add("O nome do cliente deve ser preenchido");
			
			if(cli.getSenha() == null || cli.getSenha().trim().equals(""))
				resp.getMsgErro().add("O campo Senha deve ser preenchido");
//***************************************************************************************************			
			if (resp.getMsgErro().isEmpty()) {
				service.salvar(cli);	
			}else {
				resp.setResultadoOperacao(TipoErroEnum.ALERTA.getTipoErro());
			}
			
		} catch (Exception e) {
			resp.setResultadoOperacao(TipoErroEnum.ERRO.getTipoErro());
			resp.getMsgErro().add(e.getMessage());
		}
		
		
		return resp;
	}
	
}

package br.com.tccapp.controller;

import java.util.HashMap;

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
import br.com.tccapp.util.UtilitarioSenha;

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
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value="verificarEmailJ")
	public Cliente verificaEmailJ(@RequestBody Cliente cliente) {
		 Cliente cli;
		 cli = service.buscarCliente(cliente.getEmail());
		 return cli;
	}
	
	
	@ResponseStatus(HttpStatus.OK) 
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value="verificarCpf")
	public Cliente verificarCpf(@RequestBody Cliente cliente) {
		 return service.buscarClienteCpf(cliente);
	}
	
	@ResponseStatus(HttpStatus.OK)//@ResponseBody
	@RequestMapping(value = "salvar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
	public HashMap<String, Object>  salvar(@RequestBody Cliente cliente , Model model) {
		
		HashMap<String, Object> retorno = new HashMap<>();
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
				
				String password=cli.getSenha();
				cli.setSenha(UtilitarioSenha.generateHash(password));
				
				service.salvar(cli);	
			}else {
				resp.setResultadoOperacao(TipoErroEnum.ALERTA.getTipoErro());
			}
			
		} catch (Exception e) {
			resp.setResultadoOperacao(TipoErroEnum.ERRO.getTipoErro());
			resp.getMsgErro().add(e.getMessage());
		}
		
		retorno.put("resultado", resp);
		
		return retorno;
	}
	
	
	@ResponseStatus(HttpStatus.OK)//@ResponseBody
	@RequestMapping(value = "validaCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
	public HashMap<String, Object>  validaCliente(@RequestBody Cliente cliente) {
		Cliente cliBanco = new Cliente();
		Resposta resp = new Resposta();
		HashMap<String, Object> retorno = new HashMap<>();
		
		
		if(cliente.getCpf() != 0L )
			cliBanco = service.buscarClienteCpf(cliente);
		else
			cliBanco = service.buscarCliente(cliente.getEmail());	
		
		if (cliBanco != null) {
			
			boolean retIgual = UtilitarioSenha.isPasswordValid(cliBanco.getSenha(), cliente.getSenha());
			
			if(retIgual) {
				cliBanco.setSenha("#");
				retorno.put("resultado", resp);
				retorno.put("cliente", cliBanco);
			}else {
				resp.getMsgErro().add("Usuário ou Senha incorretos");
				resp.setResultadoOperacao(TipoErroEnum.ALERTA.getTipoErro());
				
				retorno.put("resultado",resp);
				retorno.put("cliente",new Cliente());
			}
		}else {
			resp.getMsgErro().add("Usuário não Cadastrado no Sistema");
			resp.setResultadoOperacao(TipoErroEnum.ALERTA.getTipoErro());
			
			retorno.put("resultado",resp);
			retorno.put("cliente",new Cliente());
		}
		
		return retorno;
	}
	
	
}

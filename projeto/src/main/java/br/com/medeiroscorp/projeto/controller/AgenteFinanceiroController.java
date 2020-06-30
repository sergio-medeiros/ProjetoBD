package br.com.medeiroscorp.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.medeiroscorp.projeto.dao.AgenteFinanceiroDAO;
import br.com.medeiroscorp.projeto.model.AgenteFinanceiro;



@RestController
@CrossOrigin("*")
public class AgenteFinanceiroController {
	@Autowired
	private AgenteFinanceiroDAO dao;
	
	@GetMapping("/AgentesFinanceiros")
	public ArrayList<AgenteFinanceiro> recuperarToTen(){
		ArrayList<AgenteFinanceiro> lista;
		lista = (ArrayList<AgenteFinanceiro>)dao.findAllByOrderByVolumeDesc();
		return lista;
	}
	
}

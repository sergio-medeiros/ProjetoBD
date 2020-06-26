package br.com.medeiroscorp.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medeiroscorp.projeto.dao.UsuarioDAO;
import br.com.medeiroscorp.projeto.model.Usuario;

@RestController
public class UsuarioController {

	@Autowired // injeção da dependência
	private UsuarioDAO dao;

	@GetMapping("/usuarios")
	public ArrayList<Usuario> listarTudo() {
		ArrayList<Usuario> lista = (ArrayList<Usuario>) dao.findAll();
		return lista;
	}
	/*@PostMapping("/login")
	public Usuario login(@RequestBody Usuario userEmailSenha) {
		Usuario user = dao.findByEmailAndSenha(userEmailSenha.getEmail(), userEmailSenha.getSenha());
		return user;
	}
	*/
	/*@PostMapping("/login")
	public Usuario login(@RequestBody Usuario incompleto) {
		if(incompleto.getEmail() != null) {
			Usuario resultado = dao.findByEmailAndSenha(incompleto.getEmail(),incompleto.getSenha());
			return resultado;
		}
		else {
			Usuario resultado = dao.findByRacfAndSenha(incompleto.getRacf(),incompleto.getSenha());
			return resultado;
		}
	}*/
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario incompleto){
		
		Usuario resultado = dao.findByRacfOrEmail(incompleto.getRacf(), incompleto.getEmail());
		if (resultado != null) {
			if (incompleto.getSenha().equals(resultado.getSenha())) {
				resultado.setSenha("******");
				return ResponseEntity.ok(resultado);
			}
			else {
				return ResponseEntity.status(403).build();
			}
		}
		else {
			return ResponseEntity.notFound().build();
		}
			
	}
}
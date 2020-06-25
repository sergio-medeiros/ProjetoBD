package br.com.medeiroscorp.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.medeiroscorp.hello.model.Produto;

@RestController
public class HelloControler {
	@GetMapping("/hello")
	public String digaOla() {
		return "Ola Mundo!!! Bem vindos ao primeiro exemplo SprinBoot!";
	}

	@GetMapping("/produto")
	public Produto mostraProduto() {
		Produto p = new Produto();
		p.setId(9876);
		p.setDescricao("Computador Core i5 16Gb Ram 1Tb HD placa GTX 1080");
		p.setPreco(3500.0f);
		p.setEstoque(8);
		return p;
	}
}

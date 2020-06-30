package br.com.medeiroscorp.projeto.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.medeiroscorp.projeto.model.AgenteFinanceiro;

public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer>{
	
	public List<AgenteFinanceiro> findAllByOrderByVolumeDesc();

}

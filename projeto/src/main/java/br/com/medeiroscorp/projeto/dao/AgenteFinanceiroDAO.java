package br.com.medeiroscorp.projeto.dao;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.medeiroscorp.projeto.model.AgenteFinanceiro;
import org.springframework.data.repository.query.Param;


public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer>{
	
	public List<AgenteFinanceiro> findAllByOrderByVolumeDesc();

}
package com.rhadamez.mezicashapi.repository.lancamento;

import java.util.List;

import com.rhadamez.mezicashapi.model.Lancamento;
import com.rhadamez.mezicashapi.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
	
}

package com.rhadamez.mezicashapi.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rhadamez.mezicashapi.model.Lancamento;
import com.rhadamez.mezicashapi.repository.filter.LancamentoFilter;
import com.rhadamez.mezicashapi.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}

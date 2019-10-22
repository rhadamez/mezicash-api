package com.rhadamez.mezicashapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rhadamez.mezicashapi.model.Lancamento;
import com.rhadamez.mezicashapi.model.Pessoa;
import com.rhadamez.mezicashapi.repository.LancamentoRepository;
import com.rhadamez.mezicashapi.repository.PessoaRepository;
import com.rhadamez.mezicashapi.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}

	public Optional<Lancamento> buscar(Long id) {
		Optional<Lancamento> lancamento = lancamentoRepository.findById(id);

		if (lancamento.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}

		return lancamento;
	}

	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getId());
		
		if(pessoa.isEmpty() || pessoa.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}

	public void deletar(Long id) {
		lancamentoRepository.deleteById(id);
	}

}

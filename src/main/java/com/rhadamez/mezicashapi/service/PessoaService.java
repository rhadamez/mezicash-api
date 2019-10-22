package com.rhadamez.mezicashapi.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhadamez.mezicashapi.model.Pessoa;
import com.rhadamez.mezicashapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public Optional<Pessoa> buscar(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		if(pessoa.isEmpty()) {
			return null;
		}
		
		return pessoa;
	}

	public Pessoa salvar(@Valid Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}

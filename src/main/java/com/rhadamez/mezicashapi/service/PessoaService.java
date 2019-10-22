package com.rhadamez.mezicashapi.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

		if (pessoa.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}

		return pessoa;
	}

	public Pessoa salvar(@Valid Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Optional<Pessoa> pessoaAntiga = buscar(id);

		BeanUtils.copyProperties(pessoa, pessoaAntiga.get(), "id");
		return pessoaRepository.save(pessoaAntiga.get());
	}

	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}

	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Optional<Pessoa> pessoaAntiga = buscar(id);
		pessoaAntiga.get().setAtivo(ativo);
		pessoaRepository.save(pessoaAntiga.get());
	}

}

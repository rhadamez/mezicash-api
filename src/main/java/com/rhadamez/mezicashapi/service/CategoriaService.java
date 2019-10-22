package com.rhadamez.mezicashapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhadamez.mezicashapi.model.Categoria;
import com.rhadamez.mezicashapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriasRepository;

	public List<Categoria> listar() {
		return categoriasRepository.findAll();
	}

	public Optional<Categoria> buscar(Long id) {
		Optional<Categoria> categoria = categoriasRepository.findById(id);

		if (categoria.isPresent()) {
			return categoria;
		}

		return null;
	}

	public Categoria salvar(Categoria categoria) {
		Categoria categoriaSalva = categoriasRepository.save(categoria);

		return categoriaSalva;
	}

}

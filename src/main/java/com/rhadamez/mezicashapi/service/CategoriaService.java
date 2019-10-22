package com.rhadamez.mezicashapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhadamez.mezicashapi.model.Categoria;
import com.rhadamez.mezicashapi.repository.Categorias;

@Service
public class CategoriaService {

	@Autowired
	private Categorias categorias;

	public List<Categoria> listar() {
		return categorias.findAll();
	}

	public Optional<Categoria> buscar(Long id) {
		Optional<Categoria> categoria = categorias.findById(id);

		if (categoria.isPresent()) {
			return categoria;
		}

		return null;
	}

	public Categoria salvar(Categoria categoria) {
		Categoria categoriaSalva = categorias.save(categoria);

		return categoriaSalva;
	}

}

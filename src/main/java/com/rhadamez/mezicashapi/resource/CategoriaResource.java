package com.rhadamez.mezicashapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhadamez.mezicashapi.model.Categoria;
import com.rhadamez.mezicashapi.repository.Categorias;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@Autowired
	private Categorias categorias;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> lista = categorias.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria){
		Categoria categoriaSalva = categorias.save(categoria);
		
		return ResponseEntity.ok(categoriaSalva);
		
	}

}

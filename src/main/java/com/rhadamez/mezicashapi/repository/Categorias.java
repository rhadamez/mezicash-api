package com.rhadamez.mezicashapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rhadamez.mezicashapi.model.Categoria;

@Repository
public interface Categorias extends JpaRepository<Categoria, Long> {

}

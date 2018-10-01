package org.radix.rotas.repository;

import java.io.Serializable;

import org.radix.rotas.model.Grafo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GrafoRepository extends JpaRepository<Grafo, Serializable>{

}

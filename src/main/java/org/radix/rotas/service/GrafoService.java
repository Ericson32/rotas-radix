package org.radix.rotas.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.radix.rotas.model.Grafo;
import org.radix.rotas.model.Rota;
import org.radix.rotas.repository.GrafoRepository;
import org.radix.rotas.vo.RotasDisponiveis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrafoService {
	
	@Autowired
	GrafoRepository repository;	
	
	public Grafo salvarGrafo(Grafo grafo) {
		return repository.save(grafo);
	}
	
	public Grafo recuperarGrafo(BigDecimal grafoId) {
		return repository.findById(grafoId).get();
	}
	
	public List<RotasDisponiveis> recuperarRotasDisponiveis(List<Rota> rotas, char source, char target, int maxStops){
		
		List<RotasDisponiveis> rotasDisponiveis = new ArrayList<>();
		
		for(Rota rota : rotas){
			
			if(source == rota.getSource()){
				
			}
			
			
		}
		
		return null;
		
	}

}

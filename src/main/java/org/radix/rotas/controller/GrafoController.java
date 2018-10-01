package org.radix.rotas.controller;

import java.math.BigDecimal;
import java.util.List;

import org.radix.rotas.model.Grafo;
import org.radix.rotas.service.GrafoService;
import org.radix.rotas.vo.RotasDisponiveis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GrafoController {
    @Autowired
	GrafoService grafoService;
	
	@PostMapping(produces="application/json")
	@RequestMapping("/graph")
	public @ResponseBody ResponseEntity<Grafo> salvarGrafo(@RequestBody Grafo grafo) {
		return new ResponseEntity<Grafo>(grafoService.salvarGrafo(grafo), HttpStatus.CREATED);
	}
	
	@GetMapping(produces="application/json")
	@RequestMapping(value = "/graph/{graphId}")
	public @ResponseBody ResponseEntity<Grafo> getGrafo(@PathVariable("graphId") String grafoId) {
		
		if(grafoId == null ||grafoId.trim().equals("")) {
			return new ResponseEntity<Grafo>(new Grafo(),HttpStatus.NOT_FOUND);
		}
		
		BigDecimal id = new BigDecimal(grafoId);
		Grafo grafo = null;
				
		try {
			grafo = grafoService.recuperarGrafo(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(grafo == null) {
			return new ResponseEntity<Grafo>(grafo, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Grafo>(grafo, HttpStatus.OK);
		}
	}
	
	@GetMapping(produces="application/json")
	@RequestMapping(value = "/routes/from/{source}/to/{target}?maxStops={maxStops}")
	public @ResponseBody ResponseEntity<List<RotasDisponiveis>> getRotasDisponiveis(@RequestBody Grafo grafo, @PathVariable("source") char source, @PathVariable("target") char target, @PathVariable("maxStops") int maxStops) {
		return new ResponseEntity<List<RotasDisponiveis>>(grafoService.recuperarRotasDisponiveis(grafo.getRotas(), source, target, maxStops), HttpStatus.OK);
		
		
	}

}

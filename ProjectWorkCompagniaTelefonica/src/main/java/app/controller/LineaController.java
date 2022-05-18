package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.db.LineaRepository;
import app.model.Linea;

@RestController
public class LineaController {
	
	@Autowired
	private LineaRepository lr;
	
	@GetMapping("/listaLinee")
	public List<Linea> listaLinee() {
		return (List<Linea>) lr.findAll();
	}
	
	@PostMapping("/inserisciLinea")
	public Linea inserisciLinea(@RequestBody Linea linea) {
		return lr.save(linea);
	}
	
	@PutMapping("/modificaLinea/{idLinea}")
	public Linea modificaLinea(@RequestBody Linea nuovaLinea, @PathVariable Integer idLinea) {
		return lr.findByIdLinea(idLinea).map(linea -> {
			linea.setNumero(nuovaLinea.getNumero());
			linea.setTipo(nuovaLinea.getTipo());
			linea.setStato(nuovaLinea.getStato());
			linea.setCliente(nuovaLinea.getCliente());
			return lr.save(linea);
		})
		.orElseGet(() -> {
			nuovaLinea.setIdLinea(idLinea);
			return lr.save(nuovaLinea);
		});
	}
	
	@PutMapping("/modificaStatoLinea/{idLinea}")
	public Linea modificaStatoLinea(@RequestBody Linea nuovaLinea, @PathVariable Integer idLinea) {
		return lr.findByIdLinea(idLinea).map(linea -> {
			linea.setStato(nuovaLinea.getStato());
			return lr.save(linea);
		})
		.orElseGet(() -> {
			nuovaLinea.setIdLinea(idLinea);
			return lr.save(nuovaLinea);
		});
	}

	@DeleteMapping("/eliminaLinea/{idLinea}")
	public void eliminaLinea(@PathVariable Integer idLinea) {
		lr.deleteByIdLinea(idLinea);
	}
	
}

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

import app.db.ClienteRepository;
import app.model.Cliente;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;
	
	@GetMapping("/listaClienti")
	public List<Cliente> listaClienti() {
		return (List<Cliente>) cr.findAll();
	}
	
	@PostMapping("/inserisciCliente")
	public Cliente inserisciCliente(@RequestBody Cliente cliente) {
		return cr.save(cliente);
	}
	
	@PutMapping("/modificaCliente/{idCliente}")
	public Cliente modificaCliente(@RequestBody Cliente nuovoCliente, @PathVariable Integer idCliente) {
		return cr.findByIdCliente(idCliente).map(cliente -> {
			cliente.setNome(nuovoCliente.getNome());
			cliente.setCodiceFiscale(nuovoCliente.getCodiceFiscale());
			cliente.setEmail(nuovoCliente.getEmail());
			return cr.save(cliente);
		})
		.orElseGet(() -> {
			nuovoCliente.setIdCliente(idCliente);
			return cr.save(nuovoCliente);
		});
	}

	@DeleteMapping("/eliminaCliente/{idCliente}")
	public void eliminaCliente(@PathVariable Integer idCliente) {
		cr.deleteByIdCliente(idCliente);
	}
}

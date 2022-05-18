package app.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.db.ChiamataRepository;
import app.model.Chiamata;

@RestController
public class ChiamataController {
	
	@Autowired
	private ChiamataRepository cr;
	
	@GetMapping("/listaChiamate")
	public List<Chiamata> listaChiamate() {
		return (List<Chiamata>) cr.findAll();
	}
	
	@GetMapping("/listaChiamateNumero/{numero}")
	public List<Chiamata> listaChiamateNumero(@PathVariable String numero) {
		return cr.findByLineaNumero(numero);
	}
	
	@GetMapping("/listaChiamateDataInizio/{dataInizio}")
	public List<Chiamata> listaChiamateDataInizio(@PathVariable Timestamp dataInizio) {
		return cr.findByDataInizio(dataInizio);
	}
	
	@GetMapping("/listaChiamateDataFine/{dataFine}")
	public List<Chiamata> listaChiamateDataFine(@PathVariable Timestamp dataFine) {
		return cr.findByDataFine(dataFine);
	}
	
	@GetMapping("/listaChiamateDurata/{durata}")
	public List<Chiamata> listaChiamateDurata(@PathVariable Long durata) {
		return cr.findByDurata(durata);
	}
	
	@GetMapping("/sumDurataChiamateNumeroData/{numero}/{dataInizio}/{dataFine}")
	public Optional<Chiamata> sumDurataChiamateNumeroData(@PathVariable String numero, @PathVariable Timestamp dataInizio, @PathVariable Timestamp dataFine) {
		return cr.findSumDurataByNumeroAndData(numero, dataInizio, dataFine);
	}
	
	@PostMapping("/inserisciChiamata")
	public Chiamata inserisciChiamata(@RequestBody Chiamata chiamata) {
		chiamata.setDurata();
		return cr.save(chiamata);
	}
	
	@PutMapping("/modificaChiamata/{idChiamata}")
	public Chiamata modificaChiamata(@RequestBody Chiamata nuovaChiamata, @PathVariable Long idChiamata) {
		return cr.findByIdChiamata(idChiamata).map(chiamata -> {
			chiamata.setDataInizio(nuovaChiamata.getDataInizio());
			chiamata.setDataFine(nuovaChiamata.getDataFine());
			chiamata.setDurata();
			chiamata.setLinea(nuovaChiamata.getLinea());
			return cr.save(chiamata);
		})
		.orElseGet(() -> {
			nuovaChiamata.setIdChiamata(idChiamata);
			return cr.save(nuovaChiamata);
		});
	}

	@DeleteMapping("/eliminaChiamata/{idChiamata}")
	public void eliminaChiamata(@PathVariable Long idChiamata) {
		cr.deleteByIdChiamata(idChiamata);
	}
}

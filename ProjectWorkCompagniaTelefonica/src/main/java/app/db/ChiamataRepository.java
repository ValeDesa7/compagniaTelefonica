package app.db;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Chiamata;

@Repository
public interface ChiamataRepository extends CrudRepository<Chiamata, String> {
	
	Optional<Chiamata> findByIdChiamata(Long idChiamata);
	
	List<Chiamata> findByLineaNumero(String numero);
	
	List<Chiamata> findByDataInizio(Timestamp dataInizio);
	
	List<Chiamata> findByDataFine(Timestamp dataFine);
	
	List<Chiamata> findByDurata(Long durata);
	
	@Query("select sum(c.durata) from Chiamata c inner join c.linea l where l.numero=?1 and c.dataInizio between ?2 and ?3")
	Optional<Chiamata> findSumDurataByNumeroAndData(String numero, Timestamp dataInizio, Timestamp dataFine);
	
	@Modifying @Transactional
	void deleteByIdChiamata(Long idChiamata);

}

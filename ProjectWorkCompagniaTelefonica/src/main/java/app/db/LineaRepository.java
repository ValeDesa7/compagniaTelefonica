package app.db;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Linea;

@Repository
public interface LineaRepository extends CrudRepository<Linea, String> {

	Optional<Linea> findByIdLinea(Integer idLinea);
	
	Optional<Linea> findByNumero(String numero);
	
	@Modifying @Transactional
	void deleteByIdLinea(Integer idLinea);

}

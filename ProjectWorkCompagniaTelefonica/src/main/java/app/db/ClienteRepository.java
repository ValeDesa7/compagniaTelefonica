package app.db;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {

	Optional<Cliente> findByIdCliente(Integer idCliente);
	
	@Modifying @Transactional
	void deleteByIdCliente(Integer idCliente);

}

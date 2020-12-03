package app.meuplano.mpadmin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.meuplano.mpadmin.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

  Optional<Pessoa> findByDocumento1(String doc);
}

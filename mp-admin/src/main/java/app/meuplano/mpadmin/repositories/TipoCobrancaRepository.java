package app.meuplano.mpadmin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.meuplano.mpadmin.entities.TipoCobranca;

@Repository
public interface TipoCobrancaRepository extends JpaRepository<TipoCobranca, Long> {

  Optional<TipoCobranca> findByDescricao(String descricao);
}

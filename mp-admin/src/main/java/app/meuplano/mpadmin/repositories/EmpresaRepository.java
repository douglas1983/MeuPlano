package app.meuplano.mpadmin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.meuplano.mpadmin.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

  Optional<Empresa> findByPessoa_Documento1(String doc);
}

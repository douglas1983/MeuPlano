package app.meuplano.mpadmin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.meuplano.mpadmin.entities.TipoCobranca;
import app.meuplano.mpadmin.repositories.TipoCobrancaRepository;

@Service
public class TipoCobrancaService {

  @Autowired
  private TipoCobrancaRepository repository;

  public Optional<TipoCobranca> findById(Long id) {
    return repository.findById(id);
  }

  public Page<TipoCobranca> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public TipoCobranca save(TipoCobranca tipoCobranca) {

    return repository.save(tipoCobranca);
  }

  // public TipoCobranca saveDTO(TipoCobrancaUpdateDTO TipoCobranca) {
  // TipoCobranca TipoCobrancaSave = mapper.map(TipoCobranca);
  // return repository.save(TipoCobrancaSave);
  // }

  public void deleleById(Long id) {
    repository.deleteById(id);
  }

}
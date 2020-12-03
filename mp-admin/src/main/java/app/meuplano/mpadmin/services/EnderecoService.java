package app.meuplano.mpadmin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.meuplano.mpadmin.entities.Endereco;
import app.meuplano.mpadmin.repositories.EnderecoRepository;

@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository repository;

  public Optional<Endereco> findById(Long id) {
    return repository.findById(id);
  }

  public Page<Endereco> findAll(Pageable page) {
    return repository.findAll(page);
  }

  public Endereco save(Endereco endereco) {

    return repository.save(endereco);
  }

  // public Endereco saveDTO(EnderecoUpdateDTO Endereco) {
  // Endereco EnderecoSave = mapper.map(Endereco);
  // return repository.save(EnderecoSave);
  // }

  public void deleleById(Long id) {
    repository.deleteById(id);
  }

}
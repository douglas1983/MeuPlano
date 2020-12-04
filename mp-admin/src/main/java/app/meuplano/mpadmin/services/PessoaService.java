package app.meuplano.mpadmin.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.meuplano.mpadmin.entities.Endereco;
import app.meuplano.mpadmin.entities.Pessoa;
import app.meuplano.mpadmin.repositories.EnderecoRepository;
import app.meuplano.mpadmin.repositories.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository repository;

  @Autowired
  private EnderecoRepository enderecoRepository;

  public Optional<Pessoa> findById(Long id) {
    return repository.findById(id);
  }

  public Page<Pessoa> findAll(Pageable page) {

    return repository.findAll(page);
  }

  public Pessoa save(Pessoa pessoa) {
    Set<Endereco> enderecos = new HashSet<>();
    for (Endereco end : pessoa.getEnderecos()) {
      enderecos.add(end);
    }
    pessoa.getEnderecos().clear();
    Pessoa saved = repository.save(pessoa);
    enderecos.stream().forEach(endereco -> {
      endereco.setPessoa(saved);
      enderecoRepository.save(endereco);
    });
    return saved;
  }

  // public Pessoa saveDTO(PessoaUpdateDTO Pessoa) {
  // Pessoa PessoaSave = mapper.map(Pessoa);
  // return repository.save(PessoaSave);
  // }

  public void deleleById(Long id) {
    repository.deleteById(id);
  }

}
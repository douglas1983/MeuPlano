package app.meuplano.mpadmin.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.meuplano.mpadmin.entities.Endereco;
import app.meuplano.mpadmin.entities.Pessoa;
import app.meuplano.mpadmin.entities.Empresa;

import app.meuplano.mpadmin.repositories.PessoaRepository;
import app.meuplano.mpadmin.repositories.EmpresaRepository;

@Service
public class EmpresaService {

  @Autowired
  private EmpresaRepository repository;

  @Autowired
  private PessoaService pessoaService;

  public Optional<Empresa> findById(Long id) {
    return repository.findById(id);
  }

  public Page<Empresa> findAll(Pageable page) {

    return repository.findAll(page);
  }

  public Empresa save(Empresa empresa) {
    if ((empresa.getPessoa().getId() == null) || (empresa.getPessoa().getId().equals(0L))) {
      Pessoa pessoa = new Pessoa();
      pessoa.setDataUpdate(empresa.getPessoa());
      Set<Endereco> enderecos = new HashSet<>();
      for (Endereco end : empresa.getPessoa().getEnderecos()) {
        enderecos.add(end);
      }
      pessoa.setEnderecos(enderecos);
      empresa.setPessoa(pessoaService.save(pessoa));
    }
    return repository.save(empresa);

  }

  // public Empresa saveDTO(EmpresaUpdateDTO Empresa) {
  // Empresa EmpresaSave = mapper.map(Empresa);
  // return repository.save(EmpresaSave);
  // }

  public void deleleById(Long id) {
    repository.deleteById(id);
  }

  public Empresa update(long id, Empresa empresa) {
    Empresa empresaUpdate = repository.findById(id).orElse(null);
    if (empresaUpdate != null) {
      empresaUpdate.setDataUpdate(empresa);
      return repository.save(empresaUpdate);
    }
    return null;

  }

}
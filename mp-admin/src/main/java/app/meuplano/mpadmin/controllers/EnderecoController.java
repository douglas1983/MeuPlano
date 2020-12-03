package app.meuplano.mpadmin.controllers;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.meuplano.mpadmin.entities.Endereco;
import app.meuplano.mpadmin.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/endereco")
@Tag(name = "Endereço", description = "EndPoints para o Endereço")
public class EnderecoController {

  @Autowired
  private EnderecoService service;

  @Operation(summary = "Busca um Endereço por ID", description = "Busca um Endereço por ID", tags = { "Endereço" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @GetMapping(path = { "/{id}" })

  public Endereco findById(@PathVariable Long id) {
    return service.findById(id).orElse(null);
  }

  @Operation(summary = "Busca todos os endereços", description = "Busca todos os endereços", tags = { "Endereço" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @GetMapping()
  @PageableAsQueryParam
  public Page<Endereco> findAll(@Parameter(hidden = true) @PageableDefault(size = 10) Pageable pageable) {
    return service.findAll(pageable);
  }

  @Operation(summary = "Adiciona um endereço", description = "Adiciona um endereço", tags = { "Endereço" })
  @ApiResponse(description = "Successful Operation", responseCode = "201", content = @Content(mediaType = "application/json"))

  @PostMapping(consumes = { "application/json" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(endereco));
  }

  @Operation(summary = "Altera um endereço por ID", description = "Altera um Endereço por ID", tags = { "Endereços" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @PutMapping(value = "/{id}", consumes = { "application/json" })
  public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Endereco endereco) {
    return service.findById(id).map(record -> {
      record.setDataUpdate(endereco);
      Endereco updated = service.save(record);
      return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  @Operation(summary = "Excluí um Endereço por ID", description = "Excluí um Endereço por ID", tags = { "Endereços" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @DeleteMapping(path = { "/{id}" })
  public ResponseEntity<?> delete(@PathVariable long id) {
    return service.findById(id).map(record -> {
      service.deleleById(id);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }
}
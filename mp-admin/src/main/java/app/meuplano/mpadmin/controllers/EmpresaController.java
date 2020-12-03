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

import app.meuplano.mpadmin.entities.Empresa;
import app.meuplano.mpadmin.services.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/empresa")
@Tag(name = "Empresa", description = "EndPoints para o Empresa")
public class EmpresaController {

  @Autowired
  private EmpresaService service;

  @Operation(summary = "Buscar uma Empresa por ID", description = "Buscar uma Empresa por ID", tags = { "Empresa" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @GetMapping(path = { "/{id}" })

  public Empresa findById(@PathVariable Long id) {
    return service.findById(id).orElse(null);
  }

  @Operation(summary = "Buscar todos as empresas", description = "Buscar todos as empresas", tags = { "Empresa" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @GetMapping()
  @PageableAsQueryParam
  public Page<Empresa> findAll(@Parameter(hidden = true) @PageableDefault(size = 10) Pageable pageable) {
    return service.findAll(pageable);
  }

  @Operation(summary = "Adiciona um empresa", description = "Adiciona um empresa", tags = { "Empresa" })
  @ApiResponse(description = "Successful Operation", responseCode = "201", content = @Content(mediaType = "application/json"))

  @PostMapping(consumes = { "application/json" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresa));
  }

  @Operation(summary = "Altera um empresa por ID", description = "Altera um Empresa por ID", tags = { "Empresas" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @PutMapping(value = "/{id}", consumes = { "application/json" })
  public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Empresa empresa) {
    return service.findById(id).map(record -> {
      record.setDataUpdate(empresa);
      Empresa updated = service.save(record);
      return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  @Operation(summary = "Excluí um Empresa por ID", description = "Excluí um Empresa por ID", tags = { "Empresas" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @DeleteMapping(path = { "/{id}" })
  public ResponseEntity<?> delete(@PathVariable long id) {
    return service.findById(id).map(record -> {
      service.deleleById(id);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }
}
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

import app.meuplano.mpadmin.entities.TipoCobranca;
import app.meuplano.mpadmin.services.TipoCobrancaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/tipocobranca")
@Tag(name = "Tipo Cobrança", description = "EndPoints para o Tipo de Cobrança")
public class TipoCobrancaController {

  @Autowired
  private TipoCobrancaService service;

  @Operation(summary = "Busca um Tipo de Cobrança por ID", description = "Busca um Tipo de Cobranca por ID", tags = {
      "Tipo de Cobrança" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @GetMapping(path = { "/{id}" })

  public TipoCobranca findById(@PathVariable Long id) {
    return service.findById(id).orElse(null);
  }

  @Operation(summary = "Busca todos os tipos de cobranças", description = "Busca todos os tipos de cobranças", tags = {
      "Tipo de Cobrança" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @GetMapping()
  @PageableAsQueryParam
  public Page<TipoCobranca> findAll(@Parameter(hidden = true) @PageableDefault(size = 10) Pageable pageable) {
    return service.findAll(pageable);
  }

  @Operation(summary = "Adiciona um tipo de cobrança", description = "Adiciona um tipo de cobrança", tags = {
      "Tipo Cobrança" })
  @ApiResponse(description = "Successful Operation", responseCode = "201", content = @Content(mediaType = "application/json"))

  @PostMapping(consumes = { "application/json" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<TipoCobranca> create(@RequestBody TipoCobranca tipo) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tipo));
  }

  @Operation(summary = "Altera um tipo de cobrança por ID", description = "Altera um Tipo de Cobrança por ID", tags = {
      "Tipo de Cobranças" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @PutMapping(value = "/{id}", consumes = { "application/json" })
  public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody TipoCobranca tipo) {
    return service.findById(id).map(record -> {
      record.setDataUpdate(tipo);
      TipoCobranca updated = service.save(record);
      return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  @Operation(summary = "Excluí um Tipo de Cobrança por ID", description = "Excluí um Tipo de Cobrança por ID", tags = {
      "Tipo de Cobranças" })
  @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))
  @DeleteMapping(path = { "/{id}" })
  public ResponseEntity<?> delete(@PathVariable long id) {
    return service.findById(id).map(record -> {
      service.deleleById(id);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }
}
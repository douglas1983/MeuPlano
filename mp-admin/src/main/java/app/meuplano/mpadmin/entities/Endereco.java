package app.meuplano.mpadmin.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Strings;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Hidden
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "mp_enderecos")
public class Endereco extends AuditModel<String> {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String cep;

  @NotBlank
  private String lagradouro;

  private String complemento;

  @NotBlank
  private String bairro;
  @NotBlank
  private String cidade;
  @NotBlank
  private String uf;

  private Long lat;

  private Long lon;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "pessoa_id")
  @JsonIgnore()
  private Pessoa pessoa;

  public void setDataUpdate(Endereco endereco) {
    if (!Strings.isNullOrEmpty(endereco.getCep())) {
      setCep(endereco.getCep());
    }

    if (!Strings.isNullOrEmpty(endereco.getLagradouro())) {
      setLagradouro(endereco.getLagradouro());
    }

    if (!Strings.isNullOrEmpty(endereco.getComplemento())) {
      setComplemento(endereco.getComplemento());
    }
    if (!Strings.isNullOrEmpty(endereco.getBairro())) {
      setBairro(endereco.getBairro());
    }
    if (!Strings.isNullOrEmpty(endereco.getCidade())) {
      setCidade(endereco.getCidade());
    }

    if (!Strings.isNullOrEmpty(endereco.getUf())) {
      setUf(endereco.getUf());
    }

    if (endereco.getLat() != null) {
      setLat(endereco.getLat());
    }

    if (endereco.getLon() != null) {
      setLon(endereco.getLon());
    }

  }

}

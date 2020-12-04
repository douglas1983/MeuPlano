package app.meuplano.mpadmin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Table(name = "mp_tipo_cobrancas")
public class TipoCobranca extends AuditModel<String> {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @Size(max = 100)
  @NotBlank
  private String descricao;

  public void setDataUpdate(TipoCobranca tipo) {
    if (!Strings.isNullOrEmpty(tipo.getDescricao())) {
      setDescricao(tipo.getDescricao());
    }
  }

}

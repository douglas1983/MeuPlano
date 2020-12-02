package app.meuplano.mpadmin.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import app.meuplano.mpadmin.enums.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "mp_pessoas")
public class Pessoa extends AuditModel<String> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // Razao social ou Nome
  @NotBlank
  private String nome;

  // Nome Fantasia ou Nome Social
  private String nickName;

  private TipoPessoa tipoPessoa;

  @NotBlank
  private String documento1;

  private String documento2;

  private String documento3;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "pessoa_id")
  private Set<Endereco> enderecos;
}

package app.meuplano.mpadmin.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.google.common.base.Strings;

import app.meuplano.mpadmin.dtos.PessoaDTO;
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
  @Column(unique = true, nullable = false)
  private String documento1;

  private String documento2;

  private String documento3;

  @OneToMany()
  @JoinColumn(name = "pessoa_id")
  private Set<Endereco> enderecos;

  public void fromDTO(PessoaDTO pessoa) {
    if (!Strings.isNullOrEmpty(pessoa.getNome())) {
      setNome(pessoa.getNome());
    }
    if (!Strings.isNullOrEmpty(pessoa.getNickName())) {
      setNickName(pessoa.getNickName());
    }
    if (!Strings.isNullOrEmpty(pessoa.getDocumento1())) {
      setDocumento1(pessoa.getDocumento1());
    }
    if (!Strings.isNullOrEmpty(pessoa.getDocumento2())) {
      setDocumento2(pessoa.getDocumento2());
    }
    if (!Strings.isNullOrEmpty(pessoa.getDocumento3())) {
      setDocumento3(pessoa.getDocumento3());
    }
    if (pessoa.getTipoPessoa() != null) {
      setTipoPessoa(pessoa.getTipoPessoa());
    }
  }

  public void setDataUpdate(Pessoa pessoa) {
    if (!Strings.isNullOrEmpty(pessoa.getNome())) {
      setNome(pessoa.getNome());
    }

    if (!Strings.isNullOrEmpty(pessoa.getNickName())) {
      setNickName(pessoa.getNickName());
    }

    if (!Strings.isNullOrEmpty(pessoa.getDocumento1())) {
      setDocumento1(pessoa.getDocumento1());
    }
    if (!Strings.isNullOrEmpty(pessoa.getDocumento2())) {
      setDocumento2(pessoa.getDocumento2());
    }
    if (!Strings.isNullOrEmpty(pessoa.getDocumento3())) {
      setDocumento3(pessoa.getDocumento3());
    }

    if (pessoa.getTipoPessoa() != null) {
      setTipoPessoa(pessoa.getTipoPessoa());
    }

  }
}

package app.meuplano.mpadmin.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "mp_empresas")
public class Empresa extends AuditModel<String> {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tipo_cobranca_id", nullable = false)
  private TipoCobranca tipoCobranca;

  @OneToOne(cascade = CascadeType.ALL)
  private Pessoa pessoa;

  private String url;

  public void setDataUpdate(Empresa empresa) {

    if (empresa.getTipoCobranca() != null) {
      setTipoCobranca(empresa.getTipoCobranca());
    }
    if (empresa.getPessoa() != null) {
      if ((empresa.getPessoa().getEnderecos() != null) && (empresa.getPessoa().getEnderecos().size() > 0)) {
        Pessoa pessoa = getPessoa();
        for (Endereco end : empresa.getPessoa().getEnderecos()) {
          end.setPessoa(pessoa);
        }
      } else {
        empresa.getPessoa().setEnderecos(pessoa.getEnderecos());
      }
      setPessoa(empresa.getPessoa());
    }
    if (!Strings.isNullOrEmpty(empresa.getUrl())) {
      setUrl(empresa.getUrl());
    }
  }
}

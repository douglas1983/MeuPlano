package app.meuplano.mpadmin.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;

import app.meuplano.mpadmin.entities.Endereco;
import app.meuplano.mpadmin.enums.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PessoaDTO {

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
  private List<Endereco> enderecos;
}

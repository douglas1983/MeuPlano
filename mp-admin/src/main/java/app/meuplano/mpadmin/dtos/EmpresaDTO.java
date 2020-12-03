package app.meuplano.mpadmin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
  private Long pessoaId;
  private Long tipoCobrancaId;
}

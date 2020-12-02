package app.meuplano.mpadmin.enums;

public enum TipoPessoa {
  PF("Pessoa Fisica"), PJ("Pessoa Jurifica");

  private String descricao;

  TipoPessoa(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

}

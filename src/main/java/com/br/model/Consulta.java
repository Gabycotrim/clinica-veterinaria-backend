package com.br.model;

//Importa o tipo Date para trabalhar com datas
import java.sql.Date;

//Importações do JPA ("API")
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entidade @Entity que será transformada em tabela
@Entity

//Nome da tabela @Table, nesse caso consulta
@Table(name="consulta")
public class Consulta {

	//Chave Primária que será gerada automaticamente pelo banco de dados, numeração única e sequencial
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigo;

  //Define o nome da coluna para "prontuario" e armazena as informações do historico de saude do pet, medicacoes, exames, etc...
  @Column(name="prontuario")
  private String prontuario;

  //Define o nome da coluna para "quantidade_dias_tratamento" e armazena a quantidade de dias de tratamento recomendada para o pet
  @Column(name="quantidade_dias_tratamento")
  private int quantidadeDiasTratamento;

  //Define o nome da coluna para "retorno" e armazena se o pet terá ou não retorno
  @Column(name="retorno")
  private boolean retorno;

  //Define o nome da coluna para "data_consulta" e armazena a data que a consulta do pet foi realizada
  @Column(name="data_consulta")
  private Date dataConsulta;

  //Define o nome da coluna para "valor_consulta" e armazena o valor da consulta
  @Column(name="valor_consulta")
  private double valorConsulta;

  //Construtor padrão - Obrigatório para o JPA funcionar corretamente
  public Consulta() {
      super();
  }

  //Construtor completo - Com todos os atributos, facilita na criação de objetos completos
  public Consulta(Long codigo, String prontuario, int quantidadeDiasTratamento, boolean retorno, Date dataConsulta, double valorConsulta) {
      super();
      this.codigo = codigo;
      this.prontuario = prontuario;
      this.quantidadeDiasTratamento = quantidadeDiasTratamento;
      this.retorno = retorno;
      this.dataConsulta = dataConsulta;
      this.valorConsulta = valorConsulta;
  }

  //GETTERS E SETTERS

  //Retorna o código da consulta
  public Long getCodigo() {
      return codigo;
  }

  //Define o codigo da consulta
  public void setCodigo(Long codigo) {
      this.codigo = codigo;
  }

  //Retorna o prontuario do pet
  public String getProntuario() {
      return prontuario;
  }

  //Define o prontuario do pet
  public void setProntuario(String prontuario) {
      this.prontuario = prontuario;
  }

  //Retorna a quantidade de dias de tratamento recomendada ao pet
  public int getQuantidadeDiasTratamento() {
      return quantidadeDiasTratamento;
  }

  //Define a quantidade de dias de tratamento recomendada ao pet
  public void setQuantidadeDiasTratamento(int quantidadeDiasTratamento) {
      this.quantidadeDiasTratamento = quantidadeDiasTratamento;
  }
  
  //Em boolean usamos "is" ao invés de "get" - Retorna se o pet tem ou não retorno
  public boolean isRetorno() {
      return retorno;
  }

  //Define se o pet tem ou não retorno
  public void setRetorno(boolean retorno) {
      this.retorno = retorno;
  }

  //Retorna a data da consulta do pet
  public Date getDataConsulta() {
      return dataConsulta;
  }

  //Define a data da consulta do pet
  public void setDataConsulta(Date dataConsulta) {
      this.dataConsulta = dataConsulta;
  }

  //Retorna ao valor da consulta do pet
  public double getValorConsulta() {
      return valorConsulta;
  }

  //Define o valor da consulta do pet
  public void setValorConsulta(double valorConsulta) {
      this.valorConsulta = valorConsulta;
  }
  
}

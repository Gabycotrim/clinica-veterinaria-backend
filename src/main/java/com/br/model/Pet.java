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

//Nome da tabela @Table, nesse caso pet
@Table(name="pet")
public class Pet {

	//Chave Primária que será gerada automaticamente pelo banco de dados, numeração única e sequencial
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigo;

  //Define o nome da coluna para "nome" e armazena o nome do pet
  @Column(name="nome")
  private String nome;

  //Define o nome da coluna para "especie" e armazena a especie do pet
  @Column(name="especie")
  private String especie;

  //Define o nome da coluna para "idade" e armazena a idade do pet
  @Column(name="idade")
  private int idade;

  //Define o nome da coluna para "vacinado" e armazena se o pet está ou não vacinado
  @Column(name="vacinado")
  private boolean vacinado;

  //Define o nome da coluna para "data_nascimento" e armazena a data que o pet nasceu
  @Column(name="data_nascimento")
  private Date dataNascimento;

  //Construtor padrão - Obrigatório para o JPA funcionar corretamente
  public Pet() {
      super();
  }

  //Construtor completo - Com todos os atributos, facilita na criação de objetos completos
  public Pet(Long codigo, String nome, String especie, int idade, boolean vacinado, Date dataNascimento) {
      super();
      this.codigo = codigo;
      this.nome = nome;
      this.especie = especie;
      this.idade = idade;
      this.vacinado = vacinado;
      this.dataNascimento = dataNascimento;
  }

  //GETTERS E SETTERS

  //Retorna o código do pet
  public Long getCodigo() {
      return codigo;
  }

  //Define o codigo do pet
  public void setCodigo(Long codigo) {
      this.codigo = codigo;
  }

  //Retorna o nome do pet
  public String getNome() {
      return nome;
  }

  //Define o nome do pet
  public void setNome(String nome) {
      this.nome = nome;
  }

  //Retorna a especie do pet
  public String getEspecie() {
      return especie;
  }

  //Define a especie do pet
  public void setEspecie(String especie) {
      this.especie = especie;
  }

  //Retorna a idade do pet
  public int getIdade() {
      return idade;
  }

  //Define a idade do pet
  public void setIdade(int idade) {
      this.idade = idade;
  }

  //Em boolean usamos "is" ao invés de "get" - Retorna se o pet está vacinado
  public boolean isVacinado() {
      return vacinado;
  }

  //Define se o pet está vacinado
  public void setVacinado(boolean vacinado) {
      this.vacinado = vacinado;
  }

  //Retorna a data de nascimento do pet
  public Date getDataNascimento() {
      return dataNascimento;
  }

  //Define a data de nascimento do pet
  public void setDataNascimento(Date dataNascimento) {
      this.dataNascimento = dataNascimento;
  }
  
}

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

//Nome da tabela @Table, nesse caso tutor
@Table(name="tutor")
public class Tutor {

	//Chave Primária que será gerada automaticamente pelo banco de dados, numeração única e sequencial
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    //Define o nome da coluna para "nome" e armazena o nome do tutor
    @Column(name="nome")
    private String nome;

    //Define o nome da coluna para "cpf" e armazena o cpf do tutor
    @Column(name="cpf")
    private String cpf;

    //Define o nome da coluna para "idade" e armazena a idade do tutor
    @Column(name="idade")
    private int idade;

    //Define o nome da coluna para "possui_convenio" e armazena se o tutor possui ou não convenio
    @Column(name="possui_convenio")
    private boolean possuiConvenio;

    //Define o nome da coluna para "data_cadastro" e armazena a data que o tutor foi cadastrado no sistema
    @Column(name="data_cadastro")
    private Date dataCadastro;

    //Construtor padrão - Obrigatório para o JPA funcionar corretamente
    public Tutor() {
        super();
    }

    //Construtor completo - Com todos os atributos, facilita na criação de objetos completos
    public Tutor(Long codigo, String nome, String cpf, int idade, boolean possuiConvenio, Date dataCadastro) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.possuiConvenio = possuiConvenio;
        this.dataCadastro = dataCadastro;
    }

    //GETTERS E SETTERS

    //Retorna o código do tutor
    public Long getCodigo() {
        return codigo;
    }

    //Define o codigo do tutor
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    //Retorna o nome do tutor
    public String getNome() {
        return nome;
    }

    //Define o nome do tutor
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Retorna o CPF do tutor
    public String getCpf() {
        return cpf;
    }

    //Define o CPF do tutor
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Retorna a idade do tutor
    public int getIdade() {
        return idade;
    }

    //Define a idade do tutor
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Em boolean usamos "is" ao invés de "get" - Retorna se o tutor possui convenio
    public boolean isPossuiConvenio() {
        return possuiConvenio;
    }

    //Define se o tutor possui convenio
    public void setPossuiConvenio(boolean possuiConvenio) {
        this.possuiConvenio = possuiConvenio;
    }

    //Retorna a data do cadastro
    public Date getDataCadastro() {
        return dataCadastro;
    }

    //Define a data do cadastro
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
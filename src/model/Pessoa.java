package model;

import interfaces.IExibirDados;
import java.util.*;

public abstract class Pessoa implements IExibirDados {
    protected int id;
    protected String nome;
    protected Date dataNascimento;
    protected String cpf;
    protected Endereco endereco;

    public void exibirDados() {
        System.out.println("Nome: " + nome);
    }

    public int hashCode() {
        return Objects.hash(cpf);
    }

    public boolean equals(Object o) {
        if (o instanceof Pessoa) {
            return this.cpf.equals(((Pessoa)o).cpf);
        }
        return false;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
package model;

import java.util.*;

public class PlanoTreino {
    private int id;
    private String nome;
    private List<Exercicio> exercicios;

    public PlanoTreino(int id, String nome, List<Exercicio> exercicios) {
        this.id = id;
        this.nome = nome;
        this.exercicios = exercicios;
    }

    public String getNome() {
        return nome;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Object o) {
        if (o instanceof PlanoTreino) {
            return this.id == ((PlanoTreino)o).id;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }

}

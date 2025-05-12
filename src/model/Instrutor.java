package model;

public class Instrutor extends Funcionario {
    private String especialidade;
    private Academia academia;

    public void cadastrarInstrutor(String especialidade, Academia academia) {
        this.especialidade = especialidade;
        this.academia = academia;
    }

    public void removerInstrutor() {
        this.academia = null;
    }

    public void adicionarAcademia(Academia academia) {
        this.academia = academia;
    }

    public Academia getAcademia() {
        return academia;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }
}

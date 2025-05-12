package model;

public class Academia {
    private static Academia instancia;
    private int id;
    private String nome;
    private String matricula;
    private Endereco endereco;

    private Academia() {}

    public static Academia getInstancia() {
        if (instancia == null) {
            instancia = new Academia();
        }
        return instancia;
    }

    public void cadastrarAcademia(int id, String nome, String matricula, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.endereco = endereco;
    }

    public void removerAcademia() {
        instancia = null;
    }

    public String toString() {
        return nome + " - " + matricula;
    }

    public static void setInstancia(Academia instancia) {
        Academia.instancia = instancia;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

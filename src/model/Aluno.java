package model;

import observer.Observador;
import java.util.*;

public class Aluno extends Pessoa implements Observador {
    private Date dataRenovacaoMatricula;
    private List<PlanoTreino> planosTreino = new ArrayList<>();
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    private List<Pagamento> pagamentos = new ArrayList<>();
    private Instrutor personal;

    public void cadastrarAluno() {}
    public void removerAluno() {}

    public void realizarPagamento(double valor, Date data, String formaPagamento) {
        Pagamento pagamento = new Pagamento();
        pagamento.valor = valor;
        pagamento.data = data;
        pagamento.formaPagamento = formaPagamento;
        pagamento.status = "Pago";
        pagamentos.add(pagamento);
    }

    public void adicionarPlanoTreino(PlanoTreino plano) {
        planosTreino.add(plano);
    }

    public void exibirPlanoTreino() {
        planosTreino.forEach(p -> System.out.println(p.getNome()));
    }

    public void adicionarAvaliacaoFisica(AvaliacaoFisica avaliacao) {
        avaliacao.adicionarObservador(this);
        avaliacao.novaAvaliacao();
    }

    public void setPersonalAluno(Instrutor personal) {
        this.personal = personal;
    }

    public boolean verificarMatricula() {
        return dataRenovacaoMatricula != null;
    }

    public void atualizar(AvaliacaoFisica avaliacao) {
        System.out.println("Aluno " + nome + " recebeu nova avaliação. IMC: " + avaliacao.calcularIMC());
    }

    public Date getDataRenovacaoMatricula() {
        return dataRenovacaoMatricula;
    }

    public void setDataRenovacaoMatricula(Date dataRenovacaoMatricula) {
        this.dataRenovacaoMatricula = dataRenovacaoMatricula;
    }

    public List<PlanoTreino> getPlanosTreino() {
        if (planosTreino == null) planosTreino = new ArrayList<>();
        return planosTreino;
    }

    public void setPlanosTreino(List<PlanoTreino> planosTreino) {
        this.planosTreino = planosTreino;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Instrutor getPersonal() {
        return personal;
    }

    public void setPersonal(Instrutor personal) {
        this.personal = personal;
    }

    public PlanoTreino getPlanoTreinoAtual() {
        if (planosTreino != null && !planosTreino.isEmpty()) {
            return planosTreino.get(planosTreino.size() - 1);
        }
        return null;
    }



}

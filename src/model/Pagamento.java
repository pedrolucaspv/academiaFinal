package model;
import java.util.*;

public class Pagamento {
    int id;
    double valor;
    String formaPagamento;
    Date data;
    String status;

    public void exibirStatusPagamento() {
        System.out.println("Status: " + status);
    }

    public void receberPagamento(Pagamento pagamento) {
        this.status = "Pago";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
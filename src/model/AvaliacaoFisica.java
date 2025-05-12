package model;

import java.util.*;
import observer.Observador;
import strategy.CalculoIMCStrategy;

public class AvaliacaoFisica {
    int id;
    double peso;
    double altura;
    double percentualGordura;
    int nivelForca;
    double imc;
    Date data;
    private CalculoIMCStrategy estrategia;
    private List<Observador> observadores = new ArrayList<>();

    public void setEstrategia(CalculoIMCStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularIMC() {
        imc = estrategia.calcular(peso, altura);
        return imc;
    }

    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificar() {
        for (Observador o : observadores) {
            o.atualizar(this);
        }
    }

    public void novaAvaliacao() {
        calcularIMC();
        notificar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public int getNivelForca() {
        return nivelForca;
    }

    public void setNivelForca(int nivelForca) {
        this.nivelForca = nivelForca;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public CalculoIMCStrategy getEstrategia() {
        return estrategia;
    }

    public List<Observador> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<Observador> observadores) {
        this.observadores = observadores;
    }
}

package decorator;

import interfaces.IExibirDados;
import model.Pessoa;

public abstract class ExibirDadosDecorator implements IExibirDados {
    protected IExibirDados componente;

    public ExibirDadosDecorator(IExibirDados componente) {
        this.componente = componente;
    }

    public void exibirDados() {
        componente.exibirDados();
    }
}
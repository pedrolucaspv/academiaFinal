package decorator;
import interfaces.*;
import model.*;

public class ExibirDadosComEndereco extends ExibirDadosDecorator {
    public ExibirDadosComEndereco(IExibirDados componente) {
        super(componente);
    }

    public void exibirDados() {
        super.exibirDados();
        if (componente instanceof Pessoa p) {
            System.out.println("Endereço: " + p.getEndereco());
        }
    }
}

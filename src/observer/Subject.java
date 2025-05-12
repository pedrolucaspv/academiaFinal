package observer;

public interface Subject {
    void adicionarObservador(Observador o);
    void removerObservador(Observador o);
    void notificar();
}
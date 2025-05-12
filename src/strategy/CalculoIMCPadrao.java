package strategy;

public class CalculoIMCPadrao implements CalculoIMCStrategy {
    public double calcular(double peso, double altura) {
        return peso / (altura * altura);
    }
}
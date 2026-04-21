package calculadora.operaciones;

public class LogaritmoNatural extends OperacionUnaria {
    @Override
    public String getSimbolo() { return "ln"; }
    @Override
    public double ejecutar(int a) {
        if (a <= 0) throw new ArithmeticException("Logaritmo de un número menor o igual a cero");
        return Math.log(a);
    }
}

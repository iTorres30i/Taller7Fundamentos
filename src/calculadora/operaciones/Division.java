package calculadora.operaciones;

public class Division extends OperacionBinaria {
    @Override
    public String getSimbolo() { return "/"; }
    @Override
    public double ejecutar(int a, int b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        return (double) a / b;
    }
}

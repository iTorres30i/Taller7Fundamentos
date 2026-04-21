package calculadora.operaciones;

public class RaizCuadrada extends OperacionUnaria {
    @Override
    public String getSimbolo() { return "sqrt"; }
    @Override
    public double ejecutar(int a) {
        if (a < 0) throw new ArithmeticException("Raíz cuadrada de un número negativo");
        return Math.sqrt(a);
    }
}

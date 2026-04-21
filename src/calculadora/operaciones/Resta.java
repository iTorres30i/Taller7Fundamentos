package calculadora.operaciones;

public class Resta extends OperacionBinaria {
    @Override
    public String getSimbolo() { return "-"; }
    @Override
    public double ejecutar(int a, int b) { return a - b; }
}

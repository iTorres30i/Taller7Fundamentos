package calculadora.operaciones;

public abstract class OperacionBinaria {
    public abstract String getSimbolo();
    public abstract boolean sonValidos(int a, int b);
    public abstract double ejecutar(int a, int b);
}

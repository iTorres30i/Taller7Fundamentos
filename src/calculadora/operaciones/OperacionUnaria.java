package calculadora.operaciones;

public abstract class OperacionUnaria {
    public abstract String getSimbolo();
    public abstract boolean esValido(int a);
    public abstract double ejecutar(int a);
}

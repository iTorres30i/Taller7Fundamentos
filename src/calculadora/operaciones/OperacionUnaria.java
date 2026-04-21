package calculadora.operaciones;

public interface OperacionUnaria {
    boolean esValido(int a);
    double ejecutar(int a);
}

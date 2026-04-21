package calculadora.operaciones;

public interface OperacionBinaria {
    boolean sonValidos(int a, int b);
    double ejecutar(int a, int b);
}

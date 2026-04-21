package calculadora.operaciones;

public class Multiplicacion implements OperacionBinaria, Identificable {
    @Override
    public String getSimbolo() { return "*"; }
    
    @Override
    public boolean sonValidos(int a, int b) { 
        return true; 
    }
    
    @Override
    public double ejecutar(int a, int b) { return a * b; }
}

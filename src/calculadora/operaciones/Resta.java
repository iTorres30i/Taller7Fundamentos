package calculadora.operaciones;

public class Resta extends OperacionBinaria {
    @Override
    public String getSimbolo() { return "-"; }
    
    @Override
    public boolean sonValidos(int a, int b) { 
        return true; 
    }
    
    @Override
    public double ejecutar(int a, int b) { return a - b; }
}

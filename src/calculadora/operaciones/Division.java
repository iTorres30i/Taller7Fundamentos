package calculadora.operaciones;

public class Division extends OperacionBinaria {
    @Override
    public String getSimbolo() { return "/"; }
    
    @Override
    public boolean sonValidos(int a, int b) { 
        return b != 0; 
    }
    
    @Override
    public double ejecutar(int a, int b) { 
        return (double) a / b; 
    }
}

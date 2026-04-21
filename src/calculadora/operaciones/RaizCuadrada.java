package calculadora.operaciones;

public class RaizCuadrada implements OperacionUnaria, Identificable {
    @Override
    public String getSimbolo() { return "sqrt"; }
    
    @Override
    public boolean esValido(int a) { 
        return a >= 0; 
    }
    
    @Override
    public double ejecutar(int a) { 
        return Math.sqrt(a); 
    }
}

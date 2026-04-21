package calculadora.operaciones;

public class LogaritmoNatural implements OperacionUnaria, Identificable {
    @Override
    public String getSimbolo() { return "ln"; }
    
    @Override
    public boolean esValido(int a) { 
        return a > 0; 
    }
    
    @Override
    public double ejecutar(int a) { 
        return Math.log(a); 
    }
}

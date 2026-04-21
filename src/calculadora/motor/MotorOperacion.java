package calculadora.motor;

import calculadora.operaciones.*;
import java.util.HashMap;
import java.util.Map;

public class MotorOperacion implements IMotorBinario, IMotorUnario {
    private Map<String, OperacionBinaria> operacionesBinarias;
    private Map<String, OperacionUnaria> operacionesUnarias;

    public MotorOperacion() {
        operacionesBinarias = new HashMap<>();
        operacionesBinarias.put("+", new Suma());
        operacionesBinarias.put("-", new Resta());
        operacionesBinarias.put("*", new Multiplicacion());
        operacionesBinarias.put("/", new Division());

        operacionesUnarias = new HashMap<>();
        operacionesUnarias.put("sqrt", new RaizCuadrada());
        operacionesUnarias.put("ln", new LogaritmoNatural());
    }

    public double ejecutarBinaria(String op, int a, int b) {
        OperacionBinaria operacion = operacionesBinarias.get(op);
        if (operacion == null) {
            throw new IllegalArgumentException("Operación binaria no válida.");
        }
        
        // Verificación basada en contrato abstracto (Cumpliendo Liskov)
        if (!operacion.sonValidos(a, b)) {
            throw new ArithmeticException("Valores no válidos para la operación de '" + op + "'.");
        }
        
        return operacion.ejecutar(a, b);
    }

    public double ejecutarUnaria(String op, int a) {
        OperacionUnaria operacion = operacionesUnarias.get(op);
        if (operacion == null) {
            throw new IllegalArgumentException("Operación unaria no válida.");
        }
        
        // Verificación basada en contrato abstracto (Cumpliendo Liskov)
        if (!operacion.esValido(a)) {
             throw new ArithmeticException("Valores no válidos para la operación de '" + op + "'.");
        }
        
        return operacion.ejecutar(a);
    }
}

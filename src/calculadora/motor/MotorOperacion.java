package calculadora.motor;

import calculadora.operaciones.Operacion;
import java.util.HashMap;
import java.util.Map;

public class MotorOperacion {
    private Map<String, Operacion.OperacionBinaria> operacionesBinarias;
    private Map<String, Operacion.OperacionUnaria> operacionesUnarias;

    public MotorOperacion() {
        operacionesBinarias = new HashMap<>();
        operacionesBinarias.put("+", new Operacion.Suma());
        operacionesBinarias.put("-", new Operacion.Resta());
        operacionesBinarias.put("*", new Operacion.Multiplicacion());
        operacionesBinarias.put("/", new Operacion.Division());

        operacionesUnarias = new HashMap<>();
        operacionesUnarias.put("sqrt", new Operacion.RaizCuadrada());
        operacionesUnarias.put("ln", new Operacion.LogaritmoNatural());
    }

    public double ejecutarBinaria(String op, int a, int b) {
        Operacion.OperacionBinaria operacion = operacionesBinarias.get(op);
        if (operacion == null) {
            throw new IllegalArgumentException("Operación binaria no válida.");
        }
        return operacion.ejecutar(a, b);
    }

    public double ejecutarUnaria(String op, int a) {
        Operacion.OperacionUnaria operacion = operacionesUnarias.get(op);
        if (operacion == null) {
            throw new IllegalArgumentException("Operación unaria no válida.");
        }
        return operacion.ejecutar(a);
    }
}

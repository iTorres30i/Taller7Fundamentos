package calculadora.tests;

import calculadora.motor.MotorOperacion;

/**
 * Clase de Test Unitario (Evidencia de TDD)
 * Está escrita usando Java puro (sin librerías externas) para garantizar
 * que no rompa tu proyecto ni te marque errores de importaciones faltantes.
 */
public class MotorOperacionTest {

    public static void main(String[] args) {
        System.out.println("--- Ejecutando Pruebas Unitarias TDD ---");
        MotorOperacion motor = new MotorOperacion();

        testSumaCorrecta(motor);
        testDivisionPorCeroLanzaExcepcion(motor);
        testRaizCuadradaCorrecta(motor);
        testRaizNegativaLanzaExcepcion(motor);

        System.out.println("--- ¡Todas las pruebas pasaron satisfactoriamente! ---");
    }

    private static void testSumaCorrecta(MotorOperacion motor) {
        double resultado = motor.ejecutarBinaria("+", 5, 3);
        if (resultado != 8.0) {
            throw new AssertionError("Fallo en testSumaCorrecta: Se esperaba 8.0 pero el resultado fue " + resultado);
        }
        System.out.println("[OK] testSumaCorrecta");
    }

    private static void testDivisionPorCeroLanzaExcepcion(MotorOperacion motor) {
        try {
            motor.ejecutarBinaria("/", 10, 0);
            throw new AssertionError("Fallo en testDivisionPorCero: Debió lanzar una ArithmeticException");
        } catch (ArithmeticException e) {
            // Pasó la prueba unitaria (Liskov)
            System.out.println("[OK] testDivisionPorCeroLanzaExcepcion");
        }
    }

    private static void testRaizCuadradaCorrecta(MotorOperacion motor) {
        double resultado = motor.ejecutarUnaria("sqrt", 9);
        if (resultado != 3.0) {
            throw new AssertionError("Fallo en testRaizCuadradaCorrecta: Se esperaba 3.0 pero el resultado fue " + resultado);
        }
        System.out.println("[OK] testRaizCuadradaCorrecta");
    }

    private static void testRaizNegativaLanzaExcepcion(MotorOperacion motor) {
        try {
            motor.ejecutarUnaria("sqrt", -5);
            throw new AssertionError("Fallo en testRaizNegativa: Debió lanzar una ArithmeticException");
        } catch (ArithmeticException e) {
            // Pasó la prueba unitaria (Liskov)
            System.out.println("[OK] testRaizNegativaLanzaExcepcion");
        }
    }
}

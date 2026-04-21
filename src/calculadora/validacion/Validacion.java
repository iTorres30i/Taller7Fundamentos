package calculadora.validacion;

public class Validacion {
    public static int validarEntero(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Por favor ingrese números enteros válidos.");
        }
    }
}

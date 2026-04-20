import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Calculadora {

    // Interfaces para aplicar principios SOLID (Open-Closed Principle)
    // permitiendo agregar nuevas operaciones sin modificar la lógica principal.
    interface Operacion {
        String getSimbolo();
    }

    interface OperacionBinaria extends Operacion {
        double ejecutar(int a, int b);
    }

    interface OperacionUnaria extends Operacion {
        double ejecutar(int a);
    }

    // --- Implementaciones de Operaciones Binarias ---
    static class Suma implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "+"; }
        @Override
        public double ejecutar(int a, int b) { return a + b; }
    }

    static class Resta implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "-"; }
        @Override
        public double ejecutar(int a, int b) { return a - b; }
    }
    
    static class Multiplicacion implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "*"; }
        @Override
        public double ejecutar(int a, int b) { return a * b; }
    }
    
    static class Division implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "/"; }
        @Override
        public double ejecutar(int a, int b) {
            if (b == 0) throw new ArithmeticException("División por cero");
            return (double) a / b;
        }
    }

    // --- Implementaciones de Operaciones Unarias ---
    static class RaizCuadrada implements OperacionUnaria {
        @Override
        public String getSimbolo() { return "sqrt"; }
        @Override
        public double ejecutar(int a) {
            if (a < 0) throw new ArithmeticException("Raíz cuadrada de un número negativo");
            return Math.sqrt(a);
        }
    }

    static class LogaritmoNatural implements OperacionUnaria {
        @Override
        public String getSimbolo() { return "ln"; }
        @Override
        public double ejecutar(int a) {
            if (a <= 0) throw new ArithmeticException("Logaritmo de un número menor o igual a cero");
            return Math.log(a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Registro de operaciones (simulando Inyección de Dependencias / Factory)
        Map<String, OperacionBinaria> operacionesBinarias = new HashMap<>();
        operacionesBinarias.put("+", new Suma());
        operacionesBinarias.put("-", new Resta());
        operacionesBinarias.put("*", new Multiplicacion());
        operacionesBinarias.put("/", new Division());

        Map<String, OperacionUnaria> operacionesUnarias = new HashMap<>();
        operacionesUnarias.put("sqrt", new RaizCuadrada());
        operacionesUnarias.put("ln", new LogaritmoNatural());

        System.out.println("============= Calculadora SOLID =============");
        System.out.println("Operaciones binarias disponibles: +, -, *, /");
        System.out.println("Operaciones unarias disponibles: sqrt, ln");
        System.out.println("Escriba 'salir' para terminar.");
        System.out.println("=============================================");

        while (true) {
            System.out.print("\nIngrese el tipo de operación ('binaria', 'unaria') o 'salir': ");
            String tipo = scanner.nextLine().trim().toLowerCase();

            if (tipo.equals("salir")) {
                break;
            }

            try {
                if (tipo.equals("binaria")) {
                    System.out.print("Ingrese el primer número entero: ");
                    int a = Integer.parseInt(scanner.nextLine().trim());
                    
                    System.out.print("Ingrese la operación (+, -, *, /): ");
                    String op = scanner.nextLine().trim();

                    System.out.print("Ingrese el segundo número entero: ");
                    int b = Integer.parseInt(scanner.nextLine().trim());
                    
                    OperacionBinaria operacion = operacionesBinarias.get(op);
                    if (operacion != null) {
                        System.out.println("Resultado: " + operacion.ejecutar(a, b));
                    } else {
                        System.out.println("Error: Operación binaria no válida.");
                    }
                } else if (tipo.equals("unaria")) {
                    System.out.print("Ingrese la operación (sqrt, ln): ");
                    String op = scanner.nextLine().trim();

                    System.out.print("Ingrese el número entero: ");
                    int a = Integer.parseInt(scanner.nextLine().trim());
                    
                    OperacionUnaria operacion = operacionesUnarias.get(op);
                    if (operacion != null) {
                        System.out.println("Resultado: " + operacion.ejecutar(a));
                    } else {
                        System.out.println("Error: Operación unaria no válida.");
                    }
                } else {
                    System.out.println("Tipo no reconocido. Use 'binaria' o 'unaria'.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese números enteros válidos.");
            } catch (ArithmeticException e) {
                System.out.println("Error matemático: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("¡Adiós!");
    }
}

package calculadora.ui;

import calculadora.motor.MotorOperacion;
import calculadora.validacion.Validacion;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private MotorOperacion motor;

    public Menu(MotorOperacion motor) {
        this.scanner = new Scanner(System.in);
        this.motor = motor;
    }

    public void iniciar() {
        System.out.println("============= Calculadora =============");
        System.out.println("Operaciones binarias disponibles: +, -, *, /");
        System.out.println("Operaciones unarias disponibles: sqrt, ln");
        System.out.println("Escriba 'salir' para terminar.");
        System.out.println("=======================================");

        while (true) {
            System.out.print("\nIngrese el tipo de operación ('binaria', 'unaria') o 'salir': ");
            String tipo = scanner.nextLine().trim().toLowerCase();

            if (tipo.equals("salir")) {
                break;
            }

            try {
                if (tipo.equals("binaria")) {
                    System.out.print("Ingrese el primer número entero: ");
                    int a = Validacion.validarEntero(scanner.nextLine());
                    
                    System.out.print("Ingrese la operación (+, -, *, /): ");
                    String op = scanner.nextLine().trim();

                    System.out.print("Ingrese el segundo número entero: ");
                    int b = Validacion.validarEntero(scanner.nextLine());
                    
                    double resultado = motor.ejecutarBinaria(op, a, b);
                    System.out.println("Resultado: " + resultado);

                } else if (tipo.equals("unaria")) {
                    System.out.print("Ingrese la operación (sqrt, ln): ");
                    String op = scanner.nextLine().trim();

                    System.out.print("Ingrese el número entero: ");
                    int a = Validacion.validarEntero(scanner.nextLine());
                    
                    double resultado = motor.ejecutarUnaria(op, a);
                    System.out.println("Resultado: " + resultado);

                } else {
                    System.out.println("Tipo no reconocido. Use 'binaria' o 'unaria'.");
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        System.out.println("¡Adiós!");
    }
}

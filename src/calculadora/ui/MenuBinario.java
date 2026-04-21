package calculadora.ui;

import calculadora.motor.IMotorBinario;
import calculadora.validacion.Validacion;
import java.util.Scanner;

public class MenuBinario {
    private Scanner scanner;
    private IMotorBinario motorBinario; // Solo depende de las operaciones binarias gracias a ISP

    public MenuBinario(IMotorBinario motorBinario, Scanner scanner) {
        this.motorBinario = motorBinario;
        this.scanner = scanner;
    }

    public void iniciar() {
        System.out.println("--- Modo Binario ---");
        System.out.println("Operaciones disponibles: +, -, *, /");
        try {
            System.out.print("Ingrese el primer número entero: ");
            int a = Validacion.validarEntero(scanner.nextLine());
            
            System.out.print("Ingrese la operación (+, -, *, /): ");
            String op = scanner.nextLine().trim();

            System.out.print("Ingrese el segundo número entero: ");
            int b = Validacion.validarEntero(scanner.nextLine());
            
            double resultado = motorBinario.ejecutarBinaria(op, a, b);
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}

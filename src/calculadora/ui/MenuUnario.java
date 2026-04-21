package calculadora.ui;

import calculadora.motor.IMotorUnario;
import calculadora.validacion.Validacion;
import java.util.Scanner;

public class MenuUnario {
    private Scanner scanner;
    private IMotorUnario motorUnario; // Solo depende de las operaciones unarias gracias a ISP

    public MenuUnario(IMotorUnario motorUnario, Scanner scanner) {
        this.motorUnario = motorUnario;
        this.scanner = scanner;
    }

    public void iniciar() {
        System.out.println("--- Modo Unario ---");
        System.out.println("Operaciones disponibles: sqrt, ln");
        try {
            System.out.print("Ingrese la operación (sqrt, ln): ");
            String op = scanner.nextLine().trim();

            System.out.print("Ingrese el número entero: ");
            int a = Validacion.validarEntero(scanner.nextLine());
            
            double resultado = motorUnario.ejecutarUnaria(op, a);
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}

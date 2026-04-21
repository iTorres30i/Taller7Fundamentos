package calculadora;

import calculadora.motor.MotorOperacion;
import calculadora.ui.Menu;
import calculadora.ui.MenuBinario;
import calculadora.ui.MenuUnario;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        // 1. Instanciamos el Motor (que implementa IMotorBinario e IMotorUnario)
        MotorOperacion motor = new MotorOperacion();
        Scanner scanner = new Scanner(System.in);
        
        // 2. Aplicamos ISP: El MenuBinario recibe el motor, pero cast-eado internamente 
        //    a IMotorBinario. No sabe nada de unarias.
        MenuBinario menuBinario = new MenuBinario(motor, scanner);
        
        // 3. El MenuUnario recibe el motor, cast-eado internamente a IMotorUnario.
        MenuUnario menuUnario = new MenuUnario(motor, scanner);
        
        // 4. Arrancamos el Menu Principal.
        Menu menu = new Menu(menuBinario, menuUnario, scanner);
        menu.iniciar();
        
        scanner.close();
        System.out.println("¡Adiós!");
    }
}

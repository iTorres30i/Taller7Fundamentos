package calculadora.ui;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private MenuBinario menuBinario;
    private MenuUnario menuUnario;

    public Menu(MenuBinario menuBinario, MenuUnario menuUnario, Scanner scanner) {
        this.menuBinario = menuBinario;
        this.menuUnario = menuUnario;
        this.scanner = scanner;
    }

    public void iniciar() {
        System.out.println("============= Calculadora ISP =============");
        System.out.println("Escriba 'salir' para terminar.");
        
        while (true) {
            System.out.print("\nIngrese el menú al que desea entrar ('binaria', 'unaria') o 'salir': ");
            String tipo = scanner.nextLine().trim().toLowerCase();

            if (tipo.equals("salir")) {
                break;
            }

            if (tipo.equals("binaria")) {
                menuBinario.iniciar();
            } else if (tipo.equals("unaria")) {
                menuUnario.iniciar();
            } else {
                System.out.println("Tipo no reconocido. Use 'binaria' o 'unaria'.");
            }
        }
    }
}

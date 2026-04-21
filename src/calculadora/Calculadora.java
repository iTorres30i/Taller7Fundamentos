package calculadora;

import calculadora.motor.MotorOperacion;
import calculadora.ui.Menu;

public class Calculadora {
    public static void main(String[] args) {
        MotorOperacion motor = new MotorOperacion();
        Menu menu = new Menu(motor);
        menu.iniciar();
    }
}

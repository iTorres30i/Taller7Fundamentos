package calculadora.operaciones;

public interface Operacion {
    String getSimbolo();

    public interface OperacionBinaria extends Operacion {
        double ejecutar(int a, int b);
    }

    public interface OperacionUnaria extends Operacion {
        double ejecutar(int a);
    }

    public static class Suma implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "+"; }
        @Override
        public double ejecutar(int a, int b) { return a + b; }
    }

    public static class Resta implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "-"; }
        @Override
        public double ejecutar(int a, int b) { return a - b; }
    }

    public static class Multiplicacion implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "*"; }
        @Override
        public double ejecutar(int a, int b) { return a * b; }
    }

    public static class Division implements OperacionBinaria {
        @Override
        public String getSimbolo() { return "/"; }
        @Override
        public double ejecutar(int a, int b) {
            if (b == 0) throw new ArithmeticException("División por cero");
            return (double) a / b;
        }
    }

    public static class RaizCuadrada implements OperacionUnaria {
        @Override
        public String getSimbolo() { return "sqrt"; }
        @Override
        public double ejecutar(int a) {
            if (a < 0) throw new ArithmeticException("Raíz cuadrada de un número negativo");
            return Math.sqrt(a);
        }
    }

    public static class LogaritmoNatural implements OperacionUnaria {
        @Override
        public String getSimbolo() { return "ln"; }
        @Override
        public double ejecutar(int a) {
            if (a <= 0) throw new ArithmeticException("Logaritmo de un número menor o igual a cero");
            return Math.log(a);
        }
    }
}

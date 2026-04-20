# Calculadora SoLiD

Este proyecto contiene una calculadora interactiva por consola desarrollada en Java (`Calculadora.java`). Está diseñada para demostrar cómo se pueden aplicar principios de diseño orientado a objetos (como SOLID) incluso cuando todo el código se mantiene dentro de un solo archivo.

## ¿Qué responsabilidad tiene la clase `Calculadora`?

Aunque comúnmente el principio de Responsabilidad Única (SRP por sus siglas en inglés) nos dice que cada módulo o clase debe tener una sola razón para cambiar, en este ejercicio todo el código de la calculadora reside en un único archivo.

Para cumplir con buenas prácticas dentro de esta restricción, hemos dividido internamente las responsabilidades mediante **interfaces y clases anidadas**:

### 1. Clases de Operaciones (Single Responsibility y Open/Closed Principle)
Las clases estáticas anidadas como `Suma`, `Resta`, `Division`, `RaizCuadrada`, etc., tienen **una única responsabilidad**: ejecutar su respectiva operación matemática. Si se necesita implementar una nueva operación (como una potencia), se puede crear una nueva clase anidada que implemente la interfaz correspondiente, sin tener que modificar el código de las operaciones existentes (abierto a la extensión, cerrado a la modificación).

### 2. Interfaces `OperacionBinaria` y `OperacionUnaria` (Interface Segregation y Liskov Substitution)
Definen contratos claros para las operaciones que requieren dos números enteros frente a las que solo requieren uno. De esta forma, cada operación implementa solo los métodos que realmente necesita.

### 3. Clase Principal `Calculadora` (Responsabilidad de Coordinación y Entrada/Salida)
La responsabilidad principal de la clase envolvente `Calculadora` y su método `main` no es hacer cálculos matemáticos, sino:
*   **Orquestar la aplicación:** Configurar el mapa de operaciones disponibles (actuando como un pequeño Registro o pseudo-Fábrica).
*   **Interactuar con el usuario:** Mostrar el menú, leer la entrada por consola.
*   **Manejo de Errores:** Capturar y reportar excepciones de manera amigable (como dividir por cero).
*   **Delegar:** Llama al método `ejecutar()` de la operación correspondiente elegida por el usuario.

De esta forma, en vez de tener un gigantesco `switch-case` (el cual viola el principio Abierto/Cerrado), la aplicación está altamente desacoplada y se apoya en el polimorfismo.

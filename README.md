# Calculadora SoLiD

Este proyecto contiene una calculadora interactiva por consola desarrollada en Java, demostrando una separación clara de responsabilidades y aplicando los principios de diseño orientado a objetos (SOLID).

El código se divide en cinco archivos clave, cada uno con una responsabilidad única, cumpliendo fundamentalmente con el **Principio de Responsabilidad Única (SRP)**:

1. **`Validacion.java`**: 
   - **Responsabilidad:** Encargada de gestionar y validar la entrada de datos (por ejemplo, asegurar que el usuario ingrese números enteros válidos y capturar `NumberFormatException`).

2. **`Operacion.java`**:
   - **Responsabilidad:** Define el contrato para las diferentes operaciones matemáticas y contiene las clases de implementación.
   - Aplica el **Principio Abierto/Cerrado (OCP)** y el de **Sustitución de Liskov e Inversión de Dependencias**, definiendo interfaces base (`OperacionBinaria`, `OperacionUnaria`) para que nuevas operaciones (`Suma`, `Resta`, `RaizCuadrada`, etc.) se puedan añadir sin alterar el código existente.

3. **`MotorOperacion.java`**:
   - **Responsabilidad:** Actúa como el "motor" lógico de la calculadora.
   - Gestiona un registro (Mapas internos) de qué operación corresponde a cada símbolo (`+`, `-`, `sqrt`, etc.) y expone métodos para ejecutar dichas operaciones de forma abstracta, pasándoles los parámetros necesarios.

4. **`Menu.java`**:
   - **Responsabilidad:** Manejar única y exclusivamente la Interfaz de Usuario (UI) en consola. 
   - Imprime los mensajes, lee lo que digita el usuario y delega las operaciones lógicas al `MotorOperacion`, además de atrapar excepciones que reportar al usuario.

5. **`Calculadora.java`**:
   - **Responsabilidad:** Es la clase principal y punto de entrada al programa (`main`). Se enfoca simplemente en ensamblar o construir los objetos base (`MotorOperacion` y `Menu`) y dar inicio al ciclo del menú.

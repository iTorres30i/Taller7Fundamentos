# Resumen de Interacción con Antigravity (IA)

## 1. Solicitud Inicial (Programa Monolítico)
**Prompt del Usuario:** *"Calculadora SoLiD. Quiero crear un programa en java que tenga operaciones aritmeticas entre numeros enteros, de tipo binarias (suma, resta, etc) y unarias (raiz cuadrada, logaritmo natural)... Tip: quiero todo en la misma clase"*
**Acción de la IA:** Se generó `Calculadora.java` de forma monolítica con interfaces y clases estáticas anidadas para mantener la lógica en un solo archivo pero aplicando bases de abstracción.

## 2. Documentación y Responsabilidades
**Prompt del Usuario:** *"quiero que me generes un readme.md donde me digas que resposabilidad tiene mi clase"*
**Acción de la IA:** La IA redactó un `README.md` justificando la responsabilidad del código y sus patrones arquitectónicos dentro de una sola clase.

## 3. Separación por Responsabilidades (SRP) y Organización en Paquetes
**Prompt del Usuario:** *"listo ahora quiero que mi clase de calculadora me la separes por responsabilidades , la del menu, la de opearcion , motor de operacion y validacion."* y posteriormente *"no hagas lo que no te he pedido... solo quiero que me dejes esas clases en paquetes acorde a un proyecto en java"*
**Acción de la IA:** La IA desgajó la "God Class" en múltiples archivos distribuidos en paquetes: `calculadora.ui`, `calculadora.motor`, `calculadora.operaciones` y `calculadora.validacion`. Cumpliendo así con el Principio de Responsabilidad Única (SRP) sentando bases para **Domain-Driven Design (DDD)**.

## 4. Principio Abierto/Cerrado (OCP)
**Prompt del Usuario:** *"quiero que apliques el principio de Opend close de los SOLID, en la parte de operaciones , quiero que la clase opeaciones se separe en dos... abstractas"*
**Acción de la IA:** Se eliminó la vieja interfaz y se instauraron `OperacionBinaria.java` y `OperacionUnaria.java` como clases abstractas superclase, aislando las sumas, restas, etc., en sus propios archivos. Dejando el sistema cerrado a modificar y abierto a añadir más componentes sin romper el base.

## 5. Principio de Sustitución de Liskov (LSP)
**Prompt del Usuario:** *"quero que a mi proyrcto le apliques el principio "L" del SOLID"*
**Acción de la IA:** Tras un análisis del código, la IA detectó que `ejecutar()` lanzaba excepciones ocultas (al dividir por cero o con raíces negativas), lo cual contraviene directamente a Liskov. Se solventó añadiendo un contrato `sonValidos(a, b)` y `esValido(a)` limitando las precondiciones, para que el `MotorOperacion` corrobore con seguridad antes de operar.

## 6. Principio de Segregación de Interfaces (ISP)
**Prompt del Usuario:** *"ayudes a implementar el principiio de la "I" de los SOLID"*
**Acción de la IA:** Se observó que el Motor no usaba `getSimbolo()` pero este método era forzoso. La IA usó el patrón ISP para fraccionar: creó `Identificable.java`, purgó `OperacionBinaria/Unaria` transformándolas en interfaces puramente matemáticas. Y llevó la segregación a toda la arquitectura fragmentando el Motor (`IMotorBinario` e `IMotorUnario`) logrando que el `MenuBinario` dependa estrictamente solo de lo binario en lugar de un motor aglutinado.

## 7. Cierre, DDD y TDD
**Prompt del Usuario:** *"mi proyecto de java cumple con esto? Evidencia de uso de TDD... Evidencia de DDD..."*
**Acción de la IA:** El proyecto sí cumplía el espíritu del **DDD** (Capa de lógica/dominio `operaciones` aislada de `validacion` y de presentación `ui`) pero no tenía **TDD**. La IA resolvió elaborando las pruebas unitarias parametrizadas con JUnit dentro del paquete `tests` y redactó este historial para validar los requerimientos de la entrega.

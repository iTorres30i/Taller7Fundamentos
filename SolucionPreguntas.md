 Reflexión sobre la clase `Calculadora`

## 01. ¿Qué responsabilidades tiene exactamente esta clase?

La verdad es que la clase `Calculadora` hace demasiadas cosas al mismo
tiempo. No solo se encarga de hacer las operaciones matemáticas, sino
que también:

-   Define las interfaces de las operaciones\
-   Implementa la lógica (suma, resta, etc.)\
-   Guarda y organiza las operaciones (con el `Map`)\
-   Maneja lo que el usuario escribe y lo que se imprime en consola\
-   Controla el flujo del programa (menús, ciclos, decisiones)\
-   También valida errores

O sea, básicamente hace de todo. Esto no es lo ideal porque una clase
debería tener una sola responsabilidad. Aquí claramente se rompe el
principio SRP.

## 02. Si cambio la forma de imprimir en consola, ¿qué pasa con las operaciones?

En teoría, cambiar la forma en la que se imprime no debería afectar las
operaciones, porque son cosas diferentes.

Pero en este caso sí hay problema, porque todo está metido en la misma
clase. Entonces:

-   La lógica y la presentación están mezcladas\
-   Hay mucho acoplamiento\
-   Toca modificar la misma clase para cualquier cambio

Esto hace que no sea fácil reutilizar las operaciones en otro contexto,
como una app web o con interfaz gráfica.

**Conclusión:** Las operaciones están demasiado amarradas a la consola,
cuando no debería ser así.

## 03. Si quiero tener 2 menús distintos, ¿qué debería modificar?

Aquí tocaría meterse directamente a modificar la clase `Calculadora`,
especialmente:

-   El `main`\
-   El `while`\
-   Los `if/else`

O sea, no hay forma de agregar otro menú sin tocar lo que ya está hecho.

**Problemas:**

-   No es fácil reutilizar el código\
-   Se mezcla todo otra vez (lógica + interfaz)

**Conclusión:** Este diseño no es flexible. Para agregar cosas nuevas
toca modificar lo existente, lo cual va en contra del principio OCP.

## 04. ¿Cómo adiciono operaciones nuevas (ej. Potencia)? ¿Rompe algo más?

Agregar una nueva operación no es tan complicado:

1.  Se crea una clase nueva (por ejemplo `Potencia`)\
2.  Se agrega al `Map`:

``` java
operacionesBinarias.put("^", new Potencia());
```

Lo bueno es que no hay que modificar las otras operaciones.

Pero igual hay un problema:

-   Hay que tocar el `main` para registrarla\
-   Todo depende de esa clase central

**Conclusión:** Sí se puede extender, pero no del todo bien. Igual se
termina modificando código existente, entonces no se cumple
completamente el OCP.

## 05. ¿Qué pasa si ingreso validaciones de dominio? ¿Dónde irían en este desastre?

Las validaciones ya están dentro de cada operación, por ejemplo:

-   División por cero en `Division`\
-   Raíz de número negativo\
-   Logaritmo de número inválido

Y eso está bien, porque cada operación debería validar lo suyo.

El problema es que:

-   El manejo de errores general está en el `main`\
-   Todo sigue estando muy mezclado

**Conclusión:**

Las validaciones están bien ubicadas, pero el diseño en general sigue
siendo desordenado y difícil de escalar.

## Conclusión General

En general, la clase `Calculadora` tiene varios problemas:

-   Hace demasiadas cosas al mismo tiempo\
-   Hay mucho acoplamiento\
-   No es fácil de extender ni de mantener

Y claramente no cumple bien con principios como:

-   SRP\
-   OCP

Eso sí, el uso de interfaces es un buen inicio. Con eso se podría
reorganizar mejor el código en el futuro y dejarlo mucho más limpio.
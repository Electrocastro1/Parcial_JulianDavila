# Comprensión del diseño — Enunciado B
**Nombre:** Julian Felipe Davila Cortes
**Fecha:** 19-10-2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta: Modelo es abstracta porque es un concepto base que no debe instanciarse directamente; obliga a las subclases a implementar el método entrenar(d:Dataset). Esto garantiza el polimorfismo, permitiendo al sistema ejecutar el entrenamiento de forma uniforme sin importar si la implementación específica es CNN, RNN o Regresión._

---

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta: En la composición, el ciclo de vida está fuertemente atado; si se elimina el Experimento, su Modelo instanciado internamente se destruye de la memoria. En la agregación, la relación es débil; si se destruye la Plataforma, los objetos Experimento que agrupaba pueden seguir existiendo de manera independiente en el sistema._

---

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta: En esta relación, ninguno es dueño absoluto del ciclo de vida del otro. Se modela como asociación N:M porque un investigador coordina múltiples experimentos a lo largo del tiempo, asegurando que si el investigador es eliminado del sistema, el registro histórico del experimento perdure intacto._

---

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta: Se modela como dependencia porque MetricaEvaluacion se utiliza únicamente de forma transitoria para ejecutar el método calcularMetrica(), no como una propiedad del modelo. Pasarlo como parámetro reduce el acoplamiento y permite inyectar diferentes estrategias de cálculo de forma dinámica sin alterar el estado interno de la clase_

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

> _Tu respuesta: int[] lossPorEpoca se elige por su eficiencia de memoria y acceso contiguo, ya que la capacidad del arreglo es fija y se conoce desde la creación mediante maxEpocas. ArrayList<Experimento> se usa en la plataforma porque la cantidad de experimentos crecerá dinámicamente en tiempo de ejecución, requiriendo el algoritmo de redimensionamiento automático de la colección._
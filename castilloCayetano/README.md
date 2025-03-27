# Clase `JugadorMinimax` - Explicación y Funcionamiento

La clase `JugadorMinimax` representa un jugador controlado por una inteligencia artificial (IA) que utiliza el algoritmo **Minimax** para tomar decisiones óptimas en el juego de Tres en Raya. Este jugador hereda de la clase base `Jugador` y sobrescribe los métodos necesarios para colocar y mover fichas en el tablero.

[Algoritmo](https://es.slideshare.net/slideshow/gato-tic-tactoe/13755287) |
[Wiki](https://es.wikipedia.org/wiki/Minimax)

---

## Métodos principales

### 1. `ponerFicha(Tablero tablero)`

Este método coloca una ficha en la mejor posición posible utilizando el algoritmo Minimax para evaluar todas las casillas vacías.

#### Funcionamiento

1. **Iteración sobre las casillas vacías**:
   - Recorre todas las casillas del tablero.
   - Si una casilla está vacía, simula colocar una ficha en esa posición.

2. **Evaluación del movimiento**:
   - Llama al método `minimax` para calcular el valor del movimiento.
   - Elimina la ficha simulada después de evaluar el movimiento.

3. **Selección del mejor movimiento**:
   - Guarda la casilla con el valor más alto calculado por Minimax.
   - Coloca la ficha en la casilla seleccionada.

---

### 2. `moverFicha(Tablero tablero)`

Este método mueve una ficha existente a la mejor posición posible, evaluando todas las combinaciones de fichas y casillas vacías.

#### Funcionamiento

1. **Búsqueda de la mejor ficha para mover**:
   - Recorre todas las casillas ocupadas por las fichas del jugador.
   - Identifica las fichas que pueden ser movidas.

2. **Búsqueda del mejor destino**:
   - Para cada ficha seleccionada, evalúa todas las casillas vacías como posibles destinos.
   - Simula el movimiento y utiliza el algoritmo Minimax para calcular el valor del movimiento.

3. **Ejecución del movimiento**:
   - Realiza el movimiento con la ficha y el destino que tengan el valor más alto.

---

### 3. `minimax(Tablero tablero, int profundidad, boolean esMaximizador)`

El algoritmo Minimax evalúa todas las posibles jugadas futuras para determinar el mejor movimiento actual.

#### Funcionamiento

1. **Condiciones base**:
   - Si hay un ganador (`tablero.hayTresEnRaya()`), devuelve un puntaje:
     - `+10` si el jugador IA gana.
     - `-10` si el oponente gana.
   - Si el tablero está lleno (`tableroEstaLleno()`), devuelve `0` (empate).

2. **Simulación de movimientos**:
   - Si es el turno del jugador IA (`esMaximizador`):
     - Intenta maximizar el puntaje.
   - Si es el turno del oponente:
     - Intenta minimizar el puntaje.

3. **Recursión**:
   - Simula colocar una ficha en cada casilla vacía.
   - Llama recursivamente a `minimax` para evaluar las jugadas futuras.
   - Elimina la ficha simulada después de evaluar.

4. **Devolución del mejor valor**:
   - Devuelve el puntaje máximo o mínimo según el turno.

---

## Métodos auxiliares

### `obtenerColorOponente()`

Devuelve el color del oponente basado en el color del jugador IA:

- Si el jugador IA es `'x'`, el oponente es `'o'`.
- Si el jugador IA es `'o'`, el oponente es `'x'`.

---

### `tableroEstaLleno(Tablero tablero)`

Verifica si todas las casillas del tablero están ocupadas:

- Recorre todas las casillas.
- Si encuentra una casilla vacía, devuelve `false`.
- Si no hay casillas vacías, devuelve `true`.

---

## Ejemplo de flujo del algoritmo Minimax

1. **Turno del jugador IA (`JugadorMinimax`)**:

- Evalúa todas las casillas vacías (`_`).
- Simula colocar una ficha en cada casilla y llama a `minimax`.

2. **Evaluación de jugadas futuras**:

- Para cada movimiento simulado, evalúa las posibles respuestas del oponente.
- Calcula el puntaje de cada jugada.

3. **Selección del mejor movimiento**:

- Elige la casilla que maximiza las posibilidades de ganar o minimiza las del oponente.

4. **Resultado**:

- El jugador IA coloca su ficha en la mejor posición calculada.

---

## Ventajas del algoritmo Minimax

1. **Óptimo**: Siempre encuentra la mejor jugada posible, suponiendo que el oponente también juega de manera óptima.
2. **Generalizable**: Puede aplicarse a otros juegos de tablero con reglas similares.
3. **Determinista**: No depende de la aleatoriedad, lo que lo hace predecible y confiable.

---

## Limitaciones

1. **Complejidad**: Para juegos más grandes, el número de posibles jugadas crece exponencialmente, lo que puede hacer que el algoritmo sea lento.
2. **Empates**: En juegos como Tres en Raya, donde ambos jugadores juegan de manera óptima, el resultado suele ser un empate.

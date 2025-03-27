# v002

## ¡Que sea el Jugador quien gestione sus fichas!

### Clase Tablero

- Ahora el tablero no gestiona fichas, solo el estado de las casillas
- Se simplificó la verificación de victoria
- Métodos para colocar y retirar fichas a partir de objetos Ficha
- Método para verificar si una casilla está ocupada por determinado color

### Clase Jugador

- Ahora cada jugador tiene un array de fichas (3 en total)
- Controla cuántas fichas ha colocado en el tablero
- Gestiona la colocación y movimiento de sus propias fichas
- Puede identificar qué ficha está en una determinada coordenada

### Clase Ficha

- Nueva clase que representa cada ficha individual con su color y posición
- Cada ficha conoce su ubicación en el tablero mediante una coordenada
- Las fichas tienen estados (en tablero o no) y métodos para manipularlos

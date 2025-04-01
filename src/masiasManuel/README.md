# Versiones de TicTacToe

||||
|-|-|-|
Las tres versiones muestran una progresión natural del pensamiento OO: desde modelar lo visible (el tablero) hacia modelar el dominio conceptual (las fichas como objetos)|Se observa una transición gradual desde un enfoque procedural-estructurado (matriz) hacia un enfoque completamente orientado a objetos|Cada versión representa un paradigma diferente de modelado dentro de la programación orientada a objetos

|[Versión 000](/src/masiasManuel/v000/README.md)|[Versión 001](/src/masiasManuel/v001/README.md)|[Versión 002](/src/masiasManuel/v002/README.md)|
|-|-|-|
|La original, hecha y debatida en clase.|Retorcemos la implementación de la clase tablero.|Hacemos al jugador es responsable de sus fichas.|
|El tablero conoce qué hay en cada posición.|El tablero conoce dónde están las fichas de cada jugador.|Cada jugador conoce sus fichas, y cada ficha conoce su posición.|
|[Juego](v000/Juego.java) <br> [TresEnRaya](v000/TresEnRaya.java) <br> [Tablero](v000/Tablero.java) <br> [Jugador](v000/Jugador.java) <br> [Turno](v000/Turno.java) <br> [Coordenada](v000/Coordenada.java)<br><br>|[Juego](v001/Juego.java) <br> [TresEnRaya](v001/TresEnRaya.java) <br> [Tablero](v001/Tablero.java) <br> [Jugador](v001/Jugador.java) <br> [Turno](v001/Turno.java) <br> [Coordenada](v001/Coordenada.java)<br><br>|[Juego](v002/Juego.java) <br> [TresEnRaya](v002/TresEnRaya.java) <br> [Tablero](v002/Tablero.java) <br> [Jugador](v002/Jugador.java) <br> [Turno](v002/Turno.java) <br> [Coordenada](v002/Coordenada.java) <br> [Ficha](v002/Ficha.java)|
|**Punto de partida intuitivo**: Refleja cómo la mayoría de personas pensaría inicialmente en el problema|**Experimentación con estructuras de datos**: Muestra cómo un cambio en la estructura de datos puede transformar radicalmente la implementación|**Aproximación al diseño basado en dominio**: Los objetos del código reflejan entidades del mundo real|
|**Acceso directo a estado**: La matriz proporciona una vista inmediata del estado del juego|**Solución algorítmica innovadora**: El método `direccion()` representa un enfoque matemático elegante|**Mejor encapsulamiento de comportamiento**: Cada ficha conoce y gestiona su propio estado|
|**Mayor cohesión de la clase Tablero**: Toda la lógica relacionada con el estado del juego está en un solo lugar|**Transición de modelo mental**: Comienza a considerar el juego como colecciones de piezas en lugar de un estado de tablero|**Modelo más escalable**: Preparado para posibles extensiones (como diferentes tipos de fichas)|
|**Menor abstracción**: Representa fielmente la estructura física de un tablero de tres en raya|**Desacoplamiento parcial**: Reduce la dependencia entre el tablero y las coordenadas específicas|**Distribución jerárquica de responsabilidades**: Clara cadena de control (juego → jugadores → fichas)|
|||**Comunicación entre objetos más explícita**: La interacción entre componentes modela mejor la realidad del juego|

|Versión|👍|👎|
|-|-|-|
|**v000**| • Simplicidad conceptual: fácil de entender<br>• Representación visual directa del tablero<br>• Menor complejidad de código<br>• Verificación intuitiva de tres en raya<br>• Menor curva de aprendizaje para estudiantes | • No refleja completamente el dominio del problema<br>• Limitada extensibilidad<br>• Mayor acoplamiento entre componentes<br>• Las responsabilidades no están perfectamente distribuidas<br>• Dificultad para añadir nuevas funcionalidades |
|**v001**| • Mayor abstracción del concepto de posición<br>• Permite relaciones espaciales entre coordenadas<br>• Más flexible para reglas complejas<br>• Separación más clara de los datos por jugador<br>• Interesante aproximación algorítmica al problema | • Conceptualmente más complejo<br>• Curva de aprendizaje más pronunciada<br>• Estructura de datos menos intuitiva<br>• Verificación de tres en raya menos directa<br>• Puede ser difícil de mantener con reglas adicionales |
|**v002**| • Mejor representación del dominio<br>• Clara separación de responsabilidades<br>• Mayor encapsulamiento<br>• Más extensible y mantenible<br>• Interfaz más limpia entre componentes | • Mayor cantidad de clases y conceptos<br>• Complejidad estructural adicional<br>• Requiere mejor comprensión de OOP<br>• Potencial sobrecarga de objetos<br>• Mayor overhead de memoria |

## ¿Qué versión elegiría si...?

- ¿Se tuviera que añadir la funcionalidad de "deshacer movimiento"?
- ¿Se quisiera implementar variantes del juego (4x4, 3D)?
- ¿Se necesitara crear una interfaz gráfica para el juego?
- ¿Se tuviera que permitir que interactúen jugadores de tipo IA?

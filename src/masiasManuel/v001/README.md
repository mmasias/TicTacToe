# v001

Cambiaremos la implementación de la clase **Tablero**: en lugar de guardar las fichas en la casilla en la que le corresponda, guardará la posición de las fichas.

```

Jugador 1   | coordenada | coordenada | coordenada |
Jugador 2   | coordenada | coordenada | coordenada |

```

Por tanto, este estado del tablero:

```
_ o _
o _ x
o x _
```

Estaría almacenado así

```
Jugador 1   | (2,1) | (3,1) | (1,2) |
Jugador 2   | (2,3) | (3,2) | null  |

```

Y este estado:

```
x o _
o _ x
o x _
```

sería

```
Jugador 1   | (2,1) | (3,1) | (1,2) |
Jugador 2   | (2,3) | (3,2) | (1,1) |

```

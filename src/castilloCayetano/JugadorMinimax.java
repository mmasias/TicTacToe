package castilloCayetano;

public class JugadorMinimax extends Jugador {
    public JugadorMinimax(char color) {
        super(color);
    }

    @Override
    public void ponerFicha(Tablero tablero) {
        Coordenada mejorMovimiento = obtenerMejorMovimiento(tablero);
        tablero.ponerFicha(mejorMovimiento, this.color());
    }

    private Coordenada obtenerMejorMovimiento(Tablero tablero) {
        int mejorValor = Integer.MIN_VALUE;
        Coordenada mejorMovimiento = null;

        for (int fila = 1; fila <= 3; fila++) {
            for (int columna = 1; columna <= 3; columna++) {
                Coordenada coordenada = new Coordenada(fila, columna);
                if (tablero.estaVacio(coordenada)) {
                    tablero.ponerFicha(coordenada, this.color());
                    int valorMovimiento = minimax(tablero, 0, false);
                    tablero.sacarFicha(coordenada);

                    if (valorMovimiento > mejorValor) {
                        mejorValor = valorMovimiento;
                        mejorMovimiento = coordenada;
                    }
                }
            }
        }
        return mejorMovimiento;
    }

    @Override
    public void moverFicha(Tablero tablero) {
        Coordenada mejorOrigen = encontrarMejorFichaParaMover(tablero);
        Coordenada mejorDestino = encontrarMejorDestinoParaFicha(tablero, mejorOrigen);

        if (mejorOrigen != null && mejorDestino != null) {
            tablero.sacarFicha(mejorOrigen);
            tablero.ponerFicha(mejorDestino, this.color());
        }
    }

    private Coordenada encontrarMejorFichaParaMover(Tablero tablero) {
        for (int fila = 1; fila <= 3; fila++) {
            for (int columna = 1; columna <= 3; columna++) {
                Coordenada origen = new Coordenada(fila, columna);
                if (tablero.estaOcupado(origen) && tablero.obtenerColor(origen) == this.color()) {
                    return origen;
                }
            }
        }
        return null;
    }
    
    private Coordenada encontrarMejorDestinoParaFicha(Tablero tablero, Coordenada origen) {
        Coordenada mejorDestino = null;
        int mejorValor = Integer.MIN_VALUE;
    
        for (int fila = 1; fila <= 3; fila++) {
            for (int columna = 1; columna <= 3; columna++) {
                Coordenada destino = new Coordenada(fila, columna);
                if (tablero.estaVacio(destino)) {

                    tablero.sacarFicha(origen);
                    tablero.ponerFicha(destino, this.color());
                    int valorMovimiento = minimax(tablero, 0, false);
                    tablero.sacarFicha(destino);
                    tablero.ponerFicha(origen, this.color());

                    if (valorMovimiento > mejorValor) {
                        mejorValor = valorMovimiento;
                        mejorDestino = destino;
                    }
                }
            }
        }
        return mejorDestino;
    }

    private int minimax(Tablero tablero, int profundidad, boolean esMaximizador) {
        if (tablero.hayTresEnRaya()) {
            return esMaximizador ? -10 + profundidad : 10 - profundidad;
        }

        if (tableroEstaLleno(tablero)) {
            return 0;
        }

        int mejorValor = esMaximizador ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int fila = 1; fila <= 3; fila++) {
            for (int columna = 1; columna <= 3; columna++) {
                Coordenada coordenada = new Coordenada(fila, columna);
                if (tablero.estaVacio(coordenada)) {
                    tablero.ponerFicha(coordenada, esMaximizador ? this.color() : obtenerColorOponente());
                    int valorMovimiento = minimax(tablero, profundidad + 1, !esMaximizador);
                    tablero.sacarFicha(coordenada);

                    mejorValor = esMaximizador
                            ? Math.max(mejorValor, valorMovimiento)
                            : Math.min(mejorValor, valorMovimiento);
                }
            }
        }
        return mejorValor;
    }

    private char obtenerColorOponente() {
        return this.color() == 'x' ? 'o' : 'x';
    }

    private boolean tableroEstaLleno(Tablero tablero) {
        for (int fila = 1; fila <= 3; fila++) {
            for (int columna = 1; columna <= 3; columna++) {
                if (tablero.estaVacio(new Coordenada(fila, columna))) {
                    return false;
                }
            }
        }
        return true;
    }
}


public class TresEnRaya {

        private Tablero tablero;
        private static final int[] DIMENSIONES = { 3, 3 };

        private Jugador[] jugadores;
        private final int NUMERO_JUGADORES = 2;
        private final char[] SIMBOLO_FICHAS = { 'X', 'O' };
        private final int FICHAS_POR_JUGADOR = 3;

        private Turno turno;

        public TresEnRaya() {
                tablero = new Tablero(DIMENSIONES, SIMBOLO_FICHAS);

                jugadores = new Jugador[NUMERO_JUGADORES];
                for (int i = 0; i < jugadores.length; i++) {
                        jugadores[i] = new Jugador("Jugador " + (i + 1), i);
                }

                turno = new Turno(jugadores);
        }

        public void jugar() {
                repartirFichas();
                do {
                        tablero.mostrar();

                        if (jugadores[turno.getJugador()].noTieneFichas()) {
                                System.out.println(jugadores[turno.getJugador()].getNombre() + " no tiene más fichas. Mueva una del tablero.");
                                tablero.cogerFicha(jugadores[turno.getJugador()]);
                                tablero.mostrar();
                        }
                        tablero.colocarFicha(jugadores[turno.getJugador()]);

                        turno.siguienteJugador();
                } while (!hayTresEnRaya(tablero));
                tablero.mostrar();
                System.out.println("¡¡¡" + jugadores[turno.getJugador()].getNombre() + " ha ganado!!!");
        }

        private void repartirFichas() {
                for (int i = 0; i < jugadores.length; i++) {
                        jugadores[i].setFichasEnMano(FICHAS_POR_JUGADOR);
                }
        }

        private boolean hayTresEnRaya(Tablero tablero) {
                return hayFila(tablero) || hayColumna(tablero) || hayDiagonal(tablero);
        }

        private boolean hayFila(Tablero tablero) {
                for (int i = 0; i < tablero.getFilas(); i++) {
                        boolean hayFila = tablero.getFicha(i, 0) != tablero.getFormaVacia()
                                        && tablero.getFicha(i, 0) == tablero.getFicha(i, 1)
                                        && tablero.getFicha(i, 1) == tablero.getFicha(i, 2);
                        if (hayFila)
                                return true;
                }
                return false;
        }

        private boolean hayColumna(Tablero tablero) {
                for (int i = 0; i < tablero.getColumnas(); i++) {
                        boolean hayColumna = tablero.getFicha(0, i) != tablero.getFormaVacia()
                                        && tablero.getFicha(0, i) == tablero.getFicha(1, i)
                                        && tablero.getFicha(1, i) == tablero.getFicha(2, i);
                        if (hayColumna) {
                                return true;
                        }
                }
                return false;
        }

        private boolean hayDiagonal(Tablero tablero) {
                boolean primeraDiagonal = tablero.getFicha(0, 0) != tablero.getFormaVacia()
                                && tablero.getFicha(0, 0) == tablero.getFicha(1, 1)
                                && tablero.getFicha(1, 1) == tablero.getFicha(2, 2);
                boolean segundaDiagonal = tablero.getFicha(0, 2) != tablero.getFormaVacia()
                                && tablero.getFicha(0, 2) == tablero.getFicha(1, 1)
                                && tablero.getFicha(1, 1) == tablero.getFicha(2, 0);
                return primeraDiagonal || segundaDiagonal;
        }

}

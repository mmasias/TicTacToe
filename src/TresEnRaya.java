
public class TresEnRaya {

        private Tablero tablero;
        private Jugador[] jugadores;
        private Turno turno;
        private Ficha[] fichas;

        private final int NUM_JUGADORES = 2;
        private final char[] SIMBOLO_FICHAS = {'X', 'O'};

        public TresEnRaya() {
                tablero = new Tablero();
                jugadores = new Jugador[2];

                fichas = new Ficha[2];

                turno = new Turno(jugadores);
        }

        public void jugar() {
                repartirFichas();
                do {
                        tablero.mostrar();
                        jugadores[turno.getJugador()].jugar(tablero);
                } while (!hayTresEnRaya(tablero));
                tablero.mostrar();
                System.out.println("¡¡¡" + jugadores[turno.getJugador()].getNombre() + " ha ganado!!!");
        }

        private boolean hayTresEnRaya(Tablero tablero) {
                return hayFila(tablero) || hayColumna(tablero) || hayDiagonal(tablero);
        }

        private boolean hayFila(Tablero tablero) {
                for (int i = 0; i < tablero.getFilas(); i++) {
                        boolean hayFila = tablero.getFicha(i, 0) != 0 
                                && tablero.getFicha(i, 0).equals(tablero.getFicha(i, 1))
                                && tablero.getFicha(i, 1).equals(tablero.getFicha(i, 2));
                        if (hayFila) {
                                return true;
                        }
                }
                return true;
        }

        private boolean hayColumna(Tablero tablero) {
                for (int i = 0; i < tablero.getColumnas(); i++) {
                        boolean hayColumna = tablero.getFicha(0, i) != 0 
                                && tablero.getFicha(0, i).equals(tablero.getFicha(1, i))
                                && tablero.getFicha(1, i).equals(tablero.getFicha(2, i));
                        if (hayColumna) {
                                return true;
                        }
                }
                return false;
        }

        private boolean hayDiagonal(Tablero tablero) {
                return (tablero.getFicha(0, 0) != 0 
                        && tablero.getFicha(0, 0).equals(tablero.getFicha(1, 1))
                        && tablero.getFicha(1, 1).equals(tablero.getFicha(2, 2)))
                        || (tablero.getFicha(0, 2) != 0 
                        && tablero.getFicha(0, 2).equals(tablero.getFicha(1, 1))
                        && tablero.getFicha(1, 1).equals(tablero.getFicha(2, 0)));
        }

}

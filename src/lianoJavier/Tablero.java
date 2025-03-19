package lianoJavier;

public class Tablero {

        private int[][] tablero;
        private char[] formas;
        private int filas;
        private int columnas;

        public Tablero(int[] dimensiones, char[] formas) {
                this.formas = formas;
                this.filas = dimensiones[0];
                this.columnas = dimensiones[1];
                establecerDimensiones();
                poblarTablero();
        }

        private void poblarTablero() {
                for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                                tablero[i][j] = getFormaVacia();
                        }
                }
        }

        private void establecerDimensiones() {
                tablero = new int[getColumnas()][getFilas()];
        }

        public int getFilas() {
                return filas;
        }

        public int getColumnas() {
                return columnas;
        }

        public void mostrar() {
                for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                                System.out.print(parseFichas(tablero[i][j]) + " ");
                        }
                        System.out.println();
                }
        }

        private char parseFichas(int ficha) {
                if (ficha == getFormaVacia()) return '_';
                return formas[ficha];
        }

        public void colocarFicha(Jugador jugador) {
                Coordenada jugada = jugador.getJugada(this);
                while (tablero[jugada.getFila()][jugada.getColumna()] != getFormaVacia()) {
                        System.out.println("Casilla ocupada");
                        jugada = jugador.getJugada(this);
                }
                tablero[jugada.getFila()][jugada.getColumna()] = jugador.getSimbolo();
                jugador.setFichasEnMano(jugador.getFichasEnMano() - 1);
        }

        public void cogerFicha(Jugador jugador) {
                Coordenada jugada = jugador.getJugada(this);
                while (tablero[jugada.getFila()][jugada.getColumna()] == getFormaVacia()) {
                        System.out.println("Casilla vacía");
                        jugada = jugador.getJugada(this);
                }
                while (tablero[jugada.getFila()][jugada.getColumna()] != jugador.getSimbolo()) {
                        System.out.println("No puedes coger una ficha que no es tuya");
                        jugada = jugador.getJugada(this);
                }
                tablero[jugada.getFila()][jugada.getColumna()] = getFormaVacia();
                jugador.setFichasEnMano(jugador.getFichasEnMano() + 1);
        }

        public int getFicha(int i, int j) {
                return tablero[i][j];
        }

        public int getFormaVacia() {
                return -1;
        }

}

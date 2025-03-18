
public class Tablero {
        private int[][] tablero;
        private int filas;
        private int columnas;

        public void setDimensiones(int filas, int columnas) {
                this.filas = filas;
                this.columnas = columnas;
                formarTablero();
        }

        private void formarTablero() {
                tablero = new int[filas][columnas];
                for (int fila = 0; fila < filas; fila++) {
                        for (int columna = 0; columna < columnas; columna++) {
                                tablero[fila][columna] = -1;
                        }
                }
        }

        public void mostrar() {
                for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                                System.out.print(tablero[i][j] + " ");
                        }
                        System.out.println();
                }
        }

        public void ponerFicha(int fila, int columna, int jugador) {
                tablero[fila][columna] = jugador;
        }

        public void cogerFicha(int fila, int columna, int jugador) {
                assert tablero[fila][columna] == jugador : "No puedes coger una ficha que no es tuya";

                tablero[fila][columna] = -1;
        }

}

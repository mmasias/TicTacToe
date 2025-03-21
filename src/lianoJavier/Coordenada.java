package lianoJavier;

import java.util.Scanner;

public class Coordenada {

        private int fila;
        private int columna;

        private Scanner scanner = new Scanner(System.in);

        public Coordenada(int fila, int columna) {
                this.fila = fila;
                this.columna = columna;
        }

        public int getFila() {
                return fila;
        }

        public int getColumna() {
                return columna;
        }

        public void setFila(int fila) {
                this.fila = fila;
        }

        public void setColumna(int columna) {
                this.columna = columna;
        }

        public int pedir(Tablero tablero, int[] rango) {
                int coordenada;
                boolean isCoordenadaFueraDeRango;
                do {
                        coordenada = preguntarInt("Introduce la fila: ");
                        isCoordenadaFueraDeRango = coordenada < rango[0] || coordenada >= rango[1];
                        if (isCoordenadaFueraDeRango) System.out.println("Fila incorrecta. Debe ser entre 1 y " + (tablero.getFilas()));
                } while (isCoordenadaFueraDeRango);
                return coordenada;
        }

        private int preguntarInt(String string) {
                System.out.print(string);
                return scanner.nextInt() - 1;
        }

}

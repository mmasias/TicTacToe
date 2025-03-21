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

        public Coordenada() {
                this.fila = 0;
                this.columna = 0;
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

        public void pedir() {
                System.out.println("Introduce la fila y la columna donde quieres poner la ficha");
                fila = preguntarInt("Fila: ");
                columna = preguntarInt("Columna: ");
        }

        private int preguntarInt(String string) {
                System.out.print(string);
                return scanner.nextInt() - 1;
        }

}

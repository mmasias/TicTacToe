import java.util.Scanner;


public class Coordenadas {

        private int fila;
        private int columna;

        public void pedirCoordenadas() {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Introduce la fila: ");
                fila = scanner.nextInt();
                System.out.print("Introduce la columna: ");
                columna = scanner.nextInt();
                System.out.println("Fila: " + fila + ", Columna: " + columna);

                scanner.close();
        }

        public int getFila() {
                return fila;
        }

        public int getColumna() {
                return columna;
        }

}

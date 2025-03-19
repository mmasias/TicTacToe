package lianoJavier;
import java.util.Scanner;

public class Jugador {

        private String nombre;
        private int simbolo;
        private int fichasEnMano;
        private Scanner scanner = new Scanner(System.in);

        public Jugador(String nombre, int simbolo) {
                this.nombre = nombre;
                this.simbolo = simbolo;
        }

        public boolean noTieneFichas() {
                return fichasEnMano == 0;
        }

        public Coordenada getJugada(Tablero tablero) {
                int Fila;
                boolean isFilaFueraDeRango;
                do {
                        Fila = preguntarInt("Introduce la fila: ");
                        isFilaFueraDeRango = Fila < 0 || Fila >= tablero.getFilas();
                        if (isFilaFueraDeRango) System.out.println("Fila incorrecta. Debe ser entre 1 y " + (tablero.getFilas()));
                } while (isFilaFueraDeRango);

                int Columna;
                boolean isColumnaFueraDeRango;
                do {
                        Columna = preguntarInt("Introduce la columna: ");

                        isColumnaFueraDeRango = Columna < 0 || Columna >= tablero.getColumnas();
                        if (isColumnaFueraDeRango) System.out.println("Columna incorrecta. Debe ser entre 1 y " + (tablero.getColumnas()));
                } while (isColumnaFueraDeRango);
                return new Coordenada(Fila, Columna);
        }

        private int preguntarInt(String string) {
                System.out.print(string);
                return scanner.nextInt() - 1;
        }

        public int getFichasEnMano() {
                return fichasEnMano;
        }

        public void setFichasEnMano(int fichasPorJugador) {
                this.fichasEnMano = fichasPorJugador;
        }

        public int getSimbolo() {
                return simbolo;
        }

        public String getNombre() {
                return nombre;
        }

}

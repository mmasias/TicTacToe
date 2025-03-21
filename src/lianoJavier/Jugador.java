package lianoJavier;
import java.util.Scanner;

public class Jugador {

        final int[] COORDENADA_BASE = {0,1};

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
                int fila = pedirCoordenada(tablero, new int[]{COORDENADA_BASE[0],tablero.getFilas()});
                int columna = pedirCoordenada(tablero, new int[]{COORDENADA_BASE[1],tablero.getFilas()});
                return new Coordenada(fila, columna);
        }

        private int pedirCoordenada(Tablero tablero, int[] rango) {
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

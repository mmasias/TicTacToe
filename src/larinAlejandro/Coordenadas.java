import java.util.Scanner;

public class Coordenadas {
    private int fila;
    private int columna;
    private final char[][] tablero;
    private final char ficha;
    private final Scanner scanner;

    public Coordenadas(char[][] tablero, char ficha) {
        this.tablero = tablero;
        this.ficha = ficha;
        this.scanner = new Scanner(System.in);
    }

    private void pedirCoordenadas() {
        do {
            System.out.print("Introduce la fila (1-" + tablero.length + "): ");
            fila = scanner.nextInt() - 1;

            System.out.print("Introduce la columna (1-" + tablero[0].length + "): ");
            columna = scanner.nextInt() - 1;
        } while (!coordenadaValida(fila, columna));
    }

    public void colocarFicha() {
        do {
            pedirCoordenadas();
        } while (!celdaVacia(fila, columna));
        
        tablero[fila][columna] = ficha;
    }

    public void moverFicha() {
        do {
            System.out.println("Selecciona la ficha que deseas mover:");
            pedirCoordenadas();
        } while (!fichaPertenece());

        removerFicha();

        do {
            System.out.println("Selecciona la nueva posición para tu ficha:");
            pedirCoordenadas();
        } while (!celdaVacia(fila, columna));

        tablero[fila][columna] = ficha;
    }

    private void removerFicha() {
        tablero[fila][columna] = '_';
    }

    private boolean celdaVacia(int fila, int columna) {
        if (tablero[fila][columna] != '_') {
            System.out.println("Error: La celda ya está ocupada. Intenta de nuevo.");
            return false;
        }
        return true;
    }

    private boolean fichaPertenece() {
        if (tablero[fila][columna] != ficha) {
            System.out.println("Error: No puedes mover una ficha que no te pertenece.");
            return false;
        }
        return true;
    }

    private boolean coordenadaValida(int fila, int columna) {
        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length) {
            System.out.println("Error: Coordenadas fuera de rango. Intenta de nuevo.");
            return false;
        }
        return true;
    }

    public void cerrarScanner() {
        scanner.close();
    }
}

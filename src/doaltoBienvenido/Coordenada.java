package doaltoBienvenido;

import java.util.Scanner;

public class Coordenada {

    private int fila;
    private int columna;
    private final int FILA_MINIMA = 0;
    private final int FILA_MAXIMA = 3;
    private final int COLUMNA_MINIMA = 0;
    private final int COLUMNA_MAXIMA = 3;

    public Coordenada() {

    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int fila() {
        return fila;
    }

    public int columna() {
        return columna;
    }

    public void fila(int fila) {
        this.fila = fila;
    }

    public void columna(int columna) {
        this.columna = columna;
    }

    public String toString() {
        return fila + " , " + columna;
    }

    public boolean esValida() {
        return fila >= FILA_MINIMA && fila < FILA_MAXIMA && columna >= COLUMNA_MINIMA && columna < COLUMNA_MAXIMA;
    }

    public void pedir() {
        Scanner scanner = new Scanner(System.in);
        boolean esCordenadaValida;

        do {
            System.out.println("Escriba una fila desde (0-2): ");
            fila = scanner.nextInt();

            System.out.println("Escriba una columna desde (0-2): ");
            columna = scanner.nextInt();

            esCordenadaValida = esValida();
            if (!esCordenadaValida) {
                System.out.println("Coordenada incorrecta");
            }
        } while (!esCordenadaValida);
    }
}

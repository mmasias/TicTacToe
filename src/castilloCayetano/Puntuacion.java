package castilloCayetano;

public class Puntuacion {

    private int[] puntos;

    public Puntuacion() {
        puntos = new int[2];
    }

    public void incrementar(int jugador) {
        puntos[jugador]++;
    }

    public void mostrar() {
        System.out.println("Puntuación:");
        System.out.println("Jugador 1 (x): " + puntos[0]);
        System.out.println("Jugador 2 (o): " + puntos[1]);
    }
}
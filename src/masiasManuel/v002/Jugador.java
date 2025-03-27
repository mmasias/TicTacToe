package v002;

public class Jugador {

    private char color;
    private Ficha[] fichas;
    private int fichasColocadas;
    private static final int TOTAL_FICHAS = 3;

    public Jugador(char color) {
        this.color = color;
        this.fichas = new Ficha[TOTAL_FICHAS];
        this.fichasColocadas = 0;
        for (int i = 0; i < TOTAL_FICHAS; i++) {
            this.fichas[i] = new Ficha(color);
        }
    }

    public void jugar(Tablero tablero) {
        if (fichasColocadas < TOTAL_FICHAS) {
            colocarFicha(tablero);
        } else {
            moverFicha(tablero);
        }
    }

    private void colocarFicha(Tablero tablero) {
        System.out.println("Jugador " + color + " coloca una ficha");
        Coordenada coordenada = new Coordenada();
        do {
            coordenada.pedir();
        } while (tablero.estaOcupado(coordenada));

        Ficha ficha = fichas[fichasColocadas];
        ficha.setCoordenda(coordenada);
        tablero.ponerFicha(ficha);
        fichasColocadas++;
    }

    private void moverFicha(Tablero tablero) {
        System.out.println("Jugador " + color + " mueve una ficha");

        Coordenada origen = new Coordenada();
        do {
            System.out.println("Seleccione la " + color + " a mover:");
            origen.pedir();
        } while (!tablero.estaOcupadoPor(origen, color));

        Ficha fichaAMover = getFichaEn(origen);
        tablero.sacarFicha(fichaAMover);

        Coordenada destino = new Coordenada();
        do {
            System.out.println("Seleccione la nueva posición de " + color + ":");
            destino.pedir();
        } while (tablero.estaOcupado(destino));

        fichaAMover.setCoordenda(destino);
        tablero.ponerFicha(fichaAMover);
    }

    private Ficha getFichaEn(Coordenada coordenada) {
        int i = 0;
        while (!fichas[i].estaEn(coordenada)) {
            i++;
        }
        return fichas[i];
    }

    public void celebrar() {
        System.out.println("¡El jugador " + color + " ha ganado!");
    }

    public char getColor() {
        return color;
    }

    public boolean tieneTodasFichasColocadas() {
        return fichasColocadas == TOTAL_FICHAS;
    }
}
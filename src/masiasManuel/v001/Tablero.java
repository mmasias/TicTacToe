package v001;

class Tablero {

    private Coordenada[][] fichas;

    private final int DIMENSION = 3;
    private final int JUGADORES = 2;
    private final char VACIA = '_';

    public Tablero() {
        fichas = new Coordenada[JUGADORES][DIMENSION];
    }

    public void mostrar() {
        cleanScreen();
        System.out.println("  1 2 3");
        for (int i = 1; i <= DIMENSION; i++) {
            System.out.print((i+1) + " ");
            for (int j = 1; j <= DIMENSION; j++) {
                System.out.print(this.getColor(new Coordenada(i, j)) + " ");
            }
            System.out.println();
        }
    }

    private char getColor(Coordenada coordenada) {
        if (this.estaOcupado(coordenada, 'x')) {
            return 'x';
        } else if (this.estaOcupado(coordenada, 'o')) {
            return 'o';
        }
        return VACIA;
    }

    private boolean estaOcupado(Coordenada coordenada, char color) {
        int fila = this.getFila(color);
        for (int i = 0; i < fichas[fila].length; i++) {
            if (fichas[fila][i] != null && fichas[fila][i].igual(coordenada)) {
                return true;
            }
        }
        return false;
    }

    private int getFila(char color) {
        if (color == 'o') {
            return 0;
        }
        return 1;
    }

    public boolean estaCompleto(Jugador jugador) {
        return estaCompleto(jugador.color());
    }

    private boolean estaCompleto(char color) {
        int fila = getFila(color);
        int conteoFichas = 0;
        for (int i = 0; i < fichas[fila].length; i++) {
            if (fichas[fila][i] != null) {
                conteoFichas++;
            }
        }
        return conteoFichas == DIMENSION;
    }

    public boolean hayTresEnRaya() {
        return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
    }

    private boolean hayTresEnRaya(char color) {
        if (!estaCompleto(color)) {
            return false;
        }
        int fila = getFila(color);
        int direccion = fichas[fila][0].direccion(fichas[fila][1]);
        if (direccion == -1) {
            return false;
        }
        return direccion == fichas[fila][1].direccion(fichas[fila][2]);

    }

    public void ponerFicha(Coordenada coordenada, char color) {
        int fila = getFila(color);
        int i = 0;
        while (fichas[fila][i] != null) {
            i++;
        }
        fichas[fila][i] = coordenada;
    }

    public boolean estaVacio(Coordenada coordenada) {
        return !estaOcupado(coordenada);
    }

    public boolean estaOcupado(Coordenada coordenada) {
        return this.estaOcupado(coordenada, 'x') || this.estaOcupado(coordenada, 'o');
    }

    public void sacarFicha(Coordenada coordenada) {
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                if (fichas[i][j] != null && fichas[i][j].igual(coordenada)) {
                    fichas[i][j] = null;
                }
            }
        }
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

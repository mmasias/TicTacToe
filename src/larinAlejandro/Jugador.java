
class Jugador {
    private final char ficha;
    private final char[][] tablero;
    private final Coordenadas coordenadas;
    private int fichasColocadas = 0;

    public Jugador(char ficha, char[][] tablero) {
        this.tablero = tablero;
        this.ficha = ficha;
        this.coordenadas = new Coordenadas(this.tablero, this.ficha);
    }

    public void juegaTurno() {
        if (seAcabaronLasFichas()) {
            coordenadas.moverFicha();
        } else {
            colocarFicha();
        }
    }

    private void colocarFicha() {
        coordenadas.colocarFicha();
        fichasColocadas++; 
    }

    private boolean seAcabaronLasFichas() {
        return fichasColocadas >= 3;
    }
    
    public char getFicha() {
        return ficha;
    }
}

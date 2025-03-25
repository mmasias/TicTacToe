
public class Jugadores {

    private final Jugador[] jugadores;
    private final char[][] tablero;
    private int turnoActual;

    public Jugadores(char[][] tablero) {
        this.tablero = tablero;
        this.jugadores = new Jugador[]{
            new Jugador('X', this.tablero),
            new Jugador('O', this.tablero)
        };
        this.turnoActual = turnoRandom();
    }

    public void juegan() {
        Jugador jugador = jugadores[turnoActual];

        mostrarTurno();
        jugador.juegaTurno();
        cambiarTurno();
    }

    private void mostrarTurno() {
        System.out.println("Turno del jugador con las fichas " + getTurnoActual());
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual + 1) % 2;
    }

    private int turnoRandom() {
        return turnoActual = (int) (Math.random() * 2);
    }

    public char getTurnoActual() {
        return jugadores[turnoActual].getFicha();
    }

    public char getTurnoNoActual() {
        cambiarTurno();
        return getTurnoActual();
    }

}

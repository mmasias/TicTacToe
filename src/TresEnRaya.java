
public class TresEnRaya {

        private Jugador[] jugadores;
        private Turno turno;
        private Tablero tablero;

        public TresEnRaya() {
                jugadores = new Jugador[2];
                for (int i = 0; i < jugadores.length; i++) {
                        jugadores[i] = new Jugador();
                }
                turno = new Turno();
                tablero = new Tablero();
                tablero.setDimensiones(3, 3);
        }

        public void jugar() {
                System.out.println("Jugando a Tres en Raya");

                for (Jugador jugador : jugadores) {
                        jugador.repartirFichas(3);
                }

                tablero.mostrar();
                Jugador jugadorActual = jugadores[turno.getJugador()];
                if (jugadorActual.getFichasEnMano() == 0) jugadorActual.cogerFicha();
                jugadorActual.ponerFicha();
                turno.siguiente();
        }

}

public class Turno {

        private int numeroJugadores;
        private int jugadorActual;

        public Turno(Jugador[] jugadores) {
                this.numeroJugadores = jugadores.length;
        }

        public int getJugador() {
                return jugadorActual;
        }

        public void siguienteJugador() {
                jugadorActual = (jugadorActual + 1) % numeroJugadores;
        }

}

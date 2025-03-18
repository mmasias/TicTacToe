
public class Jugador {

        private int fichasEnMano;
        private Tablero tablero;
        private Turno turno;
        private Coordenadas coordenadas;

        public Jugador() {
                tablero = new Tablero();
                turno = new Turno();
                coordenadas = new Coordenadas();
        }

        public int getFichasEnMano() {
                return fichasEnMano;
        }

        public void cogerFicha() {
                coordenadas.pedirCoordenadas();

                tablero.cogerFicha(coordenadas.getFila(), coordenadas.getColumna(), turno.getJugador());

                fichasEnMano++;
        }

        public void ponerFicha() {
                coordenadas.pedirCoordenadas();

                tablero.ponerFicha(coordenadas.getFila(), coordenadas.getColumna(), turno.getJugador());

                fichasEnMano--;
        }

        public void repartirFichas(int numeroFichas) {
                this.fichasEnMano = numeroFichas;
        }


}

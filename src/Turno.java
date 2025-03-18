
public class Turno {

        private int turnosMaximos;
        private int turno;

        public Turno() {
                turno = 0;
        }

        public void setJugadores(int numeroJugadores) {
                this.turnosMaximos = numeroJugadores;
        }

        public void siguiente() {
                turno++;
                turno = turno % turnosMaximos;
        }

        public int getJugador() {
                return turno;
        }

}

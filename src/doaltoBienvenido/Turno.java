package doaltoBienvenido;

public class Turno {

    private int turnoActual;

    public Turno(){
        turnoActual = (int) (Math.random() * 2) ;
    }

    public void cambiar() {
        turnoActual = (turnoActual + 1) % 2;
    }
    
    public int leToca() {
        return turnoActual;
    }

    public int noLeToca() {
        return (turnoActual + 1) % 2;
    }

}

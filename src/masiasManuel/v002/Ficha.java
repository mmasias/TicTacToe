package v002;

public class Ficha {
    
    private char color;
    private Coordenada coordenada;
    private boolean enTablero;
    
    public Ficha(char color) {
        this.color = color;
        this.enTablero = false;
    }
    
    public char getColor() {
        return color;
    }
    
    public Coordenada getCoordenada() {
        return coordenada;
    }
    
    public void setCoordenda(Coordenada coordenada) {
        this.coordenada = coordenada;
        this.enTablero = true;
    }
    
    public boolean estaEnTablero() {
        return enTablero;
    }
    
    public void retirarDeTablero() {
        this.enTablero = false;
    }
    
    public boolean estaEn(Coordenada coordenada) {
        if (!enTablero) {
            return false;
        }
        return this.coordenada.igual(coordenada);
    }
}
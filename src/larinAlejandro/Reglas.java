public class Reglas {
    private final char[][] tablero;
    private final int filas;
    private final int columnas;

    public Reglas(char[][] tablero) {
        this.tablero = tablero;
        this.filas = tablero.length;
        this.columnas = tablero[0].length;
    }

    public boolean verificarFilas() {
        for (int i = 0; i < filas; i++) {
            if (tablero[i][0] != '_' && tablero[i][0] == tablero[i][1] && 
                tablero[i][1] == tablero[i][2]) {
                return true; 
            }
        }
        return false; 
    }

    public boolean verificarColumnas() {
        for (int j = 0; j < columnas; j++) {
            if (tablero[0][j] != '_' && tablero[0][j] == tablero[1][j] && 
                tablero[1][j] == tablero[2][j]) {
                return true; 
            }
        }
        return false; 
    }

    public boolean verificarDiagonalPrincipal() {
        return tablero[0][0] != '_' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2];
    }

    public boolean verificarDiagonalSecundaria() {
        return tablero[0][2] != '_' &&  tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]; 
    }
}
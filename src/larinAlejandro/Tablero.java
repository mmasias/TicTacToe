public class Tablero{
    private final char[][] tablero;
    private final int filas;
    private final int columnas;
    
    public Tablero(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new char[filas][columnas];
        crearTablero();

    }

    private void crearTablero(){
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                tablero[i][j] = '_';
            }
        }
    }

    public void mostrar(){
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public char[][] getTablero(){
        return tablero;
    }


}
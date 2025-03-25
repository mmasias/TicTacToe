class TresEnRaya {
    private final Tablero tablero;
    private final Jugadores jugadores;  
    private final Reglas reglas;

    private final int  FILAS = 3;
    private final int  COLUMNAS = 3;

    public TresEnRaya() {
       this.tablero = new Tablero(FILAS, COLUMNAS);
       this.jugadores = new Jugadores(this.tablero.getTablero());
       this.reglas = new Reglas(this.tablero.getTablero());
    }
    
    public void jugar() {
        do {
            actualizar();
            tablero.mostrar();
            jugadores.juegan();
        } while (!hayTresEnraya());

        celebrar();
    }

    private void celebrar() {
        tablero.mostrar();
        String celebrar = "Ha ganado el jugador con las fichas " + jugadores.getTurnoNoActual();
        System.out.println(celebrar);
    }
    
    private boolean hayTresEnraya() {
        return reglas.verificarFilas() || reglas.verificarColumnas() || reglas.verificarDiagonalPrincipal() || reglas.verificarDiagonalSecundaria();
    }

    private void actualizar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

  
}

  
public class Juego {

    private Player p1,p2;
    char[][] tablero;

    Juego(){
        tablero = new char[6][6];
        p1.setTurn('X');
        p2.setTurn('O');
    }
    Juego(Player p1 , Player p2){
        this.p1 = p1;
        this.p2 = p2;
        tablero = new char[6][6];
        p1 = new Player();
        p2 = new Player();

    }

    public void CargarTableroInicial(){
        System.out.println("---------------------------------------------");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = ' ';
                System.out.print(" [" + tablero[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    public void CargarTablero(int col, Player oP){
        System.out.println("---------------------------------------------");
        movimiento(col,oP);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(" [" + tablero[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    public boolean validar(int row,int col){
        if(tablero[row][col] == 'X' || tablero[row][col] == 'O'){
            System.out.println("Ese casillero esta ocupado");
            return false;
        }
        else
            return true;

    }

    public void movimiento(int col, Player oP){

        for (int i = 5; i >= 5; i--) {

            if(i == 0){
                tablero[0][col] = oP.getTurn();
            }
            else{
                tablero[i - FilasOcupadas(col)][col] = oP.getTurn();
            }


        }


    }

    public int FilasOcupadas(int col){
        int filasOcupadas = 0;
        for (int i = 0; i < 6 ; i++) {
            if(tablero[i][col] == 'X' || tablero[i][col] == 'O'){
                filasOcupadas = 6 - i;
                break;
            }
        }
        return filasOcupadas;
    }


    public boolean Ganador(Player oP){

        // Verificar si hay una fila completa del jugador actual
        for (int i = 0; i < tablero.length; i++) {
            int contador = 0;
            contador = 0;
            for (int j = 0; j <= 2; j++) {
                if (tablero[i][0 + contador] == oP.getTurn() && tablero[i][1 + contador] == oP.getTurn()
                        && tablero[i][2 + contador] == oP.getTurn() && tablero[i][3 + contador] == oP.getTurn()) {
                    return true;
                }
                contador++;
            }

        }

        // Verificar si hay una columna completa del jugador actual
        for (int j = 0; j < 6; j++) {
            int contador = 0;
            contador = 0;
            for (int i = 0; i <= 2; i++) {
                if (tablero[0 + contador][j] == oP.getTurn() && tablero[1 + contador][j] == oP.getTurn()
                        && tablero[2 + contador][j] == oP.getTurn() && tablero[3 +contador][j] == oP.getTurn()) {
                    return true;
                }
                contador++;
            }

        }

        // Verificar si hay una diagonal completa del jugador actual


        return false;

    }


    public boolean GandorDiagonal(int col, Player oP){

        int contIzq = 0;
        //SI LA SUMA DE LA COLUMNA Y FILA DA IGUAL A LA ULTIMA FILA DONDE SE ECUENTRE EL TURNO ES DIAGONAL IZQUIERDA
        for (int i = 0; i < tablero.length; i++) {
            if(i + col == 3 || i + col == 4 || i + col == 5  || i + col == 6 || i + col == 7){
                if (tablero[i][col] == oP.getTurn()){
                    contIzq++;
                }

            }
        }

        if(contIzq == 4){
            return true;
        }
        return false;
    }


    public boolean Empate(){
        int casillasVacias = 36;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablero[i][j] == 'X' || tablero[i][j] == '0' ) {
                    casillasVacias--;
                }
            }
        }
        // Verificar si hay un empate
        if (casillasVacias == 0) {
            return true;
        }
        return false;
    }


}

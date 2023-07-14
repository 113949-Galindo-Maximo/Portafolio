import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Practica Parcial 1 - TA TE TI.");
        Scanner scan = new Scanner(System.in);
        int iniciar = 1;
        Player p1, p2, pActual,pGanador,pIniciador;
        p1 = new Player();
        p2 = new Player();
        pActual =  new Player();
        pGanador =  new Player();
        pIniciador = new Player();
        int row = 0;
        int col = 0;

        p1.setTurn('X');
        p2.setTurn('O');
        Juego juego = new Juego(p1,p2);

        pActual = p1;

       /* System.out.println("Jugador 1 dime tu nombre");
        p1.setName(scan.nextLine());
        System.out.println("Jugador 2 dime tu nombre");
        p2.setName(scan.nextLine());*/

        p1.setName("m");
        p2.setName("i");
        juego.CargarTableroInicial();
        while (iniciar == 1){



            //pIniciador = pActual;

            //while(juego.Ganador(pActual) == false && juego.Empate() == false && juego.GandorDiagonal(row,col,pActual) == false ){

                //do{
                    System.out.println( pActual.getName() + " columna de tu movimiento");
                    System.out.println("Col: ");
                    col = Integer.parseInt(scan.nextLine());

                //}while(juego.validar(row,col) == false);

                juego.CargarTablero(col,pActual);
                //juego.movimiento(col,pActual);

                if(juego.Ganador(pActual) == false && juego.Empate() == false  && juego.GandorDiagonal(col,pActual) == false ){
                    if(pActual == p1) pActual= p2;
                    else if(pActual == p2) pActual = p1;
                }

            //}

            if(juego.Ganador(pActual) || juego.GandorDiagonal(col,pActual) ){
                System.out.println("El ganador es " + pActual.getName());
                pGanador = pActual;
                pGanador.setPoints(+3);
                pGanador.setGameWins(+1);
                if(pIniciador != pGanador) pGanador.setPoints(+1);

                if(pGanador == p1) p2.setPoints(+1);
                else if(pActual == p2) p1.setPoints(+1);
            }
            else if(juego.Empate()) {
                System.out.println( "Ha habido un empate");
                p1.setPoints(+1);
                p2.setPoints(+1);
                // if(pInciador == p1) p1.setPoints(+1);
                // else if (pInciador == p2) p2.setPoints(+1);

            }

           /* System.out.println();
            System.out.println("Deseas continuar jugando? | SI = 1 | NO = 0 |");
            iniciar = Integer.parseInt(scan.nextLine());

            if(iniciar == 1){
                if(pActual == p1) pActual= p2;
                else if(pActual == p2) pActual = p1;

            }*/
        }

    }
}
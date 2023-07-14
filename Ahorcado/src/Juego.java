import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.Arrays;

public class Juego {

    PalabrasAleatorias palabra = new PalabrasAleatorias();
    String p = palabra.PalabraAleatoria().toLowerCase();
    char[] palabraOculta =  new char[p.length()];
    char[] palabraVisible =  new char[p.length()];
    char[] palabraPorDescubrir = new char[p.length()];
    int fallos = 5;
    public void IniciarJuego(){
        int SeguirJugando = 1;
        Scanner scan = new Scanner(System.in);
        String letra = "";
        Jugador player1 = new Jugador();


        System.out.println("Dime tu nombre");
        player1.setNombre(scan.nextLine());

        do {
            System.out.println("Empezando Partida...");
            System.out.println();
            System.out.println("Esta es tu palabra");
            DibujarPalabra();
            System.out.println();
            do{

                System.out.println("Dime una letra");
                letra = scan.nextLine().toLowerCase();
                System.out.println();

                if(Strike(letra) && fallos != 0 && !Ganador()) {
                    EscribirLetra(letra);
                    DibujarJuego();
                    System.out.println("Te quedan " + fallos + " intentos");
                    System.out.println();
                    if (Ganador()) {
                        System.out.println("------------------------------");
                        System.out.println(" Felicidades haz Ganado!!!!!! ");
                        System.out.println("------------------------------");
                    }
                }
                else if(!Strike(letra) || fallos == 0 && !Ganador()){
                    fallos--;
                    if(fallos == 0){
                        System.out.println("!OPS! te quedaste sin intentos");
                        System.out.println();
                        System.out.println("Tu palabra era " + p.toLowerCase());
                    }
                    else {
                        DibujarJuego();
                        System.out.println("La letra no esta");
                        System.out.println("Te quedan " + fallos + " intentos");
                        System.out.println();
                    }

                }

            }while (fallos != 0);

            System.out.println();
            System.out.println("Deseas Juegar Otra Partida? (y/n)");
            char aux = scan.nextLine().toLowerCase().charAt(0);
            if(aux == 'y' ) SeguirJugando = 1;
            else if(aux == 'n') SeguirJugando = 0;
            else System.out.println("La opcion no es correcta");


        }while (SeguirJugando == 1);


    }

    private void DibujarPalabra(){

        for (int i = 0; i < palabraOculta.length; i++) {
            palabraVisible[i] = p.charAt(i);
            palabraOculta[i] = '_';
            System.out.print(palabraOculta[i]);
        }
        System.out.println();
    }

    private void DibujarJuego(){

        for (int i = 0; i < palabraOculta.length; i++) {
            if(palabraPorDescubrir[i] != '\0') System.out.print(palabraPorDescubrir[i]);
            else System.out.print(palabraOculta[i]);
        }
        System.out.println();
    }

    private void EscribirLetra(String Letra){

        for (int i = 0; i < palabraOculta.length; i++) {
            if(palabraVisible[i] == Letra.charAt(0)){
                if(palabraPorDescubrir[i] != Letra.charAt(0)){
                    palabraPorDescubrir[i] += Letra.charAt(0);
                }
            }else{
                palabraOculta[i] = '_';
            }
        }
        Ganador();
    }

    public boolean Strike(String Letra){
        //boolean letraValida = false;
        for (int i = 0; i < palabraOculta.length; i++) {
            if(palabraVisible[i] == Letra.charAt(0)){
                return true;
            }
        }
        return false;
    }

    public boolean Ganador(){
        if(Arrays.equals(palabraPorDescubrir,palabraVisible)) {
            return true;
        }else
            return false;
    }
}

package E320GlobosExplosivos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int rondasTotales = 5;


        Globo [] globos = new Globo[rondasTotales];
        for (int i = 0; i < rondasTotales; i++) {
            globos[i] = new Globo();
        }

        System.out.println("Bienvenidos al juego de los globos explosivos!");
        System.out.println("Teneis 5 rondas, gana el juego quién gana 3 rondas o más.");

        for (int ronda = 0; ronda < rondasTotales; ronda++) {
            System.out.println("\n--Ronda: " + (ronda + 1) + "--");
            Globo globoActual = globos[ronda];

            do {
                System.out.println(globoActual);
                System.out.printf("Jugador %d-> introduce la cantidad del aire que quieres soplar: ", globoActual.getJugadorActual());
                globoActual.inflar(teclado.nextInt());
                if (globoActual.explotado()) {
                    System.out.println(globoActual);
                    System.out.println("Se ha explotado el globo");
                    System.out.printf("Ha ganado el jugador %d en la ronda %d.", globoActual.buscarGanadorRonda(), (ronda + 1));
                }
                globoActual.alternarJugador();

            } while (!(globoActual.explotado()));
            if (Globo.getRondasGanadasJ1() >= 3 || Globo.getRondasGanadasJ2() >= 3) {
                break;
            }
        }

        System.out.println("\n--resultado final-- ");
        if (Globo.getRondasGanadasJ1() >= 3) {
            System.out.println("El jugador 1 ha ganado el juego");
        }else if (Globo.getRondasGanadasJ2() >= 3) {
            System.out.println("El jugador 2 ha ganado el juego");
        }
    }
}

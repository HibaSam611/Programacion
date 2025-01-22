package E320GlobosExplosivos;

public class Globo {
    private final int capacidadMax;
    private int cantidadAire;
    private int jugadorActual = 1;
    private static int rondasGanadasJ1= 0;
    private static int rondasGanadasJ2= 0;

     public Globo() {
         this.capacidadMax =10 +(int)(Math.random()*41);
         this.cantidadAire = 0;
     }

     public void inflar(int cantidad) {
         this.cantidadAire += cantidad;
     }

    public String toString() {
         StringBuilder cadena = new StringBuilder();
         for (int i = 1; i <= capacidadMax; i++) {
             cadena.append(i <= cantidadAire ? "*" : "O");

         }
        return cadena.toString();
    }

    public boolean explotado(){
         return cantidadAire >= capacidadMax;
    }

    public int getJugadorActual() {
        return jugadorActual; //devuelve el valor del jugador actual
    }

    public void alternarJugador() {
        jugadorActual = jugadorActual == 1 ? 2 : 1;
    }

    public int buscarGanadorRonda() {
        if (explotado()) {
            if (jugadorActual == 1) {
                rondasGanadasJ2++;
                return 2;
            }else if (jugadorActual == 2) {
                rondasGanadasJ1++;
                return 1;
            }
        }
        return 0;
    }

    public static int getRondasGanadasJ1() {
        return rondasGanadasJ1;
    }

    public static int getRondasGanadasJ2() {
        return rondasGanadasJ2;
    }
}

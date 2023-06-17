
public class Contador {
    private static long contador = 0;

    public static void sumar(){
        contador++;
    }

    public static void reiniciar(){
        contador = 0;
    }

    public static long getContador(){
        return contador;
    }

}
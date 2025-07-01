package UT1_PD6.UT1_PD6_Ej1;

public class Tablero {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.ImprimirTablero(7,7);
    }
    public static void ImprimirTablero(int ancho, int largo) {
        for (int i = 0; i < largo; i++) {
            String linea = "";
            for (int j = 0; j < ancho; j++) {
                linea+="#";
            }
            System.out.println(linea);
        }
    }
}

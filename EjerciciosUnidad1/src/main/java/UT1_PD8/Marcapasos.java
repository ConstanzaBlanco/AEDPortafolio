package UT1_PD8;

public class Marcapasos {
    private short presionSanguinea; //2 bytes
    private short frecuenciaCardiaca; //2 bytes
    private short nivelAzucarEnSangre; //2 bytes
    private long maxFuerza; //8 bytes
    private float tiempoLatidos;//4 byte
    private double bateria; //8 bytes
    private String codigo;
    public Marcapasos(long fuerza, String codigo) {
        this.maxFuerza = fuerza;
        this.codigo = codigo;
    }
}
/*Respuesta b: ocupa 26 bytes*/


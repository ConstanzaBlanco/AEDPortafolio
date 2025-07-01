package UT1_PD5.UT1_PD5_Ej7;

public class MainStringBuilder {
    public static void main(String[] args) {
        //CONSTRUCTORES
        StringBuilder sb1 = new StringBuilder(); // Constructor vacío
        StringBuilder sb2 = new StringBuilder("Hola"); // Constructor con String
        StringBuilder sb3 = new StringBuilder(10);//Constructor con capacidad inicial

        //SETLENGTH
        sb2.setLength(13);
        System.out.println(sb2);//"Hola         "


        //ENSURECAPACITY
        sb3.ensureCapacity(2);
        System.out.println("Capacidad asegurada: 2 (no visible en salida, solo afecta rendimiento)");


        //APPEND
        StringBuilder sb4 = new StringBuilder("Hola");
        System.out.println(sb4.append(" Mundo"));//Hola Mundo


        //INSERT
        StringBuilder sb5 = new StringBuilder("Hola");
        System.out.println(sb5.insert(1,"ooo"));//Hoooola


        //DELETE
        StringBuilder sb6 = new StringBuilder("Hola Mundo");
        System.out.println(sb6.delete(4,10));//Hola

        //DELETECHARAT
        StringBuilder sb7 = new StringBuilder("Hola Mundo");
        System.out.println(sb7.deleteCharAt(0));//ola Mundo

        //REVERSE
        StringBuilder sb8 = new StringBuilder("Esto sirve para palindromos");
        System.out.println(sb8.reverse());//somordnilap arap evris otsE
    }

}

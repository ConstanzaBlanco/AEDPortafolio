package UT1_PD5.UT1_PD5_Ej8;

public class MainStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Able was I ere I saw Elba.");
        /* La capaciada inicial se calcula:
         con la capacidad inicial creada por el stringuilder por defecto, que es 16 mas la
        cantidad de letras del string dado: Able was I ere I saw Elba; tiene
        26 letras. Por lo tanto, 16+26=42.
        Este numero lo verificamos con el metodo capacity del StringBuilder:*/
       System.out.print(sb.capacity());
    }
}

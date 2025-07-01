package UT1_PD5.UT1_PD5_Ej5;

public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);//Converte en String d
        int dot = s.indexOf('.');//Da el numero del lugar (index) donde esta el punto decimal
        //8 es 0, 8 es 1, 8 es 2 y . es 3
        System.out.println(dot + " digits " +
                "before decimal point.");//Imprime el lugar donde esta el punto, el cual coincide
        // con la cantidad de numeros antes del punto decimal.
        System.out.println( (s.length() - dot - 1) +
                " digits after decimal point.");
        //Al largo total que es 6 contando el punto le resta la cantidad de numeros antes del punto
        //y tambien le resta 1, el cual corresponde al punto, por lo que queda con la cantidad de
        // numeros despues del punto.
    }
}

/*Respuesta 1:
3 digits before decimal point.
2 digits after decimal point.

 */
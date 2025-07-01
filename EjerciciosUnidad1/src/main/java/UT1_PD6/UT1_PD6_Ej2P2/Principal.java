package UT1_PD6.UT1_PD6_Ej2P2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Principal p=new Principal();
        p.leerEntradaStdin();

    }
    public static void leerEntradaStdin(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese el rado de la circunferencia: ");
        int rad=sc.nextInt();
        double perimetro=2*rad*Math.PI;
        perimetro = Math.round(perimetro * 100) / 100.0;
        System.out.println("El perimetro de la circunferencia es "+perimetro);
        double area=(rad*rad)*Math.PI;
        area = Math.round(area * 100) / 100.0;
        System.out.println("El area de la circunferencia es "+area);

    }
}

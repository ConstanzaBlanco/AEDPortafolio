package UT1_PD1.UT1_PD1_Ej3;

public class MultSuma {
    public static double  Multisuma(double a, double b,double c) {
        return a*b+c;
    }
    public static void main (String[] args) {
        MultSuma obj = new MultSuma();
        System.out.println(obj.Multisuma(1,2,3));//5
        System.out.println(obj.Multisuma(2,3,4));//10
        System.out.println(obj.Multisuma(4,5,6));//26

    }
}

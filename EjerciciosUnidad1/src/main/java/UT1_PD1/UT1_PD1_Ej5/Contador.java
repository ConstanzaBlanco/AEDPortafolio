package UT1_PD1.UT1_PD1_Ej5;

public class Contador {
    final int Max_Cont=50;
    int incremento=1;
    int contador=1;
    public void mostrarContador(){
        while(contador<=Max_Cont){
            System.out.println(contador);
            contador=contador+incremento;
        }
    }
}

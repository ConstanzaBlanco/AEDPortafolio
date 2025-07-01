package UT1_PD1.UT1_PD1_Ej5;

public class ContadorDoWhile {
    final int Max_Cont=50;
    int incremento=1;
    int contador=1;
    public void mostrarContador(){
        do{
            System.out.println(contador);
            contador=contador+incremento;
        }while(contador<=Max_Cont);
    }

}

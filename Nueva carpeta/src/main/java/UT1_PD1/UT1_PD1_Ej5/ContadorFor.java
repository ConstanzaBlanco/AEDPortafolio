package UT1_PD1.UT1_PD1_Ej5;

public class ContadorFor {
    final int Max_Cont=50;
    int incremento=1;
    public void mostrarContador(){
        for(int contador=1;contador<=Max_Cont;contador+=incremento){
            System.out.println(contador);
        }
    }
}

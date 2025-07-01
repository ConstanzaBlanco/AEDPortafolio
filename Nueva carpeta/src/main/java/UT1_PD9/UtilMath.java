package UT1_PD9;

public class UtilMath {
    public static int factorial(int num){
        int resultado = 1;
        for(int i=1;i<=num;i++){
            resultado = resultado*i;
        }
        return resultado;
    }
    private static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }
    public static int sumaHastaPrimo(int num){
        UtilMath util = new UtilMath();
        boolean isPrime=util.isPrime(num);
        int resultado=0;
        int contador=0;
        if(isPrime){
            while(contador<num){
                if (contador%2==0){
                    resultado+=contador;
                }
                contador++;
            }
        }
        else{
            while(contador<num){
                if(contador%2!=0){
                    resultado+=contador;

                }
                contador++;
            }
        }
        return resultado;
    }
}

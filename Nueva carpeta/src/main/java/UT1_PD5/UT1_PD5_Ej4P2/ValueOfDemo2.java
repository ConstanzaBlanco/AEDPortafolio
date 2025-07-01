package UT1_PD5.UT1_PD5_Ej4P2;

public class ValueOfDemo2 {
    public static void main(String[] args) {
// this program requires two
// arguments on the command line
        args=new String[2];
        String num1="13.4";
        String num2="a";
        args[0]=num1;
        args[1]=num2;
        if (args.length == 2) {
// convert strings to numbers
            try {
                float a1 = (Float.valueOf(args[0]));
                float b1 = (Float.valueOf(args[1]));
                int a = (int) a1;//Redondeo a
                int b = (int) b1;//Redondeo b
                if(a>0 && b>0){
                    System.out.println("a + b = " +
                            (a + b));
                    System.out.println("a - b = " +
                            (a - b));
                    System.out.println("a * b = " +
                            (a * b));
                    System.out.println("a / b = " +
                            (a / b));
                    System.out.println("a % b = " +
                            (a % b));
                }
                else{
                    System.out.print("Solo numeros positivos");
                }
            }
            catch (Exception e) {
                System.out.println("Escriba un numero valido");
            }
        } else {
            System.out.println("This program " +
                    "requires two command-line arguments.");
        }

    }

}

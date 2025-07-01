package UT1_PD5.UT1_PD5_Ej4P1;

public class ValueOfDemo {
    public static void main(String[] args) {
// this program requires two
// arguments on the command line
        args=new String[2];
        String num1="13.4";
        String num2="66.1";
        args[0]=num1;
        args[1]=num2;
        if (args.length == 2) {
// convert strings to numbers
            float a = (Float.valueOf (args[0]));
            float b = (Float.valueOf(args[1]));
// do some arithmetic
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
        } else {
            System.out.println("This program " +
                    "requires two command-line arguments.");
        }
    }
}
/*Salida:
a + b = 79.5
a - b = -52.699997
a * b = 885.7399
a / b = 0.20272315
a % b = 13.4
 */

package UT1_PD4.UT1_PD4_Ej2;

public class Rectangle {
    public static double width=0;
    public static double height=0;

    public double area() {
        if(width!=0 && height!=0) {
            return width*height;
        }
        else{
            return -1;
        }
    }
}

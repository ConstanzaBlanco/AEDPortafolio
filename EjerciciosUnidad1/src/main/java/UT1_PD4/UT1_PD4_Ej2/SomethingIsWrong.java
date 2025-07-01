package UT1_PD4.UT1_PD4_Ej2;

/*
1) Lo que esta mal es como crea myRect del tipo Rectangle, tendria que crearse asi: Rectangle myRect=new Rectangle();
 */
public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRec= new Rectangle();
        myRec.width=4;
        myRec.height=5;
        System.out.print(myRec.area());
    }
}

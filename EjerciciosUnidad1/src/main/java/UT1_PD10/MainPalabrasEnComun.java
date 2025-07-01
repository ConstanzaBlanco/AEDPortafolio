package UT1_PD10;

public class MainPalabrasEnComun {
    public static void main(String[] args) {
        ContadorPalabrasArray cont=new ContadorPalabrasArray();

        String[] Ar1={"Hola", "mundo", "de", "los", "algoritmos"};
        String[] Ar2={"Hola", "mundo", "de","la", "informatica"};
        cont.PalabrasEnComun(Ar1,Ar2);

        ContadorPalabrasArray cont1=new ContadorPalabrasArray();
        ContadorPalabrasArray cont2=new ContadorPalabrasArray();
        String[] result=cont.PalabrasEnComun(cont1.leerArchivo("c:\\archivo1.txt"),cont2.leerArchivo("c:\\archivo2.txt"));
    }
}

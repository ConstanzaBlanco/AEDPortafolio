package UT3_PD9;

public class MainCorchetes {
    public static void main(String[] args) {
        Corchetes corchetes = new Corchetes();
        String[] ejemplo1 = { "{", "{","{", "}", "}","}" };//True
        System.out.println(corchetes.controlCorchetes(ejemplo1));
        String[] ejemplo2 = { "}", "{", "{", "}" };//False
        System.out.println(corchetes.controlCorchetes(ejemplo2));
        String[] ejemplo3 = { "{", "}", "{", "{", "}" };//False
        System.out.println(corchetes.controlCorchetes(ejemplo3));
    }

}

package Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q01 {

    // 2) "Q01" olarak adlandirilan bir class olusturun
    // 3) 5 String ogesi iceren bir String List olusturun
    // 4) 3 tanes "A" harfi ile baslayacak
    // 5) Elemanlar "A" harfi ile basliyorsa ve elemanlarin uzunluklarini
    //    5'ten kucukse, konsolda list olarak buyuk harflerle yazdirin

    public static void main(String[] args) {

        List<String> list=new ArrayList<>();
        list.add("Angle");
        list.add("Andy");
        list.add("Ali");
        list.add("Emrah");
        list.add("Nilgun");

        System.out.println(list.stream().
                filter(t->t.startsWith("A")).
                filter(t->t.length()<5).
                map(String::toUpperCase).
                collect(Collectors.toList()));
    }



}

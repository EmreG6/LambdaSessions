package Sessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletionException;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("mehmet",
                                                    "emre","nilgun","yıldız","kader",
                                                    "eminex","islam","islam","wabuziddin"));

        bykHrfTekrarsizSira(list);
        System.out.println();
        System.out.println("   ***   ");
        karakterSayisitekrarsizTersSirali(list);
        System.out.println();
        System.out.println("   ***   ");
        karakterSayisiSiraliEl(list);
        System.out.println();
        System.out.println("   ***   ");
        sonHrfTerSiraliEl(list);
        System.out.println();
        System.out.println("   ***   ");
        ciftKareTekrarsizTersSira(list);
        System.out.println();
        System.out.println("   ***   ");
        harfSayisi7Kontrol(list);
        System.out.println();
        System.out.println("   ***   ");
        wBaslamaKontrol(list);
        System.out.println();
        System.out.println("   ***   ");
        xBiten(list);
        System.out.println();
        System.out.println("   ***   ");
        enBykKrk(list);
        System.out.println();
        System.out.println("   ***   ");
        enBykKrk2(list);
        System.out.println("   ***   ");
        ilkElemanlarHaricSonHarfSirala(list);




    }
    // list elemanlarini alfabatik buyuk harf sirasiyla ve tekrarsiz yazdiriniz.
    public static void bykHrfTekrarsizSira( List<String> list){
        list.
                stream().//akisa girdi
                // map(t->t.toUpperCase()).//elelmanlar byk harf update edildi
                map(String::toUpperCase).//elelmanlar byk harf update edildi
                sorted().//alfabetik sira
                distinct().//tekrarsiz  yapildi.... cooook onemli ahanda trick
                forEach(t->System.out.print(t + " "));//yazdirilidi
                //EMRE EMİNE KADER MEHMET NİLGUN YILDIZ İSLAM
    }

    // list elemanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void karakterSayisitekrarsizTersSirali( List<String> list){
        list.
                stream().
                map(t-> t.length() ). //String data character sayisina update edildi
                sorted(Comparator.reverseOrder()). //ters sira
                distinct(). //tekrarsiz
                forEach(Lambda01::printEl); //yazdirildi 6 5 4
    }
    // list elamanlarini character sayisina gore kucukten buyuge gore yazdiriniz.
    public static void karakterSayisiSiraliEl(List<String> list){
        list.
                stream().
                sorted(Comparator.comparing(t-> t.length())). //eleman karakter sayisina gore ozel siralama yapildi
                forEach(t->System.out.print(t + " ")); // yazidirldi
    }
    // list elemanlarini son harfine gore ters sirali yazdirin
    public static void sonHrfTerSiraliEl(List<String> list){

        list.
                stream().//dikey yap
                sorted(Comparator.
                        comparing(t->t.toString().    //*ONEMLII**KArsilastirma Methoduu*/*//*/*/*/*/
                        charAt(t.toString().length()-1)).//son indexe karsilik gelen karakteri alir
                        reversed()).//elemanin length()-1)  indexsini kaakterini ters siralar z->a
                forEach(t->System.out.print(t + " "));
}

    //uzunlugu cift sayi olan elemanlarin uzunluklarinin karelerini hesaplayan, tekrarsiz buyukten kucuge sirali yazdiriniz.

    public static void ciftKareTekrarsizTersSira(List<String> list){
        list.
                stream().
                // filter(t->t.length()%2==0).
                map(t->t.length()*t.length()). //string elemanlar sayisina cevirdi
                filter(Lambda01::ciftBul). //cift sayi sarti calisti
                distinct(). // tekrarsiz
                sorted(Comparator.reverseOrder()). //ters sira b->k
                forEach(Lambda01::printEl); //yazdirildi
    }

    // allMatch() ve ternary
    // List elemanlarinin karakter sayisini 7 ve 7'den az olma durumunu kontrol ediniz
    public static void harfSayisi7Kontrol(List<String> list){

     /*
     boolean kontrol  = list.

             stream().
             allMatch(t->t.length()<=7); // her bir elemani harf sayisini <=7 ye eslesmesine bakti
        if (kontrol){
            System.out.println("list elemanlari 7 harften buyuk degil");
        }else{
            System.out.println("AGAM list elemanlari 7 harften BUYUK");
        }

        // System.out.println(kontrol);
    */
        System.out.println(list.stream().allMatch(t->t.length() <=7) ?
                ("list elemanlari 7 harften buyuk degil"):
                ("AGAM list elemanlari 7 harften BUYUK") );
    }

    // noneMatch()
    // list elemanlarini "W" ile baslamasini kontrol ediniz
    public static void wBaslamaKontrol(List<String> list){

        System.out.println(list.
                stream().
                noneMatch(t->t.startsWith("w")) ?
                ("w ile baslayan isim kimse ayaga kalksin"):
                ("AGAM w ile baslayan isim yok") );



    }
    // anyMatch() - endsWith()
    // list elemanlarini "x" ile biten en az bir elemani kontrol ediniz
    public static void xBiten(List<String> list){

        System.out.println(list.
                stream().
                anyMatch(t->t.endsWith("x")) ?
                ("x ile baslayan isim kimse ayaga kalksin"):
                ("AGAM x ile biten isim yok") );

        //anyMatch()---->> en az bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch()---->> tum elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder
        //oneMatch()---->> hic bir sarti saglamazsa true en az bir eleman sarti saglarsa false return eder

    }

    // Karakter sayisi en buyuk elemani yazdirin
    public static void enBykKrk(List<String> list){

         System.out.println(list.
                 stream().
                 sorted(Comparator.comparing(t->t.toString().length()). // length karakter uzunluguna gore siraladi kucuk -> buyuk
                         reversed()). // uzunluguna gore ters siraladi buyuk -> kucuk
                        findFirst()); // en buyuk ilk elemani getirdi
               //  limit(1));      //limit(a); Yapilan siralamadaki ilk elemani alir

        // neden optional verdi --> String'e uygun olmayan degerlerde sayilabilir.
    }
    public static void enBykKrk2(List<String> list){

        Stream<String> sonIsim = list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()). // length karakter uzunluguna gore siraladi kucuk -> buyuk
                        reversed()). // uzunluguna gore ters siraladi buyuk -> kucuk
                //   findFirst()); // en buyuk ilk elemani getirdi
                        limit(1);      //limit(a); akistan cikan elemanlari o parametrelerine gore ilk elemani alir
        System.out.println(Arrays.toString(sonIsim.toArray()));
        // limit() ten cikan veriler bir data oldugu icin array'ecevirmeden yazdiramayiz.
    }

    // list elemanlarini son harfine gore siralayip ilk elemanlari haric yazdiriniz
    public static void ilkElemanlarHaricSonHarfSirala(List<String> list){
        list.
                stream().
                sorted(Comparator.comparing(t->t.toString().charAt(t.length()-1))).
                skip(1). //akistan cikarilanlarin 1. siradakini atlar
                forEach(System.out::println);
                //forEach(t->System.out.println(t +" "));


    }


}
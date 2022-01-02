package Sessions;

import java.util.*;

public class Lambda02 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, -3, 7, 34, 22, -60, 42, 55));

        ciftKareMax(list);
        System.out.println();
        System.out.println("   	   ***   ");
        toplaEl1(list);
        System.out.println();
        System.out.println("   	   ***   ");
        toplaEl2(list);
        System.out.println();
        System.out.println("   	   ***   ");
        ciftCarp(list);
        System.out.println();
        System.out.println("   	   ***   ");
        ciftCarp2(list);
        System.out.println();
        System.out.println("   	   ***   ");
        min1(list);
        System.out.println();
        System.out.println("   	   ***   ");
        min2(list);
        System.out.println();
        System.out.println("   	   ***   ");
        min3(list);
        System.out.println();
        System.out.println("   	   ***   ");
        min4(list);
        System.out.println("   	   ***   ");
        onbestenBykKckTekSayi(list);
        System.out.println("   	   ***   ");
        ciftKareKckByg(list);
        System.out.println("   	   ***   ");
        tekKareBygKcg(list);

    }

    // reduce()
    //List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
    public static void ciftKareMax(List<Integer> list) {
        // Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);
        //reduce(Math::max) da kullanilabilir ancak reduce(Integer::max); daha specific  oldugu icin hizli calisir

        // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce() returne edilen elelman null yada int 'den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
        //Optional class' sart kosuyor
        System.out.println(maxEl);

    }

    // List'teki tum elemanlarin toplamini yazdiriniz
    // Lambda expression ile yazdiriniz
    public static void toplaEl1(List<Integer> list) {
        int toplam = list.stream().reduce(0, (x, y) -> x + y);
      /*
        // x her zaman ilk degerini atanan degerden (0) alir
        // y her zaman degerini list.stream()'den alir. (akis)
        // x ilk degerden sonraki degerlerini silemden alir.

         x     y
        ---   ---
         0     5
         5    -8
        -3     13
         10    24   =34

       */
        System.out.println(toplam);
    }

    // List'teki tum elemanlarin toplamini yazdiriniz
    // Method reference
    public static void toplaEl2(List<Integer> list) {
        Optional<Integer> toplam1 = list.stream().reduce(Math::addExact);

      /*
        // x her zaman ilk degerini atanan degerden (0) alir
        // y her zaman degerini list.stream()'den alir. (akis)
        // x ilk degerden sonraki degerlerini silemden alir.

        //spesifik yapilar hizli calisir
       */

        System.out.println(toplam1);

    }


    // List'teki cift elemanlarin carpimini yazdiriniz
    // Method Reference

    public static void ciftCarp(List<Integer> list) {

        Optional<Integer> ciftlerCarpim = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);


        System.out.println(ciftlerCarpim);
    }
    // List'teki cift elemanlari carpimini yazdirin
    // Lambda expressin...

    public static void ciftCarp2(List<Integer> list) {

        Optional<Integer> ciftlerCarp2 = Optional.of(list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x + y)));
        // pozitif deger uretiniz
        Optional<Integer> carpPoz = Optional.of(list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> (x + y)));

        System.out.println(ciftlerCarp2);
        System.out.println(carpPoz);
    }
    // sort()
    // List'teki elemanlardan en kucugunu 4 farkli yontem ile yazdiriniz.
    //1.Yontem Method Reference ---> Integer Class

    public static void min1(List<Integer> list) {
        Optional<Integer> min1 = list.stream().reduce(Integer::min);
        System.out.println(min1);
    }

    // 2. Yontem Method Reference ---> Math Class
    public static void min2(List<Integer> list) {
        Optional<Integer> min2 = list.stream().reduce(Math::min);
        System.out.println(min2);

    }

    // 3. Yontem Method Reference ---> Haluk Class
    public static int minBul(int x, int y) {
        return x < y ? x : y; //ternary

    }

    // 3. Yontem Method Reference ---> Math Class
    public static void min3(List<Integer> list) {
        Optional<Integer> min3 = list.stream().reduce(Lambda02::minBul);
        System.out.println(min3);

    }

    // 4. Yontem Method Lambda Expression
    public static void min4(List<Integer> list) {
        Integer min4 = list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println(min4);
    }
    //List'teki 15'ten buyuk en kucvuk tek sayiyi yazdiriniz
    public static void onbestenBykKckTekSayi(List<Integer> list) {
        // list.stream().filter(t->t % 2 == 1).filter(t-> t>15).reduce(Integer::min);
        System.out.println(list.
                stream().//akısa girdi
                        filter(t -> t % 2 == 1 & t > 15).//tek ve 15 den byk sarti
                        reduce(Integer::min));//min deger reduce edildi
    }
    //list'in cift  elemanlarinin kareleri ni  kucuge buykten yazdiriniz
    public static void ciftKareKckByg(List<Integer> list){
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().//akısa giren elelmanlar naturel order'e gore siralanir
                forEach(Lambda01::printEl);//144 484 1156 1764 3600

    }

    // List'İn tek elemanlarinin karelerinin karelerini buyukten kucuge yazdiriniz
    public static void tekKareBygKcg(List<Integer> list){
        list.
                stream().
                filter(t->t%2!=0).
                map(t->t*t).
                sorted(Comparator.reverseOrder()).//akısa giren elelmanlar ters siralanir
                                                  // terminal method oldugu icin
                forEach(Lambda01::printEl);//4225 3025 169 49 9

    }







}
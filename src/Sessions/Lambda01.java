package Sessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {

    /*
     * 1) Lambda "Functional Programming" "Functional Programming" de
     * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
     * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
     * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
     * code yazma acilarindan cok faydalidir. 4) Lambda sadece
     * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
     * map'lerde kullanılmaz. Lambda kullanmak hatasız code kullanmaktır.
     */

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));

        printElStrcutured(list); // method call
        System.out.println();
        System.out.println("   	   ***   ");
        printElFunctional(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printElFunctional1(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printCiftElStuructured(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printCiftElFunctional1(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printCiftElFunctional2(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printCiftAltmisKucuk(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printCiftYirmiBuyuk(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printKare(list);
        System.out.println();
        System.out.println("   	   ***   ");
        kupBirFazlaTekFunction(list);
        System.out.println();
        System.out.println("   	   ***   ");
        printKarekokCıftFunctional(list);
        System.out.println();
        System.out.println("   	   ***   ");
        maxElFunction(list);

    }

    // strcutured preogramming ile list elemanlarinin tamamini aralarina bosluk
    // birakakrak yazdiriniz
    private static void printElStrcutured(List<Integer> list) {// 12,13,65,3,7,34,22,60,42,55

        for (Integer w : list) {
            System.out.print(w + " ");

        }

    }

    // functional pragramming ile list elemanlarinin tamamini aralarina bosluk
    // birakarak yazdiriniz
    public static void printElFunctional(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " ")); // Lambda expression : Lambda ifadesi
        // stream() : datalari yukaridan asagiya akis sekline getirir
        // for each() : datanin parametresine gore her bir elemani isler
        // t -> : Lamda operatorudur.
        // Lambda expression yapisi cok tavsiye edilmez. Daha cok METOD REFERENCE
        // kullanilir.
        // neden stream'da calisitik. daha fazla metod calistirabiliyoruz.
        // stream bir lambda methodudur. verilerimizi dikey hale getirir.

    }
    // Method Reference --> kendir create ettigimiz veya java'dan aldigimiz method
    // ile
    // ClassName::MethodName --> ezberleee!

    public static void printEl(int t) { // refere edilecek method create edildi
        System.out.print(t + " ");

    }

    public static void printElFunctional1(List<Integer> list) {

        list.stream().forEach(Lambda01::printEl); // iste lambda budur...

    }

    // structured Programming ile list elemanlarinin cift olanlarini ayni satirda
    // aralarina bolsuk birakarak yazdiriniz

    public static void printCiftElStuructured(List<Integer> list) {
        for (Integer w : list) {
            if (w % 2 == 0) {
                System.out.print(w + " ");

            }

        }

    }

    // Functional Programming ile list elemanlarinin cift olanlarini ayni satirda
    // aralarina bosluk birakarak yazdiriniz
    public static void printCiftElFunctional1(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).forEach(Lambda01::printEl);

        // filter() --> : bir akis icerisinde verilen elemanlari istenen sarta gore
        // filtreleme yapar

    }

    public static boolean ciftBul(int i) { // refere edilecek tohum method create edildi

        return i % 2 == 0;
    }

    public static void printCiftElFunctional2(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl); // 2 tane method refere ettik

        // filter() --> : bir akis icerisinde verilen elemanlari istenen sarta gore
        // filtreleme yapar
    }

    // Functional Programming ile list elemanlarinin cift olanlarinin 60'dan kucuk
    // olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftAltmisKucuk(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0 & t < 60).forEach(Lambda01::printEl);

    }

    // Functional Programming ile list elemanlarinin tek olanlarini veya 20'dan
    // buyuk olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftYirmiBuyuk(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 1 || t > 20).forEach(Lambda01::printEl);
    }

    // Functional Programming ile list elemanlarinin cift olanlarinin karelerini
    // ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printKare(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).map(t -> t * t).forEach(Lambda01::printEl);

        // map() --> bir ara islemde kullanilir. elemanlari istenen isleme gore
        // degistirmek update etmekicin kullanilir
    }

    // public static void printKare1(List<Integer> list) {
    // list.stream().filter(Lambda01::ciftBul).map(Math::pow).forEach(Lambda01::printEl);

    // }

    // Functional Programming ile list elemanlarinin tek olanlarin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void kupBirFazlaTekFunction(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 1).map(t -> (t * t * t) + 1).forEach(Lambda01::printEl);

    }

    // Functional Programming ile list elemanlarinin cift olanlarin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printKarekokCıftFunctional(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t -> System.out.println(t + " "));
    }

    // List'İn en buyuk elemanini yazdiriniz
    public static void maxElFunction(List<Integer> list) {
        Optional<Integer> maxEl = list.stream().reduce(Math::max);
        System.out.println(maxEl);

        // reduce() --> bir cok datayi tek bir dataya (max min carpma toplama vs) cevirmek icin kullanilir.

        /*
         * Optional Class sayesinde;
         * 	Null kontrolü yapılmasına gerek kalmaz.
         * 	Kolay kod yazımı.
         * 	Kod okunabilirliğinin kolaylaşması.
         */

    }

}

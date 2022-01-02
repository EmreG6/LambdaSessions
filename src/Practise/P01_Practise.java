package Practise;

import Sessions.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class P01_Practise {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,20,35,60,75,80,95,68,99,102,106));
        ciftBul(list);
        System.out.println();
        ciftBul1(list);
        System.out.println();
        ciftTopla(list);
        ciftTopla1(list);
        System.out.println();
        ciftCarpma(list);
    }

    public static boolean cift(int t){
        return t%2==0;}

    public static void ciftBul(List<Integer> list) {
        list.stream().filter(t->t%2==0).forEach(t->System.out.print(t+" "));
    }
    public static void ciftBul1(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).forEach(t->System.out.print(t+" "));
    }
    public static void ciftTopla(List<Integer> list) {
        Optional<Integer> toplam = list.stream().filter(Lambda01::ciftBul).reduce(Integer::sum);
        System.out.println("Cift sayilar Toplami ==> "+toplam);
    }

    public static void ciftTopla1(List<Integer> list) {
        Optional<Integer> toplam1 = Optional.of(list.stream().filter(Lambda01::ciftBul).reduce(0, (x, y) -> (x + y)));
        System.out.println("Cift sayilar Toplami ==> "+toplam1);
    }

    public static void ciftCarpma(List<Integer> list){
        Optional<Integer> carpim = Optional.of(list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x * y)));
        System.out.println("Cift sayilar Carpimi ==> " + carpim);
    }
}

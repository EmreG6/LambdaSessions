package Practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static  List<Ogrenci> ogListesi= new ArrayList<>();

public static void main(String[] args){
    ogrenciListesi();
    notaGoreSirala(3,90);
    yasaGoreSirala();
    yasaVeCinsiyeteGore(10,"kadin");
    isimAlfabatikSirala("Ahmet");
    soyismeGoreSirala("Can");
}

    private static void soyismeGoreSirala(String soyAd) {
    ogListesi.stream().filter(t->t.getSoyad().equalsIgnoreCase(soyAd)).collect(Collectors.toList());
        System.out.println(" ****");
    }

    private static void isimAlfabatikSirala(String isim) {
    ogListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).collect(Collectors.toList());
        System.out.println(" ****");
    }

    private static void yasaVeCinsiyeteGore(int yas, String cinsiyet) {
    ogListesi.stream().filter(t->t.getYas()<yas).filter(t->t.getCinsiyet().equalsIgnoreCase(cinsiyet)).
            sorted(Comparator.comparing(Ogrenci::getYas)).
            forEach(System.out::println);
        System.out.println(" ****");
    }

    private static void yasaGoreSirala() {
    ogListesi.stream().sorted(Comparator.comparing(Ogrenci::getYas).reversed()).forEach(System.out::println);

    }

    //Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin
    public static void notaGoreSirala(double a,double b) {
        ogListesi.stream().
                filter(t->t.getDiplomaNot()>a && t.getDiplomaNot()<b).
                forEach(t->System.out.println(t.toString()));
        System.out.println("   **** ");
    }


    private static void ogrenciListesi() {
        ogListesi.add(new Ogrenci("Ahmet","Can",30,95.5,"erkek"));
        ogListesi.add(new Ogrenci("Ahmet","Yarba",25,90.5,"erkek"));
        ogListesi.add(new Ogrenci("Ayse","Can",21,82.5,"kadin"));
        ogListesi.add(new Ogrenci("Merve","Aslan",30,98.8,"kadin"));
        ogListesi.add(new Ogrenci("Veli","Han",80,35.5,"erkek"));
        ogListesi.add(new Ogrenci("Funda","Funda",24,99.2,"kadin"));
    }



}

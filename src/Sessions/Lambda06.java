package Sessions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

    //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.
                lines(Paths.get("src/Sessions/haluk.txt")).//file erisip  file satirlari akis alindi
                forEach(System.out::println);

    //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.
                lines(Paths.get("src/Sessions/haluk.txt")). // akis saglandi
                map(String::toUpperCase). //akistaki satirlarin BUYUK harfler ile update edilmesi
                forEach(System.out::println);//yazdirildi

    //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.
                lines(Paths.get("src/Sessions/haluk.txt")). // akis saglandi
                limit(1). // 1. satir alindi //findFirst() de olur
                map(String::toLowerCase).
                forEach(System.out::println);//yazdirildi

    //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

        System.out.println(Files.
                lines(Paths.get("src/Sessions/haluk.txt")). // akis saglandi
                        filter(t->t.contains("Basari")). // basari icerme sarti
                        count());

    //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src/Sessions/haluk.txt")). // akis saglandi
                map(t->t.split( " ")). // " " gore satirlardaki elemanlari parcalayip array'a atadi
                flatMap(Arrays::stream). // Arrays class'indan stream() methodu ile  array elemanlarindan yeni bir akis olusturdu
                distinct(). // yeni akistaki elemanlari tekrarsizhale getirdi
                collect(Collectors.toList())); // tekrarsiz array elemanlari liste atadi ve yazdirdi



    //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
    //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
    //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
    //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
    //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
    //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");


}
}

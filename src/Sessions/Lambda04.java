package Sessions;

import java.util.*;
import java.util.stream.Collectors;



public class Lambda04 {
    public static void main(String[] args){

        TechPro trGunduz=new TechPro("yaz","TR gunduz",97,124);
        TechPro engGunduz=new TechPro("kis","ENG gunduz",95,131);
        TechPro trGece=new TechPro("bahar","TR gece",98,143);
        TechPro engGece=new TechPro("sonbahar","ENG gece",93,151);

        List<TechPro> list=new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));
        // bu class'da agirlikli return type calisacagiz

        System.out.println(batchOrt92Byk(list));
        System.out.println("  ***  ");
        System.out.println(ogrSayiByk110(list));
        System.out.println("  ***  ");
        System.out.println(baharVarMi(list));
        System.out.println("  ***  ");
        System.out.println(ogrcSayisiTersSiraliBatch(list));
        System.out.println("  ***  ");
        System.out.println(ortTop3(list));
        System.out.println("  ***  ");
        System.out.println(enKucuk2inciBatch(list));
        System.out.println("  ***  ");
        System.out.println(Doksan5denBuyukBatchOgrSayilariniBul(list));
        System.out.println("  ***  ");
        System.out.println(Doksan5denBuyukBatchOgrSayilariniBul1(list));
        System.out.println("  ***  ");
        System.out.println(yuz30danBykBatchOrtalamasi(list));
        System.out.println("  ***  ");
        System.out.println(gunBatchSay(list));
        System.out.println("  ***  ");
        System.out.println(EnBykyuz30danBykBatchOrtalamasi(list));
        System.out.println("  ***  ");
        System.out.println(EnKckyuz50denKckBatchOrtalamasi(list));


    }

    // task 01--> batch ort'larinin 92 den buyuk oldg kontrol eden pr create ediniz.
    public static boolean batchOrt92Byk(List<TechPro> list) {
       return list.
                stream().
                allMatch(t->t.getBatchOrt()>92); // akisdaki her eleman batchort field'a gore eslesmesi kontrol edildi
    }
    // task 02--> ogr sayilarinin hic birinin 110 den az olmadigini kontrol eden pr create ediniz
    public static boolean ogrSayiByk110(List<TechPro> list) {
        return list.
                stream().
                noneMatch(t->t.getOgrcSayisi()<110);
                //allMatch(t->t.getOgrcSayisi()>=110);
    }
    //task 03--> batch'lerde herhangi birinde "bahar" olup olmadigini kontrol eden pr create ediniz
    public static boolean baharVarMi(List<TechPro> list) {
        return list.
                stream().
                anyMatch(t->t.getBatch().equals("bahar"));
    }
    // task 04--> batch'leri ogrenci sayilarina gore buyukten kucuge gore siralayiniz
    public static List<TechPro> ogrcSayisiTersSiraliBatch(List<TechPro> list){
        return  list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).
                collect(Collectors.toList());

        //collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }
    //task 05--> batch'leri batch ortalamasina goreee b->k siralayin
    public static List<TechPro> ortTop3(List<TechPro>list) {

        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).
                limit(3). // akistaki ilk ucu alindi
                collect(Collectors.toList());
    }
    // task 06--> batch'leri ogr sayisi en az olan 2. batch'i yazdiriniz
    public static List<TechPro> enKucuk2inciBatch(List<TechPro>list) {

        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)).
                limit(3).
                skip(1).
                collect(Collectors.toList());
    }

    // task 07--> batch ortalamalari 95'den buyuk olan batch'lerin ogrenci sayilarini toplamini bulunuz
    public static int Doksan5denBuyukBatchOgrSayilariniBul(List<TechPro>list) {

        return list.
                stream().
                filter(t->t.getBatchOrt()>95). //95ten buyuk sarti
                map(t->t.getOgrcSayisi()). // batch ort olan data sayisi olarak update edildi
                reduce(0,Integer::sum); // ogr sayisi toplandi
    }
    public static int Doksan5denBuyukBatchOgrSayilariniBul1(List<TechPro>list) {

        return list.
                stream().
                filter(t->t.getBatchOrt()>95). //95ten buyuk sarti
                mapToInt(t->t.getOgrcSayisi()). //type'ina goreint return eder ki sum() methodu calisir
                                                // reduce()'a gerek kalmaz. daha kısa ve hizli coding yapilir.
                sum();
    }
    // task 08--> ogrenci sayilari 130'dan buyuk olan batch'lerin batch ortalamasini bulunuz
    public static OptionalDouble yuz30danBykBatchOrtalamasi(List<TechPro>list) {

        return list.
                stream().
                filter(t->t.getOgrcSayisi()>130).
                mapToInt(t->t.getBatchOrt()).
                average();
    }
    //task 09-->gunduz batch'lerinin sayisini  yazdiriniz.
    public static int gunBatchSay(List<TechPro> list){
        return (int) list.
                stream().
                filter(t->t.getBatchName().contains("gunduz")).
                count();
    }
    //task 10-->Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ort'unu bulunuz
    public static OptionalInt EnBykyuz30danBykBatchOrtalamasi(List<TechPro>list) {
        return list.
                stream().
                filter(t->t.getOgrcSayisi()>130).
                mapToInt(TechPro::getBatchOrt).
                max();
    }
    //task 11-->Ogrenci sayilari 150'dan az olan batch'lerin en kucuk batch ort'unu bulunuz.
    public static OptionalInt EnKckyuz50denKckBatchOrtalamasi(List<TechPro>list) {

        return list.
                stream().
                filter(t->t.getOgrcSayisi()<150).
                mapToInt(TechPro::getBatchOrt).
                min();
    }

}

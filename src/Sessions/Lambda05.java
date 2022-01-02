package Sessions;

import java.util.stream.IntStream;

//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.

//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz

//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz

//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz

//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz

//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz

//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
public class Lambda05 {

  public static void main(String[] args) {

      System.out.println(topla(10));
      System.out.println( " *** ");
      System.out.println(topla1(10));
      System.out.println( " *** ");
      System.out.println(topla2(10));
      System.out.println( " *** ");
      System.out.println(toplaCift(10));
      System.out.println( " *** ");
      System.out.println(toplaCift1(10));// 2 4 6 8 10 12 14 16 18 20
      System.out.println( " *** ");
      System.out.println(toplaTek(10)); // 1 3 5 7 9 11 13 15 17 19
      System.out.println( " *** ");
      ikiIlkXKuvveti(5);
      System.out.println( " *** ");
      sayiKuvveti(2,3); //2nin ilk 3 kuvveti
      sayiKuvveti(3,4); // 3un ilk 4 kuvveti
      sayiKuvveti(5,3); // 5in ilk 3 kuvveti
      sayiKuvveti(1,10); // 1in ikk 10 kuvveti
      System.out.println( " *** ");
      System.out.println(istenenSayininXinciKuvveti1(2,4));
      System.out.println( " *** ");
      System.out.println(istenenSayininXinciKuvveti1(3,4));
      System.out.println( " *** ");
      System.out.println(istenenSayininXinciKuvveti1(1,1000000)); //
      System.out.println( " *** ");
      System.out.println(Faktoryel(5));
  }
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
    //Structured Programming
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam +=i;
        }
        return toplam;
    }
    //Functional Programming
    public static int topla1(int x) {

        return IntStream.range(1,x+1).//1 2 3 ... x elemanarinin akısı
                sum();
    }
    public static int topla2(int x) {

        return IntStream.range(1,x+1).//1 2 3 ... x elemanarinin akısı
                sum();
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
    public static int toplaCift(int x) {

        return IntStream.rangeClosed(1, x).//1 2 3 ... x elemanarinin akısı
                //filter(Lambda01::ciftBul).//2 4 6 ... elaman akısı
                        filter(t -> t % 2 == 0).//2 4 6 ... elaman akısı
                        sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
    public static int toplaCift1(int x) {

        return IntStream.iterate(2, t -> t + 2).//2 4 6 ... x elemanarinin akısı
                limit(x). // akisindaki ilk x elemani verir
                sum();
    }
    //TASK 04 --> Ilk x(mesela 10) pozitif tek tamsayiyi toplayan programi yaziniz
    public static int toplaTek(int x) {
        return IntStream.
                iterate(1,t->t+2).
                limit(x).
                sum();
    }


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz // 2 4 8 16
    public static void ikiIlkXKuvveti (int x) {

             IntStream.iterate(2, t -> t * 2). // 2 4 8 16 x elemanlarinin akisi
                limit(x). // akisindaki ilk x elemani verir
                forEach(Lambda01::printEl);
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void sayiKuvveti(int a, int x) {
        IntStream.
                iterate(a,t->t*a).
                limit(x).
                forEach(t-> System.out.print(t+" "));
    }

    //TASK 07 --> Istenilen bir sayinin x kuvvetini ekrana yazdiran programi yaziniz
    public static int istenenSayininXinciKuvveti1(int a, int x) { // a a2 a3 a4 ... x elenamlarinin akisi
      return  IntStream.iterate(a,t->t*a).
                         limit(x).
                         reduce(0,(t,u)->u);
                        //cslip(x-1) den sonra cikan elemanlari toList ile yazdirilamli
    }
    //TASK 08 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
    public static int Faktoryel(int x) { //
        return IntStream.rangeClosed(1,x).//a a^2 a^3 a^4... x elemanarinin akısı
                // reduce(Math::multiplyExact);
                        reduce(1,(t,u)->t*u);

    }}


package Practise;

public class Ogrenci {
        //bir ogrenci listesi olusturun
        //ad soyad yas diplomaNotu cinsiyet
        // toString methodu ile ogrenci bilgilerin yazdirin
        //Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin
        //Öğrencileri yaşlarına göre sıralayark yazdırin
        //Öğrencileri belirli bir yaşa ve cinsiyete göre sıralayarak listeleyin
        //Öğrencileri isimlerine göre yazdırın
        //Öğrencileri soyisimlerine göre yazdır,n
        //Öğrencileri cinsiyetlerine göre yazdıran
        //listeyi yazdırırken içinde veri var mı diye kontrol edin
        //reduce metoduyla ortalama hesaplayin
        // Girilen ogrenci ismini sil
        //Test amaçlı Öğrenci nesneleri oluşturun.

    private String ad;
    private String Soyad;
    private int yas;
    private double diplomaNot;
    private String cinsiyet;

    public Ogrenci(String ad, String soyad, int yas, double diplomaNot, String cinsiyet) {
        this.ad = ad;
        Soyad = soyad;
        this.yas = yas;
        this.diplomaNot = diplomaNot;
        this.cinsiyet = cinsiyet;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getDiplomaNot() {
        return diplomaNot;
    }

    public void setDiplomaNot(double diplomaNot) {
        this.diplomaNot = diplomaNot;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "ad='" + ad + '\'' +
                ", Soyad='" + Soyad + '\'' +
                ", yas=" + yas +
                ", diplomaNot=" + diplomaNot +
                ", cinsiyet='" + cinsiyet + '\'' +
                '}';
    }
}


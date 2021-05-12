package com.company;

import java.util.Scanner;

public class Kullanici {
    Gonderici gonderici=new Gonderici();
    String kullaniciAdi,sifre;
    Ekran ekran=new Ekran();

    private Kullanici(KullaniciBuilder builder) {
        this.kullaniciAdi= builder.kullaniciAdi;
        this.sifre= builder.sifre;
    }


    public void setKullaniciAdi(String kullaniciAdi) { this.kullaniciAdi = kullaniciAdi; }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void tekrarDene(){

        Scanner input =new Scanner(System.in);
        ekran.mesajGoruntule("Kullanıcı Adı Giriniz:");
        this.kullaniciAdi=input.nextLine();
        ekran.mesajGoruntule("Şifre Giriniz:");
        this.sifre=input.nextLine();
        this.gonder();
    }

    public void gonder(){
        gonderici.EkranaGonder(this);
        gonderici.AkilliCihazaGonder(this);
    }

    public static class KullaniciBuilder
    {
        private String kullaniciAdi;
        private String sifre;

        public KullaniciBuilder(String kullaniciAdi, String sifre) {
            this.kullaniciAdi = kullaniciAdi;
            this.sifre = sifre;
        }
        public KullaniciBuilder setKullaniciAdi(String kullaniciAdi) {
            this.kullaniciAdi = kullaniciAdi;
            return this;

        }

        public KullaniciBuilder setSifre(String sifre) {
            this.sifre = sifre;
            return this;

        }
        public Kullanici build() {

            return new Kullanici(this);
        }

    }


}

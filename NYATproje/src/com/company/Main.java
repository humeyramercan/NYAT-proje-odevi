package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ekran ekran=new Ekran();
        ekran.mesajGoruntule("Hoşgeldiniz. Lütfen kullanıcı adınızı ve şifrenizi giriniz.");
        Scanner input =new Scanner(System.in);
        ekran.mesajGoruntule("Kullanıcı Adı Giriniz:");
        String kullaniciAdi=input.nextLine();
        ekran.mesajGoruntule("Şifre Giriniz:");
        String sifre=input.nextLine();
        Kullanici kullanici=new Kullanici.KullaniciBuilder(kullaniciAdi,sifre).build();
        kullanici.gonder();

    }
}

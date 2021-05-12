package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AkilliCihaz {

    ISecenekler secenekler=new Secenekler();
    IEyleyici eyleyici=new Eyleyici();
    ISicaklikAlgilayici sicaklikAlgilayici=new SicaklikAlgilayici();
    IEkran ekran=new Ekran();

    public void kullaniciDogrula(Kullanici kullanici){
        if(!veritabaniBaglantisi(kullanici.getKullaniciAdi(),kullanici.getSifre())){
            ekran.mesajGoruntule("Yanlis kullanici adi veya sifre. Tekrar deneyin.");
            kullanici.tekrarDene();
        }else{
            islemSec();
        }
    }


    public boolean veritabaniBaglantisi(String kullaniciAdi, String sifre)
    {
        boolean baglantiDurumu=false;
        try
        {   /** Bağlantı kurulumu **/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kullanici",
                    "postgres", "Humeyra123.");
            if (conn != null)
                ekran.mesajGoruntule("Veritabanına bağlandı!");
            else
                ekran.mesajGoruntule("Bağlantı girişimi başarısız!");

            String sql= "SELECT*  FROM \"kullanici\" WHERE \"kullaniciadi\"='"+kullaniciAdi+"' AND  \"sifre\"='"+sifre+"'";

            /** Sorgu çalıştırma **/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()) {
                ekran.mesajGoruntule("Baglantiniz saglandi.");
                baglantiDurumu=true;
            }
            /** Kaynakları serbest bırak **/
            rs.close();
            stmt.close();
            /** Bağlantı sonlandırma **/
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return baglantiDurumu;
    }
    public void islemSec(){

        secenekler.secenekleriListele();
        Scanner reader = new Scanner(System.in);
        int islemNumarasi = reader.nextInt();
        switch (islemNumarasi){
            case 1:ekran.mesajGoruntule( eyleyici.Ac());
                islemeDevamDurumu();
                break;
            case 2:ekran.mesajGoruntule( eyleyici.Kapat());
                islemeDevamDurumu();
                break;
            case 3:ekran.mesajGoruntule( sicaklikAlgilayici.sicaklikAlgila());
                islemeDevamDurumu();
                break;
            default: ekran.mesajGoruntule("Lütfen geçerli bir işlem numarası giriniz.");
                islemSec();
        }
    }
    public void islemeDevamDurumu(){
        ekran.mesajGoruntule("İşlem yapmaya devam etmek istiyor musunuz? (Evet/Hayır)");
        Scanner input =new Scanner(System.in);

        String devamDurumu=input.nextLine();
        if(devamDurumu.matches("Evet")){
            islemSec();
        }else if(devamDurumu.matches("Hayır")){
            ekran.mesajGoruntule("Cihaz kapatılıyor iyi günler dileriz...");
        }else{
            ekran.mesajGoruntule("Hatalı giriş!");
            islemeDevamDurumu();
        }
    }

}

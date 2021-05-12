package com.company;

public class Gonderici {
    AkilliCihaz akilliCihaz=new AkilliCihaz();
    Ekran ekran=new Ekran();
    public void EkranaGonder(Kullanici kullanici){
        ekran.mesajGoruntule("Kullanıcı adınız: "+kullanici.getKullaniciAdi()+" Şifreniz: "+kullanici.getSifre());
    }

  public void AkilliCihazaGonder(Kullanici kullanici){

        akilliCihaz.kullaniciDogrula(kullanici);
    }
}

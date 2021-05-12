package com.company;

import java.text.DecimalFormat;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
    @Override
    public String sicaklikAlgila() {
        Random r=new Random();
        double sicaklik =r.nextFloat()*50;
        DecimalFormat formatter = new DecimalFormat("##.##");
        return "Sicaklik :"+ formatter.format(sicaklik);
    }
}

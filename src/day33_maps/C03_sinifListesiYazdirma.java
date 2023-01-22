package day33_maps;

import day32_sets_maps.MapMethodDepo;

import java.util.Map;

public class C03_sinifListesiYazdirma {
    public static void main(String[] args) {

        // verilen bir siniftaki ogrencilerin no,isim,soyisim,bolumlerini
        //bir liste olarak yazdiran bir method olusturun.

        Map<Integer,String> ogrenciMap=MapMethodDepo.ogrenciMapOlustur();
        MapMethodDepo.sinifListesiYazdirma(ogrenciMap,"10");





    }


}

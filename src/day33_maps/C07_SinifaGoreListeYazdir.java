package day33_maps;

import day32_sets_maps.MapMethodDepo;

import java.util.Map;

public class C07_SinifaGoreListeYazdir {
    public static void main(String[] args) {

        // tum ogrenci listesini
        // sinif sube isim soyisim no seklinde
        // dogal sirali olarak
        // yazdiran bir method olsun

        Map<Integer,String> ogrenciMap= MapMethodDepo.ogrenciMapOlustur();

        MapMethodDepo.sinifSiraliListeOlustur(ogrenciMap);
    }




}

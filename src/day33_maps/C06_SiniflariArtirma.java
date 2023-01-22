package day33_maps;

import day32_sets_maps.MapMethodDepo;

import java.util.Map;

public class C06_SiniflariArtirma {
    public static void main(String[] args) {

        //ogrenci map'deki tum sinif degerlerini 1 artirin.
        // 12.sinifta olan varsa sinif bilgisini mezun yazalim.

        Map<Integer,String>ogrenciMap= MapMethodDepo.ogrenciMapOlustur();

        ogrenciMap=MapMethodDepo.siniflariArtir(ogrenciMap);
        System.out.println(ogrenciMap);

    }



}

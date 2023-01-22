package day32_sets_maps;

import java.util.*;

public class MapMethodDepo {

    // bize ogrenciMap donduren bir method olusturun

    public static Map<Integer, String> ogrenciMapOlustur() {

        Map<Integer, String> ogrenciMap = new HashMap<>();

        ogrenciMap.put(101, "Ali-Can-11-H-MF");
        ogrenciMap.put(102, "Veli-Cem-10-K-TM");
        ogrenciMap.put(103, "Ali-Cem-11-K-TM");
        ogrenciMap.put(104, "Ayse-Can-10-H-MF");
        ogrenciMap.put(105, "Sevgi-Cem-11-M-TM");
        ogrenciMap.put(106, "Sevgi-Can-10-K-MF");

        return ogrenciMap;
    }

    public static boolean isimIleOgrenciArama(Map<Integer, String> ogrenciMap, String isim) {

        // 1- tum value'leri bir collection olarak kaydedelim
        //    [Ali-Can-11-H-MF, Veli-Cem-10-K-TM, Ali-Cem-11-K-TM, Ayse-Can-10-H-MF, Sevgi-Cem-11-M-TM, Sevgi-Can-10-K-MF, Cemal-Han-12-M-MF]
        Collection<String> valuesCollection = ogrenciMap.values();

        // 2- for-each kullanarak her bir value'yu ele alalim  Ali-Can-11-H-MF
        // 3- -'yi kullanarak split yapalim [Ali, Can, 11, H, MF]
        // 4- split yaptigimiz array'den isim bilgisini alalim 0.index
        // 5- eger value'den aldigimiz isim, aranan isim ile ayni ise
        //    true dondurup, for-each'i bitirelim
        // 6- for-each bittiginde true olmadiysa false dondurelim


        for (String eachValue : valuesCollection
        ) {

            String[] valueArr = eachValue.split("-");
            String valuedekiIsim = valueArr[0];
            if (valuedekiIsim.equalsIgnoreCase(isim)) {
                return true;
            }
        }

        return false;

    }

    public static void soyisimIleOgrenciListesiYazdirma(Map<Integer, String> ogrenciMap, String soyisim) {

        // 1- map'deki value'leri bir collection olarak kaydedelim
        //    [Ali-Can-11-H-MF, Veli-Cem-10-K-TM, Ali-Cem-11-K-TM, Ayse-Can-10-H-MF, Sevgi-Cem-11-M-TM, Sevgi-Can-10-K-MF]
        Collection<String> ogrenciValueCollection = ogrenciMap.values();
        // listenin ilk satiri olarak basliklari yazdiralim
        System.out.println("Isim  Soyisim  Sinif Sube");

        // 2- for-each ile her bir value bilgisini ele alalim Ali-Can-11-H-MF
        // 3- value'yu - ile split yapip bir array elde edelim [Ali, Can, 11, H, MF]
        // 4- array'in 1.index'indeki soyisme bakip, aranan soyisim ile ayni ise
        //    isim, soyisim, sinif ve sube bilgilerini yazdiralim

        for (String eachValue : ogrenciValueCollection
        ) {
            String[] valueArr = eachValue.split("-");
            String valueSoyisim = valueArr[1];

            if (valueSoyisim.equalsIgnoreCase(soyisim)) {
                System.out.println(valueArr[0] + "  " +
                        valueArr[1] + "  " +
                        valueArr[2] + "  " +
                        valueArr[3]);
            }

        }


    }

    public static void subeListesiYazdirma(Map<Integer, String> ogrenciMap, String sinif, String sube) {

        Collection<String> valueCollection = ogrenciMap.values();

        System.out.println("Isim   Soyisim");

        for (String eachValue : valueCollection
        ) {

            String[] valueArr = eachValue.split("-"); // [Ali, Can, 11, H, MF]

            if (valueArr[2].equalsIgnoreCase(sinif) && valueArr[3].equalsIgnoreCase(sube)) {

                System.out.println(valueArr[0] + "  " + valueArr[1]);
            }
        }
    }

    public static Map<Integer, String> numaraIleSubeDegistirme(Map<Integer, String> ogrenciMap, int okulNo, String yeniSubeIsmi) {

        // 1- okul numarasini biliyoruz, direk ogrenci value'ye ulasabiliriz

        String ogrenciValue = ogrenciMap.get(okulNo); // Ayse-Can-10-H-MF

        String[] valueArr = ogrenciValue.split("-"); // [Ayse, Can, 10, H, MF]

        // 2- sube ismini guncelleyelim

        valueArr[3] = yeniSubeIsmi; //  [Ayse, Can, 10, M, MF]

        // 3- array'deki guncel bilgileri yeniden value formatinda bir String yapalim

        String yeniValue = valueArr[0] + "-" + valueArr[1] + "-" + valueArr[2] + "-" +
                valueArr[3] + "-" + valueArr[4];

        // 4- ogrenci no yani key ile yeni value'yu map'e ekleyelim

        ogrenciMap.put(okulNo, yeniValue);

        return ogrenciMap;
    }

    public static void sinifListesiYazdirma(Map<Integer, String> ogrenciMap, String sinif) {

        // verilen bir siniftaki ogrencilerin no,isim,soyisim,bolumlerini
        //bir liste olarak yazdiran bir method olusturun.

        System.out.println("No isim soyisim bolum");
        System.out.println("=====================");

        Set<Map.Entry<Integer, String>> entrySeti = ogrenciMap.entrySet();

        for (Map.Entry<Integer, String> eachEntry : entrySeti
        ) { // 101=Ali-Can-11-H-MF

            // 1- entryden value'yu alalım.

            String entryValue = eachEntry.getValue();// Ali-Can-11-H-MF

            //2- bu value parcalayalım ve bir array'e store edelim.

            String[] valueArr = entryValue.split("-");//[Ali,Can,11,H,MF]

            // sinif bilgisini kontrol edip
            // istenen sinif ile ayni ise, istenen bilgileri yazdiralim.

            if (valueArr[2].equalsIgnoreCase(sinif)) {

                System.out.println(eachEntry.getKey() + " " +
                        valueArr[0] + " " +
                        valueArr[1] + " " +
                        valueArr[4]);
            }


        }

    }

    public static void bolumListesiOlusturma(Map<Integer, String> ogrenciMap, String bolum) {

        System.out.println("No isim soyisim sinif");
        System.out.println("=====================");

        Set<Map.Entry<Integer, String>> entrySeti = ogrenciMap.entrySet();

        for (Map.Entry<Integer, String> eachEntry : entrySeti
        ) { // 101=Ali-Can-11-H-MF

            // 1- entryden value'yu alalım.

            String entryValue = eachEntry.getValue();// Ali-Can-11-H-MF

            //2- bu value parcalayalım ve bir array'e store edelim.

            String[] valueArr = entryValue.split("-");//[Ali,Can,11,H,MF]

            // bolum bilgisini kontrol edip
            // istenen bolum ile ayni ise, istenen bilgileri yazdiralim.

            if (valueArr[4].equalsIgnoreCase(bolum)) {

                System.out.println(eachEntry.getKey() + " " +
                        valueArr[0] + " " +
                        valueArr[1] + " " +
                        valueArr[2] + " " 
                        );
            }


        }
    }

    public static Map<Integer, String> soyisimleriBuyukHarfYap(Map<Integer, String> ogrenciMap) {

        // 1- entrySet olusturalım
        Set<Map.Entry<Integer, String>> entrySeti = ogrenciMap.entrySet();

        // 2- foreach loop ile her bir entry elden gecirip, soyisimleri buyuk harf yapalim.
        
        for (Map.Entry<Integer, String> eachEntry : entrySeti
        ) {

            // 3- entry'den value'yu alalım.

            String entryValue = eachEntry.getValue();// ali-Can-11-H-MF

            //4- SOYİSİM BİLGİSİNE ULASİP DEGİSTİREBİLMEK İCİN PARCALA

            String[] entryValueArr = entryValue.split("-");//[Ali,Can,11,H,MF]
//5- SOYİSMİ BUYUK HARF YAPALİM.

            entryValueArr[1] = entryValueArr[1].toUpperCase();//[Ali,CAN,11,H,MF]

            //6- degisikligi yaptiktan sonra yeniden birlestirmeleri yapip
            //map'uptade etmeliyiz.

            // setValue() kullanarak value'nun yeni haline update edelim. 

            eachEntry.setValue(entryValueArr[0] + "-" +
                               entryValueArr[1] + "-" +
                                entryValueArr[2] + "-" +
                                entryValueArr[3] + "-" +
                               entryValueArr[4] + "-");
        }
        return ogrenciMap;
    }


    public static void tumListeYazdir(Map<Integer, String> ogrenciMap, String sinif) {

        Set<Map.Entry<Integer,String>> ogrenciEntrySet=ogrenciMap.entrySet();
        System.out.println("No   Ogrenci Bilgileri");
        System.out.println("======================");

        for (Map.Entry<Integer,String> eachEntry: ogrenciEntrySet
        ) {
            System.out.println(eachEntry);
        }
    }

    public static Map<Integer, String> siniflariArtir(Map<Integer, String> ogrenciMap) {

        // map'de degisikligi yaptiktan sonra
        // map'i update etmenin en kolay yolu setEntry()

        Set<Map.Entry<Integer,String>> entrySeti=ogrenciMap.entrySet();

        //her bir entry elemanini ele alabilmek icin foreach olustururuz.

        for (Map.Entry<Integer, String> eachEntry : entrySeti
        ) {// 101-Ali-Can-11-H-MF

            String entryValue = eachEntry.getValue();// Ali-Can-11-H-MF

            String[] entryValueArr = entryValue.split("-");//[Ali,Can,11,H,MF]

            int sinifInt=Integer.parseInt(entryValueArr[2]);

            if (sinifInt==12){
                entryValueArr[2]="Mezun";

            }else {

                entryValueArr[2]=sinifInt+1+"";

            }
            // sinif bilgisini guncelledik.
            //bu guncellemeyi map'e islememiz lazim
            eachEntry.setValue(entryValueArr[0] + "-" +
                    entryValueArr[1] + "-" +
                    entryValueArr[2] + "-" +
                    entryValueArr[3] + "-" +
                    entryValueArr[4] + "-");
        }
            return ogrenciMap;
    }

    public static void sinifSiraliListeOlustur(Map<Integer, String> ogrenciMap) {

        //101-Ali-Can-11-H-MF
        // 11 H Ali Can 101

        // tum ogrenci listesini
        // sinif sube isim soyisim no seklinde
        // dogal sirali olarak
        // yazdiran bir method olsun

        Set<Map.Entry<Integer, String>> entrySeti = ogrenciMap.entrySet();
 Set<String> siraliOgrenciSeti= new TreeSet<>();

        for (Map.Entry<Integer, String> eachEntry : entrySeti) {

            String entryValue=eachEntry.getValue();// Ali-Can-11-H-MF

            String[] entryValueAarr=entryValue.split("-");//[Ali,Can,11,H,MF]

            // Entry' den istenen bilgileri alipvyeni bir string olusturacagız
            // ve bu sirali stringleri sirali olarak yazdiracagiz.

            String istenenFormattakiBilgi=entryValueAarr[2]+" "+
                                          entryValueAarr[3]+" "+
                                          entryValueAarr[0]+" "+
                                           entryValueAarr[1]+" "+
                                          eachEntry.getKey();

            System.out.println("sinif sube isim soyisim no ");
            System.out.println("===================");

            for (String each :siraliOgrenciSeti
                 ) {
                System.out.println(each);

            }

            siraliOgrenciSeti.add(istenenFormattakiBilgi);
        }


    }

    public static void isimSoyisimSiraliListeYazdir(Map<Integer, String> ogrenciMap) {

        Set<Map.Entry<Integer, String>> entrySeti = ogrenciMap.entrySet();

        Set<String> siraliOgrenciSeti= new TreeSet<>();

        for (Map.Entry<Integer, String> eachEntry : entrySeti) {

            String entryValue=eachEntry.getValue();// Ali-Can-11-H-MF

            String[] entryValueAarr=entryValue.split("-");//[Ali,Can,11,H,MF]

            // Entry' den istenen bilgileri alipvyeni bir string olusturacagız
            // ve bu sirali stringleri sirali olarak yazdiracagiz.

            String istenenFormattakiBilgi=entryValueAarr[0]+" "+
                    entryValueAarr[1]+" "+
                    eachEntry.getKey()+" "+
                    entryValueAarr[2]+" "+
                    entryValueAarr[3]+" ";

// sirali seti' yazdiralim
            System.out.println("sinif sube isim soyisim no ");
            System.out.println("===================");

            for (String each :siraliOgrenciSeti
            ) {
                System.out.println(each);

            }

            siraliOgrenciSeti.add(istenenFormattakiBilgi);
        }





    }
}

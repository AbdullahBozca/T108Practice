package ocak08.ogrenci;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    /*

    ============= İŞLEMLER =============
		 1-EKLEME
		 2-ARAMA
		 3-LİSTELEME
		 4-SİLME
		 Q-ÇIKIŞ

	SEÇİMİNİZ:

  ŞEKLİNDE BİR MENÜ OLUŞTURULMALI.

3. ARAMA VE SİLME İŞLEMLERİ KİMLİK NO YA GÖRE YAPILMALIDIR.
     */
    Scanner scan = new Scanner(System.in);
    static int numara = 1000;

    ArrayList<Ogrenci> ogrList = new ArrayList<>();

    void islemler() {
        System.out.print("============= İŞLEMLER =============\n" +
                "\t\t 1-EKLEME\n" +
                "\t\t 2-ARAMA\n" +
                "\t\t 3-LİSTELEME\n" +
                "\t\t 4-SİLME\n" +
                "\t\t Q-ÇIKIŞ\n" +
                "\n" +
                "\tSEÇİMİNİZ:");

        try {
            int secim = scan.nextInt();
            switch (secim) {
                case 1: {
                    ekleme();
                }
                case 2: {
                    System.out.print("ARANACAK TC NOYU GİRİNİZ: ");
                    arama(scan.next());
                }
                case 3: {
                    listeleme();

                }
                case 4: {
                    silme();
                }
                default: {
                    System.out.println("HATALI DEĞER GİRDİNİZ!!!!");
                    islemler();
                }
            }

        } catch (InputMismatchException e) {
            String islem = scan.next();
            if (islem.equalsIgnoreCase("q")) {
                System.out.println("******SİSTEMDEN ÇIKILIYOR******");
                System.exit(0);
            } else {
                System.out.println("HATALI GİRİŞ YAPILDI!!!");
                islemler();
            }

        }
    }

    private void silme() {
        System.out.print("SİLİNECEK ÖĞRENCİNİN TC NOSUNU GİRİNİZ: ");
        String tcNo = scan.next();
        boolean kontrol = true;
        for (int i = 0; i <= ogrList.size(); i++) {
            if ((ogrList.get(i).getTcNo()).equals(tcNo)) {
                ogrList.remove(i);
                kontrol = false;
                listeleme();
                islemler();
            }
        }
        if (kontrol) {
            System.out.println("BU TC NOYA AİT ÖĞRENCİ YOKTUR!!!");
            islemler();
        }
    }

    private void listeleme() {
        for (Ogrenci each : ogrList) {
            System.out.println(each);
            System.out.println();
        }
        islemler();
    }

    private void arama(String tcNo) {
        boolean kontrol = true;
        for (Ogrenci each : ogrList) {
            if (each.getTcNo().equals(tcNo)) {
                System.out.println("ARANAN ÖĞRENCİ= " + each);
                islemler();
            }
        }
            System.out.println("BU TC NOYA AİT ÖĞRENCİ YOKTUR!!!");
            islemler();

    }

    private void ekleme() {
        /*
         -AD SOYAD
	-KİMLİK NO
	-YAŞ
	-NUMARA
	-SINIF
         */
        scan.nextLine();
        System.out.print("ÖĞRENCİ ADI: ");
        String ad = scan.nextLine();
        System.out.print("ÖĞRENCİ SOYADI: ");
        String sAd = scan.nextLine();
        System.out.print("ÖĞRENCİ KİMLİK NO: ");
        String tcNo = tcNoKontrol(scan.next());
        System.out.print("ÖĞRENCİ YAŞI: ");
        int yas = scan.nextInt();
        System.out.print("ÖĞRENCİ SINIFI: ");
        String sinif = scan.next();
        Ogrenci ogrenci = new Ogrenci(ad, sAd, tcNo, yas, ++numara, sinif);
        ogrList.add(ogrenci);
        listeleme();
        islemler();

    }

    private String tcNoKontrol(String tcNo) {
        String tcNoArr[] = tcNo.split("");
        boolean kontrol = true;
        for (String each : tcNoArr) {
            if (!Character.isDigit(each.charAt(0))) {
                kontrol = false;
            }
        }
        if (!kontrol) {
            System.out.println("GİRİLEN TC NO HATALI!!!");
            tcNoKontrol(scan.next());
            //menu();
        }
        return tcNo;
    }
}

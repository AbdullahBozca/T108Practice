package ocak16;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OgretmenIslemler implements IIslemler {
    Scanner scan = new Scanner(System.in);
    static int sicilNo = 1000;
    ArrayList<Ogretmen> ogretmenList = new ArrayList<>();

    void ogrtMenu() {
        System.out.println("============= İŞLEMLER =============\n" +
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
                    arama();
                }
                case 3: {
                    listeleme();
                }
                case 4: {
                    silme();
                }
            }
        } catch (InputMismatchException e) {
            String secim = scan.next();
            if (secim.equalsIgnoreCase("q")) {
                AnaMenu anaMenu = new AnaMenu();
                anaMenu.menu();
            } else {
                System.out.println("HATALI GİRİŞ YAPILDI");
                ogrtMenu();
            }
        }
    }


    @Override
    public void ekleme() {
        System.out.print("ÖĞRETMENİN ADINI GİRİNİZ: ");
        scan.nextLine();
        String ad = scan.nextLine();
        System.out.print("ÖĞRETMENİN SOYADINI GİRİNİZ: ");
        String sAd = scan.nextLine();
        System.out.print("ÖĞRETMENİN TC NO SUNU GİRİNİZ: ");
        String tcNo = scan.next();
        System.out.print("ÖĞRETMİNİN YAŞINI GİRİNİZ: ");
        int yas = scan.nextInt();
        scan.nextLine();
        System.out.print("ÖĞRETMENİN BÖLÜMÜNÜ GİRİNİZ: ");
        String bolum = scan.nextLine();
        Ogretmen ogretmen = new Ogretmen(ad, sAd, tcNo, yas, bolum, sicilNo++);
        ogretmenList.add(ogretmen);

    }

    @Override
    public void arama() {

    }

    @Override
    public void listeleme() {

    }

    @Override
    public void silme() {

    }
}

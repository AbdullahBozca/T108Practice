package ocak02;

import java.util.Scanner;

public class Atm {
    /*
    ATM
Kullanicidan giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,


Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis islemleri olacaktır.


Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,

Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekraninageri donsun.

Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
     */
    static Scanner scan = new Scanner(System.in);
    static String kartNo = "1234123412341234";
    static String sifre = "1234";

    static double bakiye = 50000;

    public static void main(String[] args) {
        giris();
    }

    private static void giris() {
        System.out.print("Kart Numarası giriniz: ");
        String kKartNo = scan.nextLine().replace(" ", "");
        System.out.print("Şifre giriniz: ");
        String kSifre = scan.next();

        if (kSifre.equals(sifre) && kKartNo.equals(kartNo)) {
            menu();
        } else {
            System.out.println("Kart No veya Şifre hatalı!!!");
            scan.nextLine(); // Dummy-----> ard arda kullanılan scanner objelerinde oluşan hatayı önlemek için kullanılır
            giris();
        }

    }

    private static void menu() {
        System.out.print("******WISEQARTER BANK*****\n" +
                "1. BAKİYE SORGULAMA\n" +
                "2. PARA YATIRMA\n" +
                "3. PARA ÇEKME\n" +
                "4. PARA GÖNDERME\n" +
                "5. ŞİFRE DEĞİŞTİRME\n" +
                "6. ÇIKIŞ\n" +
                "SEÇİMİNİZ: ");
        int secim = scan.nextInt();

        switch (secim) {
            case 1: {
                //bakiyeSorgula();
                BakiyeSorgula bakiyeSorgula=new BakiyeSorgula();
                bakiyeSorgula.bakiyeGoster();
                break;
            }
            case 2: {
                System.out.print("YATIRMAK İSTEDİĞİNİZ TUTARI GİRİNİZ: ");
                double miktar = scan.nextDouble();
                paraYatirma(miktar);
                break;
            }
            case 3: {
                paraCekme();
                break;
            }
            case 4: {
                paraGonderme();
                break;
            }
            case 5: {
                sifreDegistir();
                break;
            }
            case 6: {
                System.out.println("*****GÜLE GÜLE*****");
                System.exit(0);
            }
            default:{
                System.out.println("YANLIŞ DEĞER GİRDİNİZ!!!");
                menu();
            }
        }
    }

    private static void sifreDegistir() {
        System.out.print("ESKİ ŞİFREYİ GİRİNİZ: ");
        String eSifre=scan.next();
        if (eSifre.equals(sifre)) {
            System.out.print("YENİ ŞİFRE GİRİNİZ: ");
            sifre=scan.next();
            scan.nextLine();
            giris();
        }else {
            System.out.println("ESKİ ŞİFREYİ YANLIŞ GİRDİNİZ!!!");
            sifreDegistir();
        }
    }

    private static void paraGonderme() {
        scan.nextLine();
        System.out.print("IBAN NO GİRİNİZ(IBAN NO TR İLE BAŞLAMALI): ");
        String iban = scan.nextLine().toUpperCase().replace(" ", "");

        if (iban.length() == 26 && iban.startsWith("TR")) {
            System.out.print("GÖNDERİLECEK MİKTARI GİRİNİZ: ");
            double miktar = scan.nextDouble();
            if (miktar <= bakiye) {
                bakiye -= miktar;
                bakiyeSorgula();
            } else {
                System.out.println("GÖNDERMEK İSTEDİĞİNİZ MİKTAR BAKİYEDEN BÜYÜK!!!");
                paraGonderme();
            }

        }
    }

    private static void paraCekme() {
        System.out.print("ÇEKMEK İSTEDİĞİNİZ MİKTARI GİRİNİZ: ");
        double miktar = scan.nextDouble();

        if (miktar <= bakiye) {
            bakiye -= miktar;
            bakiyeSorgula();
        } else {
            System.out.println("ÇEKMEK İSTEDİĞİNİZ MİKTAR BAKİYEDEN BÜYÜK!!!");
            paraCekme();
        }
    }


    private static void paraYatirma(double miktar) {
        bakiye += miktar;
        bakiyeSorgula();
    }

    private static void bakiyeSorgula() {
        System.out.println("Bakiyeniz: " + bakiye + " TL");
        menu();
    }
}

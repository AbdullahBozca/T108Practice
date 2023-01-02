package aralik13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q04 {
    /*
     * Basit bir 5 ürünlü manav alisveris programi yaziniz.
     *
     * 1. Adim : urun listesinden urun sectir ve kac kilo oldugunu sor.
     * 2. Adim : Baska bir urun almak isteyip istemedigini sor. istemiyorsa toplam miktari
     * goster, istiyorsa tekrar urun sectir. Bu islemi alisverisi bitirmek isteyene
     * kadar tekrarla.
     * 3. Adim : Musteri her urun sectiginde, aldigi urunun fiyatini
     * toplam fiyata ekle.
     * 4. Adim : Alisveris bitince toplam odemesi gereken tutari goster.
     *
     */
    static ArrayList<String> urunList = new ArrayList<>(Arrays.asList("Portakal", "Mandalina", "Elma", "Ispanak", "Muz"));
    static ArrayList<Integer> fiyatList = new ArrayList<>(Arrays.asList(10, 12, 15, 10, 18));
    static double toplam = 0;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("******DOYURAN MARKET******");
        menu();
    }

    private static void menu() {

        for (int i = 1; i <= 5; i++) {
            System.out.println(i  + ". ürün: " + urunList.get(i-1) + " fiyatı: " + fiyatList.get(i-1) + " TL");
        }

        System.out.println("Seçmek istediğiniz ürünün kodunu giriniz: ");
        int urun = scan.nextInt();
        System.out.println("Miktar giriniz: ");
        double miktar = scan.nextInt();
        toplam += miktar * fiyatList.get(urun - 1);

        System.out.println("Alışverişe devam etmek istiyormusunuz? E/H");
        char secim = scan.next().charAt(0);

        if (secim == 'e' || secim == 'E') {
            menu();
        } else {
            System.out.println("Ödenecek tutar: " + toplam);
        }
    }
}

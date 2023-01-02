package ocak02_2;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Birinci sayıyı giriniz: ");
        int sayi1=scan.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        int sayi2=scan.nextInt();

        System.out.println("Yapılacak işlemi giriniz(+,-,*,/)");
        char islem=scan.next().charAt(0);
        Islemler islemler=new Islemler();
        switch (islem){
            case '+':{
                System.out.println("Toplam = " + islemler.toplama(sayi1, sayi2));
                break;
            }
            case '-':{
                System.out.println("Fark= "+islemler.cikartma(sayi1, sayi2));
                break;
            }
            case '*':{
                System.out.println("Çarpım: "+islemler.carpma(sayi1, sayi2));
                break;
            }
            case '/':{
                System.out.println("Bölüm: "+islemler.bolme(sayi1, sayi2));
                break;
            }
        }
    }
}

package ocak08.geometrikSekiller;

import java.util.Scanner;

public class Dikdortgen implements IIslemler{
    Scanner scan=new Scanner(System.in);
    int kenar1=0;
    int kenar2=0;
    @Override
    public void alan() {
        System.out.print("1. kenar uzunluğunu giriniz: ");
        kenar1=scan.nextInt();
        System.out.println("2. kenar uzunluğunu giriniz: ");
        kenar2=scan.nextInt();
        System.out.println("Alan: "+(kenar1*kenar2));
    }

    @Override
    public void cevre() {
        System.out.println("Çevre: "+(2*(kenar2+kenar1)));
    }
}

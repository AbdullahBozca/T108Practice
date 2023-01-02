package aralik13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q03 {
    //Girilen desimal değeri binary değere çeviren metodu oluşturunuz.
    //Örnek: 12 = 1 1 0 0
    public static void main(String[] args) {
        System.out.println("Binary ifadeye çevirilecek desimal değeri giriniz: ");
        Scanner scan=new Scanner(System.in);
        int desimalSayi= scan.nextInt();
        System.out.println(desimalSayi+" sayısının binary karşılığı: "+binaryCevir(desimalSayi));
    }

    private static ArrayList binaryCevir(int desimalSayi) {
        ArrayList<Integer> binary=new ArrayList<>();
        while (desimalSayi>=1){
            binary.add(desimalSayi%2);//0,1,1
            desimalSayi/=2;
        }
        //Collections.reverse(binary);
        ArrayList<Integer> binaryTers=new ArrayList<>();
        for (int i = binary.size()-1; i>=0; i--) {
            binaryTers.add(binary.get(i));
        }
        return binaryTers;// 1, 1, 0
    }
}

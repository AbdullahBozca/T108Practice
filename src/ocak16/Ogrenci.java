package ocak16;

public class Ogrenci extends Kisi {
    //Ad-Soyad,  kimlik No, yaş, numara, sınıf

    private int numara;
    private String sinif;

    public Ogrenci(String ad, String sad, String tcNo, int yas, int numara, String sinif) {
        super(ad, sad, tcNo, yas);
        this.numara = numara;
        this.sinif = sinif;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    @Override
    public String toString() {
        return super.toString() +" "+ "numara=" + numara +
                ", sinif='" + sinif;
    }
}

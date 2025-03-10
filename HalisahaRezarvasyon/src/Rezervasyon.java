import java.util.Date;

public class Rezervasyon {
    private String isim;
    private Date tarih;
    private String saat;
    private int sahaNumarasi;

    // Constructor, Getter ve Setter metotları

    public Rezervasyon(String isim, Date tarih, String saat, int sahaNumarasi) {
        this.isim = isim;
        this.tarih = tarih;
        this.saat = saat;
        this.sahaNumarasi = sahaNumarasi;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public int getSahaNumarasi() {
        return sahaNumarasi;
    }

    public void setSahaNumarasi(int sahaNumarasi) {
        this.sahaNumarasi = sahaNumarasi;
    }

}

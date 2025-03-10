public class Kullanici {
    private String isim;
    private String email;
    private String sifre;

    public Kullanici(String isim, String email, String sifre) {
        this.isim = isim;
        this.email = email;
        this.sifre = sifre;
    }

    public String getIsim() {
        return isim;
    }

    public String getEmail() {
        return email;
    }

    public String getSifre() {
        return sifre;
    }
}

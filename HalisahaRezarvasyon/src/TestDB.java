public class TestDB {
    public static void main(String[] args) {
        if (VeritabaniBaglanti.baglan() != null) {
            System.out.println("MySQL veritabanı bağlantısı başarılı!");
        } else {
            System.out.println("Bağlantı başarısız!");
        }
    }
}


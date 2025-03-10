import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KullaniciDAO kullaniciDAO = new KullaniciDAO();
        RezervasyonDAO rezervasyonDAO = new RezervasyonDAO();  // RezervasyonDAO ekledik

        System.out.println("1. Kayıt Ol");
        System.out.println("2. Giriş Yap");
        System.out.print("Seçim: ");
        int secim = scanner.nextInt();
        scanner.nextLine();

        Kullanici kullanici = null; // Giriş yapan kullanıcı objesi

        if (secim == 1) {
            // Kayıt Olma
            System.out.print("İsim: ");
            String isim = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Şifre: ");
            String sifre = scanner.nextLine();

            Kullanici yeniKullanici = new Kullanici(isim, email, sifre);
            kullaniciDAO.kayitOl(yeniKullanici);
            System.out.println("Kayıt başarılı! Giriş yapın.");
        } else if (secim == 2) {
            // Giriş Yapma
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Şifre: ");
            String sifre = scanner.nextLine();

            kullanici = kullaniciDAO.girisYap(email, sifre); // Giriş yapan kullanıcıyı al
            if (kullanici != null) {
                System.out.println("Giriş başarılı!");//
            } else {
                System.out.println("Email veya şifre hatalı!");
                scanner.close();
                return;  // Giriş başarısızsa uygulama sonlansın
            }
        } else {
            System.out.println("Geçersiz seçim!");
            scanner.close();
            return;  // Geçersiz seçimde de uygulama sonlansın
        }

        // Kullanıcı giriş yaptıysa rezervasyon yapabilmesi için
        if (kullanici != null) {
            // Rezervasyon işlemi
            System.out.println("\nRezervasyon yapmak için aşağıdaki adımları takip edin.");

            System.out.print("İsminizi girin: "); // DÜZELTİLDİ
            String isim = scanner.nextLine();

            System.out.print("Rezervasyon tarihi (yyyy-MM-dd) girin: ");
            String tarihStr = scanner.nextLine();

            System.out.print("Rezervasyon saati (HH:mm) girin: ");
            String saat = scanner.nextLine();

            System.out.print("Hangi saha numarası için rezervasyon yapmak istersiniz (1, 2, 3, ...): ");
            int sahaNumarasi = scanner.nextInt();

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date tarih = dateFormat.parse(tarihStr);

                // Rezervasyon objesi oluştur
                Rezervasyon rezervasyon = new Rezervasyon(isim, tarih, saat, sahaNumarasi);

                // Rezervasyonu veritabanına kaydet
                if (rezervasyonDAO.rezervasyonYap(rezervasyon)) {
                    System.out.println("Rezervasyon başarılı!");
                } else {
                    System.out.println("Rezervasyon yapılamadı.");
                }
            } catch (Exception e) {
                System.out.println("Hata: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

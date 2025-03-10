import java.sql.*;

public class KullaniciDAO {
    private static Connection baglanti = VeritabaniBaglanti.baglan();

    public boolean kayitOl(Kullanici kullanici) {
        String sql = "INSERT INTO kullanicilar (isim, email, sifre) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = baglanti.prepareStatement(sql)) {
            stmt.setString(1, kullanici.getIsim());
            stmt.setString(2, kullanici.getEmail());
            stmt.setString(3, kullanici.getSifre());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Kayıt hatası: " + e.getMessage());
            return false;
        }
    }

    public Kullanici girisYap(String email, String sifre) {
        String sql = "SELECT * FROM kullanicilar WHERE email = ? AND sifre = ?";
        try (PreparedStatement stmt = baglanti.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, sifre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String isim = rs.getString("isim");
                return new Kullanici(isim, email, sifre);
            }
        } catch (SQLException e) {
            System.out.println("Giriş hatası: " + e.getMessage());
        }
        return null; // Kullanıcı bulunamazsa null döner
    }
}

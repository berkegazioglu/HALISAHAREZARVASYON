import java.sql.*;

public class RezervasyonDAO {
    private static Connection baglanti = VeritabaniBaglanti.baglan();

    public boolean rezervasyonYap(Rezervasyon rezervasyon) {
        String sql = "INSERT INTO rezervasyonlar (isim, tarih, saat, saha_numarasi) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = baglanti.prepareStatement(sql)) {
            stmt.setString(1, rezervasyon.getIsim());
            stmt.setDate(2, new java.sql.Date(rezervasyon.getTarih().getTime()));
            stmt.setString(3, rezervasyon.getSaat());
            stmt.setInt(4, rezervasyon.getSahaNumarasi());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Rezervasyon hatası: " + e.getMessage());
            return false;
        }
    }
}


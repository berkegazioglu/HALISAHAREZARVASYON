import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeritabaniBaglanti {
    // MySQL bağlantı bilgileri
    private static final String URL = "jdbc:mysql://localhost:3306/halisaha";
    private static final String USERNAME = "root";  // MySQL kullanıcı adı
    private static final String PASSWORD = "Berke59*";  // MySQL şifren

    public static Connection baglan() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL sürücüsünü yükle
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC sürücüsü bulunamadı!");
            return null;
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantı hatası: " + e.getMessage());
            return null;
        }
    }
}


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistema_ventas",
                    "root", // tu usuario
                    "Josselyn1104"
            );
            System.out.println("✅ Conectado a MySQL");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        return con;
    }
}

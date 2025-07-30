import java.sql.*;

public class UsuarioDAO {
    public static String login(String usuario, String clave) {
        try (Connection con = ConnectionDB.getConnection()) {
            String sql = "SELECT rol FROM usuarios WHERE usuario=? AND clave=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("rol");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

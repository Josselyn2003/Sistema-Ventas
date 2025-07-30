import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public static void insertar(Cliente c) {
        String sql = "INSERT INTO clientes(nombre, cedula) VALUES(?,?)";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCedula());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection con = ConnectionDB.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("cedula")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    public static void actualizar(Cliente c) {
        String sql = "UPDATE clientes SET nombre=?, cedula=? WHERE id=?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCedula());
            ps.setInt(3, c.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}

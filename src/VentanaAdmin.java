import javax.swing.*;

public class VentanaAdmin extends JFrame {
    public VentanaAdmin() {
        setTitle("Panel Administrador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // 🔹 Crear botones
        JButton btnProductos = new JButton("Gestionar Productos");
        JButton btnClientes = new JButton("Gestionar Clientes");
        JButton btnUsuarios = new JButton("Gestionar Usuarios");

        // 🔹 Panel para organizar los botones
        JPanel panel = new JPanel();
        panel.add(btnProductos);
        panel.add(btnClientes);
        panel.add(btnUsuarios);

        add(panel);

        // 🔹 Cuando hagan clic, se abre la ventana de productos o clientes
        btnProductos.addActionListener(e -> new VentanaProductos().setVisible(true));
        btnClientes.addActionListener(e -> new VentanaClientes().setVisible(true));
    }
}

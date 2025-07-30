import javax.swing.*;

public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnLogin;

    public Login() {
        // 🔹 Configuración de la ventana
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 🔹 Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // 🔹 Campos y etiquetas
        txtUsuario = new JTextField();
        txtClave = new JPasswordField();
        btnLogin = new JButton("Iniciar Sesión");

        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtClave);
        panel.add(btnLogin);

        add(panel);

        // 🔹 Acción del botón
        btnLogin.addActionListener(e -> iniciarSesion());
    }

    private void iniciarSesion() {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());

        // 🔹 Consultar en la base de datos
        String rol = UsuarioDAO.login(usuario, clave);

        if (rol != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + rol);

            if (rol.equals("admin")) {
                new VentanaAdmin().setVisible(true);
            } else if (rol.equals("cajero")) {
                new VentanaCajero().setVisible(true);
            }

            dispose(); // Cierra la ventana de login
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}

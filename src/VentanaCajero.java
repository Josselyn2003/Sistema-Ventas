import javax.swing.*;

public class VentanaCajero extends JFrame {
    public VentanaCajero() {
        setTitle("Panel Cajero");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnRegistrarCliente = new JButton("Registrar Cliente");
        JButton btnCrearFactura = new JButton("Crear Factura");

        JPanel panel = new JPanel();
        panel.add(btnRegistrarCliente);
        panel.add(btnCrearFactura);

        add(panel);
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaClientes extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaClientes() {
        setTitle("Gestión de Clientes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Cédula"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRefrescar);

        add(scroll, "Center");
        add(panelBotones, "South");

        btnRefrescar.addActionListener(e -> cargarClientes());
        btnAgregar.addActionListener(e -> agregarCliente());
        btnEditar.addActionListener(e -> editarCliente());
        btnEliminar.addActionListener(e -> eliminarCliente());

        cargarClientes();
    }

    private void cargarClientes() {
        modelo.setRowCount(0);
        for (Cliente c : ClienteDAO.listar()) {
            modelo.addRow(new Object[]{c.getId(), c.getNombre(), c.getCedula()});
        }
    }

    private void agregarCliente() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String cedula = JOptionPane.showInputDialog("Cédula:");

        ClienteDAO.insertar(new Cliente(0, nombre, cedula));
        cargarClientes();
    }

    private void editarCliente() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int id = (int) modelo.getValueAt(fila, 0);
            String nombre = JOptionPane.showInputDialog("Nombre:", modelo.getValueAt(fila, 1));
            String cedula = JOptionPane.showInputDialog("Cédula:", modelo.getValueAt(fila, 2));

            ClienteDAO.actualizar(new Cliente(id, nombre, cedula));
            cargarClientes();
        }
    }

    private void eliminarCliente() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int id = (int) modelo.getValueAt(fila, 0);
            ClienteDAO.eliminar(id);
            cargarClientes();
        }
    }
}

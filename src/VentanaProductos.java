import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaProductos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaProductos() {
        setTitle("Gestión de Productos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Stock"}, 0);
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

        btnRefrescar.addActionListener(e -> cargarProductos());
        btnAgregar.addActionListener(e -> agregarProducto());
        btnEditar.addActionListener(e -> editarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());

        cargarProductos();
    }

    private void cargarProductos() {
        modelo.setRowCount(0);
        for (Producto p : ProductoDAO.listar()) {
            modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getStock()});
        }
    }

    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock:"));

        ProductoDAO.insertar(new Producto(0, nombre, precio, stock));
        cargarProductos();
    }

    private void editarProducto() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int id = (int) modelo.getValueAt(fila, 0);
            String nombre = JOptionPane.showInputDialog("Nombre:", modelo.getValueAt(fila, 1));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:", modelo.getValueAt(fila, 2)));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock:", modelo.getValueAt(fila, 3)));

            ProductoDAO.actualizar(new Producto(id, nombre, precio, stock));
            cargarProductos();
        }
    }

    private void eliminarProducto() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int id = (int) modelo.getValueAt(fila, 0);
            ProductoDAO.eliminar(id);
            cargarProductos();
        }
    }
}

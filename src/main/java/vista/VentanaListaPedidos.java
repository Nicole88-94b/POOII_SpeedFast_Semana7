package vista;

import dao.PedidoDAO;
import modelo.PedidoResumen;

import  javax.swing.*;
import  javax.swing.table.DefaultTableModel;
import  java.awt.*;

/**
 * Ventana que presenta los pedidos registrados en una tabla.
 * Permite actualizar la información para reflejar asignaciones y cambios de estado.
 */
public class VentanaListaPedidos extends JFrame {
    private final PedidoDAO pedidoDAO = new PedidoDAO();
    private DefaultTableModel modeloTabla;
    private JTable tablaPedidos;


    public VentanaListaPedidos() {
        arquitecturaVentana();
    }

    private void arquitecturaVentana() {
        tamanoVentana();
        configuracionPanel();
        setLocationRelativeTo(null);
    }

    private void tamanoVentana() {
        setTitle("Lista de Pedidos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 400);
        setLocation(500, 300);
        getContentPane().setBackground(new Color(241, 245, 244));
    }

    private void configuracionPanel() {
        setLayout(new BorderLayout(0, 10));
        listadoPedidos();
        add(panelBotones(), BorderLayout.SOUTH);
    }

    private void listadoPedidos () {
        String[] columnas = {"ID", "Dirección", "Tipo", "Distancia", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPedidos = new JTable(modeloTabla);

        add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);
        cargarPedidos();
    }

    private JPanel panelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnActualizar = new JButton("Actualizar");
        JButton btnSalir = new JButton("Salir");

        btnActualizar.addActionListener(e -> cargarPedidos());
        btnSalir.addActionListener(e -> dispose());

        panel.add(btnActualizar);
        panel.add(btnSalir);

        return panel;
    }

    private void cargarPedidos() {
        modeloTabla.setRowCount(0);
    for (PedidoResumen pedido : pedidoDAO.listarTodos()){
        Object[] fila = {
                pedido.getIdPedido(),
                pedido.getDireccion(),
                pedido.getTipo(),
                pedido.getDistanciaKm(),
                pedido.getEstado() };
        modeloTabla.addRow(fila);
    }
    }
}

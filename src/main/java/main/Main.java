package main;

import vista.VentanaPrincipal;

import  javax.swing.SwingUtilities;

/**
 * Inicia la interfaz gráfica de SpeedFast.
 */
public class Main {
    /**
     * Muestra la ventana principal desde el hilo de eventos de Swing.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}

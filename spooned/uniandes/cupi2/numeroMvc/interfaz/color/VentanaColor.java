package uniandes.cupi2.numeroMvc.interfaz.color;


/** 
 * Ventana de visualización en formato de color.
 */
public class VentanaColor extends javax.swing.JInternalFrame {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 5107092146528207517L;
    
    /** 
     * Panel con la visualización y el control.
     */
    private uniandes.cupi2.numeroMvc.interfaz.color.PanelColor panelColor;
    
    /** 
     * Constructor del panel.
     * @param numero Número a visualizar-modificar.
     */
    public VentanaColor(uniandes.cupi2.numeroMvc.mundo.Numero numero) {
        setSize(276 ,150);
        setMaximizable(true);
        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(276 , 150));
        setTitle("Vista-Controlador Color");
        panelColor = new uniandes.cupi2.numeroMvc.interfaz.color.PanelColor(numero);
        add(panelColor ,java.awt.BorderLayout.CENTER);
    }
    
}


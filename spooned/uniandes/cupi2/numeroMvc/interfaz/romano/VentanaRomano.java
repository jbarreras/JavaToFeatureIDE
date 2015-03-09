package uniandes.cupi2.numeroMvc.interfaz.romano;


/** 
 * Ventana de visualización en formato de números romanos.
 */
public class VentanaRomano extends javax.swing.JInternalFrame {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 3325218644134834205L;
    
    /** 
     * Panel con la visualización y el control.
     */
    private uniandes.cupi2.numeroMvc.interfaz.romano.PanelRomano panelRomano;
    
    /** 
     * Constructor del panel.
     * @param numero Número a visualizar-modificar.
     */
    public VentanaRomano(uniandes.cupi2.numeroMvc.mundo.Numero numero) {
        setSize(276 ,150);
        setMaximizable(true);
        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(276 , 150));
        setTitle("Vista-Controlador Romano");
        panelRomano = new uniandes.cupi2.numeroMvc.interfaz.romano.PanelRomano(numero);
        add(panelRomano ,java.awt.BorderLayout.CENTER);
    }
    
}


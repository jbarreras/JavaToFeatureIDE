package uniandes.cupi2.numeroMvc.interfaz.notas;


/** 
 * Ventana de visualizaci�n en formato de notas musicales.
 */
public class VentanaNotas extends javax.swing.JInternalFrame {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = 6571393258666895672L;
    
    /** 
     * Panel con la visualizaci�n y el control.
     */
    private uniandes.cupi2.numeroMvc.interfaz.notas.PanelNotas panelNotas;
    
    /** 
     * Constructor del panel.
     * @param numero N�mero a visualizar-modificar.
     */
    public VentanaNotas(uniandes.cupi2.numeroMvc.mundo.Numero numero) {
        setSize(276 ,150);
        setMaximizable(true);
        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(276 , 150));
        setTitle("Vista-Controlador Notas Musicales");
        panelNotas = new uniandes.cupi2.numeroMvc.interfaz.notas.PanelNotas(numero);
        add(panelNotas ,java.awt.BorderLayout.CENTER);
    }
    
}


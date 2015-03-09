package uniandes.cupi2.numeroMvc.interfaz.numero;


/** 
 * Ventana de visualizaci�n en formato de n�meros decimales.
 */
public class VentanaNumero extends javax.swing.JInternalFrame {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = -1041687579265094542L;
    
    /** 
     * Panel con la visualizaci�n y el control.
     */
    private uniandes.cupi2.numeroMvc.interfaz.numero.PanelNumero panelNumero;
    
    /** 
     * Constructor del panel.
     * @param numero N�mero a visualizar-modificar.
     */
    public VentanaNumero(uniandes.cupi2.numeroMvc.mundo.Numero numero) {
        setSize(276 ,150);
        setMaximizable(true);
        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(276 , 150));
        setTitle("Vista-Controlador Numero");
        panelNumero = new uniandes.cupi2.numeroMvc.interfaz.numero.PanelNumero(numero);
        add(panelNumero ,java.awt.BorderLayout.CENTER);
    }
    
}


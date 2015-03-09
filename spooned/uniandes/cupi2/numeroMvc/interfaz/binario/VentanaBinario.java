package uniandes.cupi2.numeroMvc.interfaz.binario;


/** 
 * Ventana de visualizaci�n en formato de n�meros binarios.
 */
public class VentanaBinario extends javax.swing.JInternalFrame {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = -2975409965024688727L;
    
    /** 
     * Panel con la visualizaci�n y el control.
     */
    private uniandes.cupi2.numeroMvc.interfaz.binario.PanelBinario panelBinario;
    
    /** 
     * Constructor del panel.
     * @param numero N�mero a visualizar-modificar.
     */
    public VentanaBinario(uniandes.cupi2.numeroMvc.mundo.Numero numero) {
        setSize(276 ,150);
        setMaximizable(true);
        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(276 , 150));
        setTitle("Vista-Controlador Binario");
        panelBinario = new uniandes.cupi2.numeroMvc.interfaz.binario.PanelBinario(numero);
        add(panelBinario ,java.awt.BorderLayout.CENTER);
    }
    
}


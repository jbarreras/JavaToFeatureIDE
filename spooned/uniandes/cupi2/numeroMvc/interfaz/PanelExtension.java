package uniandes.cupi2.numeroMvc.interfaz;


/** 
 * Panel de manejo de extensiones
 */
public class PanelExtension extends javax.swing.JPanel implements java.awt.event.ActionListener {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = -2712979860721352600L;
    
    /** 
     * Comando Opci�n 1.
     */
    private static final java.lang.String OPCION_1 = "OPCION_1";
    
    /** 
     * Comando Opci�n 2.
     */
    private static final java.lang.String OPCION_2 = "OPCION_2";
    
    /** 
     * Ventana principal de la aplicaci�n.
     */
    private uniandes.cupi2.numeroMvc.interfaz.InterfazNumeroMvc principal;
    
    /** 
     * Bot�n Opci�n 1.
     */
    private javax.swing.JButton btnOpcion1;
    
    /** 
     * Bot�n Opci�n 2.
     */
    private javax.swing.JButton btnOpcion2;
    
    /** 
     * Constructor del panel.
     * @param ip Ventana principal.
     */
    public PanelExtension(uniandes.cupi2.numeroMvc.interfaz.InterfazNumeroMvc ip) {
        principal = ip;
        setBorder(new javax.swing.border.TitledBorder("Opciones"));
        setLayout(new java.awt.GridLayout(1 , 2));
        btnOpcion1 = new javax.swing.JButton("Opci�n 1");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        add(btnOpcion1);
        btnOpcion2 = new javax.swing.JButton("Opci�n 2");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        add(btnOpcion2);
    }
    
    /** 
     * Manejo de los eventos de los botones.
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (OPCION_1.equals(e.getActionCommand())) {
            principal.reqFuncOpcion1();
        } else if (OPCION_2.equals(e.getActionCommand())) {
            principal.reqFuncOpcion2();
        } 
    }
    
}


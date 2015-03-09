package uniandes.cupi2.numeroMvc.mundo;


/** 
 * Representa un número que puede ser observado.
 */
public class Numero extends java.util.Observable {
    /** 
     * Número actual.
     */
    private int numero;
    
    /** 
     * Construye el número inicializándolo en 0.
     */
    public Numero() {
        numero = 0;
    }
    
    /** 
     * Cambia el valor del número.
     * @param nuevoNumero Nuevo valor de número.
     */
    public void cambiarNumero(int nuevoNumero) {
        numero = nuevoNumero;
        setChanged();
        notifyObservers(new java.lang.Integer(numero));
    }
    
    /** 
     * Devuelve el valor del número.
     * @return Valor actual del número.
     */
    public int darNumero() {
        return numero;
    }
    
    /** 
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public java.lang.String metodo1() {
        return "Respuesta 1";
    }
    
    /** 
     * Método para la extensión2.
     * @return respuesta2.
     */
    public java.lang.String metodo2() {
        return "Respuesta 2";
    }
    
}


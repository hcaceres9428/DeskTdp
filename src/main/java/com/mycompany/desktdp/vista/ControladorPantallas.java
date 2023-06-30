
package com.mycompany.desktdp.vista;


public class ControladorPantallas {
    
 private static VCliente pantallaCliente;
    
    public static void abrirPantallaCliente(){
        
    pantallaCliente = new VCliente();
    pantallaCliente.setVisible(true);
    pantallaCliente.setLocationRelativeTo(null);
        
    }
    
    public static void cerrarPantallaCliente(){
        
        pantallaCliente.setVisible(false);
        pantallaCliente = null;
        
    }
    
}

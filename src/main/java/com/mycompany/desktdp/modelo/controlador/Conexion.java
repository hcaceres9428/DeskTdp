
package com.mycompany.desktdp.modelo.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CaceresCampero
 */
public class Conexion {
    
    private static Connection conect;
    
    public static void conectar(){
        
        String url = "jdbc:mysql://localhost:3306/tdptejidos?serverTimeZone=UTC";
        String usr = "root";
        String ctr = "admin";
        
        try {
            conect = DriverManager.getConnection(url,usr,ctr);
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"¡Error. No conecto!" );
        }
        
        
    }

    public static Connection getConect() {
        return conect;
    }
        
    
}


package com.mycompany.desktdp;

import com.mycompany.desktdp.modelo.controlador.Conexion;
import com.mycompany.desktdp.vista.ControladorPantallas;

/**
 *
 * @author CaceresCampero
 */
public class DeskTdp {

    public static void main(String[] args) {
        Conexion.conectar();
        ControladorPantallas.abrirPantallaCliente();
        
    }
}


package com.mycompany.desktdp.modelo.controlador;

import com.mycompany.desktdp.modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CaceresCampero
 */
public class CCliente {
    
    public void agregarCliente(Cliente c){
    
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into cliente values('"+c.getCodigo()+"','"+c.getNombre()+"','"+c.getTelefono()+"','"+c.getDireccion()+"','"+c.getEmail()+"')");
            JOptionPane.showMessageDialog(null, "Done");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error");
        }
        
        
    }
    public ResultSet consultarCliente(){
    
        ResultSet rs = null;
        
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from cliente");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      return rs; 
    }
    public ResultSet consultarClientePorId(int codigo){
    
            ResultSet rs=null;
        try {
            Statement st= Conexion.getConect().createStatement();
             rs =st.executeQuery("select * from cliente where id_cliente='"+codigo+"' ");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    return  rs;
    
    
    }
    public void actualizarCliente(Cliente c){
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("update cliente set nombre='"+c.getNombre()+"',telefono='"+c.getTelefono()+"',direccion='"+c.getDireccion()+"',correo='"+c.getEmail()+"' where id_cliente='"+c.getCodigo()+"' ");
            JOptionPane.showMessageDialog(null,"Actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    public void eliminarCliente(int codigo){
    
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from cliente where id_cliente='"+codigo+"'");
            JOptionPane.showMessageDialog(null, "Eliminado");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error no elimino");
        }
    }
    public void pintarTabla(JTable tabla, ResultSet rs){
    
     
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Telefono");
            modelo.addColumn("Dirección");
            modelo.addColumn("Email");
      
        try {
            while (rs.next()) {
                String[]fila={rs.getString("id_cliente"),rs.getString("nombre"),rs.getString("telefono"),rs.getString("direccion"),rs.getNString("correo")};
                modelo.addRow(fila);
           }
            tabla.setModel(modelo);
        } 
        catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

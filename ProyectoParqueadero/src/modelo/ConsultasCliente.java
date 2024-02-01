
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ConsultasCliente extends Conexion {
    
    public boolean registrar(Cliente clien){
        
       
        PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
        String sql="INSERT INTO Cliente (primerNombre,segundoNombre,primerApellido,segundoApellido,tipoDocumento,numeroIdentificacion,CorreoElectronico,celular,contraseña,EstadoCliente)"
                + "VALUES (?,?,?,?,?,?,?,?,?,1)";
        
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setString(1, clien.getPrimerNombre());
            ps.setString(2, clien.getSegundoNombre());
            ps.setString(3, clien.getPrimerApellido());
            ps.setString(4, clien.getSegundoApellido());
            ps.setString(5, clien.getTipoDocumento());
            ps.setString(6, clien.getNumeroidentificacion());
            ps.setString(7, clien.getCorreoElectronico());
            ps.setString(8, clien.getCelular());
            ps.setString(9, clien.getContraseña());
            ps.execute();
            return true;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Error de inserción" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            try{
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "No se puede cerrar la conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
            
    }
    
    
     public boolean modificar(Cliente clien){
        
       
        PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
        String sql="UPDATE Cliente SET primerNombre=?, segundoNombre=?,primerApellido=?, segundoApellido=?, tipoDocumento=?, numeroIdentificacion=?, CorreoElectronico=?, celular=?, contraseña=?"
                + "WHERE idCliente=? ";
        
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setString(1, clien.getPrimerNombre());
            ps.setString(2, clien.getSegundoNombre());
            ps.setString(3, clien.getPrimerApellido());
            ps.setString(4, clien.getSegundoApellido());
            ps.setString(5, clien.getTipoDocumento());
            ps.setString(6, clien.getNumeroidentificacion());
            ps.setString(7, clien.getCorreoElectronico());
            ps.setString(8, clien.getCelular());
            ps.setString(9, clien.getContraseña());
            ps.setInt(10, clien.getId());
            ps.execute();
            return true;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Error de actualización" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            try{
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "No se puede cerrar la conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
            
    }
    
     
     public boolean buscar (Cliente clien){
        
       
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con= (Connection) getConexion();
        
        String sql=" SELECT * FROM Cliente WHERE numeroIdentificacion=?";
        
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setString(1, clien.getNumeroidentificacion());
            rs=ps.executeQuery();
            
            if(rs.next()){
                clien.setId(Integer.parseInt(rs.getString("idCliente")));
                clien.setPrimerNombre(rs.getString("primerNombre"));
                clien.setSegundoNombre(rs.getString("segundoNombre"));
                clien.setPrimerApellido(rs.getString("primerApellido"));
                clien.setSegundoApellido(rs.getString("segundoApellido"));
                clien.setTipoDocumento(rs.getString("tipoDocumento"));
                clien.setNumeroidentificacion(rs.getString("numeroIdentificacion"));
                clien.setCorreoElectronico(rs.getString("CorreoElectronico"));
                clien.setCelular(rs.getString("celular"));
                clien.setContraseña(rs.getString("contraseña"));
                return true;
            }
            
             return false;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Busqueda" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
            } finally{
            try{
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "No se puede cerrar la conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
       
    }
     
}
 
    




package modelo;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class Conexion {
    
   private final String base="Parqueadero";
   private final String user="root";
   private final String password="";
   private final String url="jdbc:mysql://localhost:3306/"+base; 
   private Connection con=null;
   
   
   public Connection getConexion(){
       
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection(this.url, this.user,this.password);
           JOptionPane.showMessageDialog(null, "Base de datos conectada exitosamente");
           
       } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(),"Base de datos apagada"+ e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
   
}

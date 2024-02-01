/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoparqueadero;

import controlador.CtrlCliente;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ConsultasCliente;
import vista.GuiRegistroCliente;
import vista.InicioSesionAdministrador;
import vista.InicioSesionCliente;

/**
 *
 * @author jhoan
 */
public class ProyectoParqueadero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//   InicioSesionCliente adm= new InicioSesionCliente();
//   adm.setVisible(true);
//   adm.setLocation(null);
//      InicioSesionAdministrador adm= new InicioSesionAdministrador();
//      adm.setVisible(true);
//      adm.setLocation(null);


Cliente clien=new Cliente();
ConsultasCliente consu=new ConsultasCliente();
GuiRegistroCliente gui= new GuiRegistroCliente();

CtrlCliente controlador =new CtrlCliente( clien,consu,gui);

controlador.iniciar();
gui.setVisible(true);

}
}

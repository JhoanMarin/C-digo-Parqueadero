
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.Action;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ConsultasCliente;
import vista.GuiRegistroCliente;


public class CtrlCliente implements ActionListener {
    
  private Cliente clien;
  private ConsultasCliente modc;
  private GuiRegistroCliente gui;

    public CtrlCliente(Cliente clien, ConsultasCliente modc, GuiRegistroCliente gui) {
        this.clien = clien;
        this.modc = modc;
        this.gui = gui;
        this.gui.btnRegistrarCliente.addActionListener(this);
    }
  
  public void iniciar ()
  {
      gui.setTitle("REGISTRO CLIENTES");
      gui.setLocation(8,5);
      
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==gui.btnRegistrarCliente) 
        {
            String Contraseña1=gui.txtContraseñaCliente.getText();
            String Contraseña2=gui.txtContraseñaCliente2.getText();
            
            if(Contraseña1.equals(Contraseña2))
        {
        clien.setPrimerNombre(gui.txt1nombreCliente.getText().trim());
        clien.setSegundoNombre(gui.txt2nombreCliente.getText().trim());
        clien.setPrimerApellido(gui.txt1ApellidoCliente.getText().trim());
        clien.setSegundoApellido(gui.txt2ApellidoCliente.getText().trim());
        clien.setTipoDocumento(gui.cmbxTipoDocuCliente.getSelectedItem().toString());
        clien.setNumeroidentificacion(gui.txtIdentifiCliente.getText().trim());
        clien.setCorreoElectronico(gui.txtCorreoCliente.getText().trim());
        clien.setCelular(gui.txtCelularCliente.getText().trim());
        clien.setContraseña(gui.txtContraseñaCliente.getText().trim());
        
        if (modc.registrar(clien))
        {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
            limpiar();
        }else{
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            limpiar();
            }
                }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                 }
    }
        
  }
  
  public void limpiar()
  {
      gui.txt1nombreCliente.setText(null);
      gui.txt2nombreCliente.setText(null);
      gui.txt1ApellidoCliente.setText(null);
      gui.txt2ApellidoCliente.setText(null);
      gui.cmbxTipoDocuCliente.setSelectedIndex(0);
      gui.txtIdentifiCliente.setText(null);
      gui.txtCorreoCliente.setText(null);
      gui.txtCelularCliente.setText(null);
      gui.txtContraseñaCliente.setText(null);
      gui.txtContraseñaCliente2.setText(null);
      
  }
    
}

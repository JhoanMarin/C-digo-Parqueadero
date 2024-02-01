/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JTextField;

/**
 *
 * @author jhoan
 */
public class Cliente extends Persona {

    public Cliente() {
    }

    public Cliente(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String tipoDocumento, String numeroidentificacion, String correoElectronico, String celular, String contraseña) {
        super(primerNombre, segundoNombre, primerApellido, segundoApellido, tipoDocumento, numeroidentificacion, correoElectronico, celular, contraseña);
    }

    public void setPrimerNombre(JTextField txt1nombreCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

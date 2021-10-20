/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vidal-software
 */
public class Usermodel {
    
    public ResultSet mostrarClientes() {
        Conexion con = new Conexion();
        ResultSet rs = null;

        try {
            con.conectar();
            CallableStatement ps = con.getCon().prepareCall("{CALL mostrarUsuarios()}");
            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, " resultado:  " + rs.getInt(1));

            return rs;

        } catch (SQLException e) {
            System.out.println("Error del mensaje: " + e.getMessage());
            return rs;
        }
    }
    
    public boolean insertUser(User user) {
        Conexion con = new Conexion();

        try {
            System.out.println("Abrriendo conexión");
            con.conectar();
            CallableStatement cst = con.getCon().prepareCall("{CALL pa_insertarCliente(?,?,?,?,?)}");

            cst.setString(1, user.getUserName());
            cst.setString(2, user.getName() );
            cst.setString(3, user.getPassword());
            cst.setInt(4, user.getStatus() );
            cst.setString(5, user.getAvatar());


            System.out.println("Insertando datos");
            cst.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al intentar enviar los datos: " + e.getMessage());
            return false;
        } finally {
            con.desconectar();
        }

    }
    
    
    
    
    public boolean updateUser(User user) {
        Conexion con = new Conexion();

        try {
            System.out.println("Abrriendo conexión");
            con.conectar();
            CallableStatement cst = con.getCon().prepareCall("{CALL pa_editarCliente(?,?,?,?,?,?)}");

            cst.setInt(1, user.getId() );
            cst.setString(2, user.getName() );
            cst.setString(3, user.getPassword());
            cst.setInt(4, user.getStatus() );
            cst.setString(5, user.getAvatar());
           

            System.out.println("Modificando datos");

            cst.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al intentar enviar los datos: " + e.getMessage());
            return false;
        } finally {
            con.desconectar();
        }

    }
    
    
    public String deleteUser(int userid) {

        //ResultSet rs = null;
        Conexion con = new Conexion();

        try {

            con.conectar();
            CallableStatement ps = con.getCon().prepareCall("{CALL pa_verificarEliminar(?)}");
            ps.setInt(1, userid);

            System.out.println("comprobando eliminacion categoría");
            ps.executeUpdate();

            return "eliminado";
            //return ps.getBoolean(3);
        } catch (SQLException e) {

            System.out.println("Error del mensaje: " + e.getMessage());
            return "Sin conexión";

        } finally {
            con.desconectar();
        }
    }

    
    
    
}

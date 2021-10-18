/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author vidal-software
 */
public class Conexion {

    private final String base = "company";
    private final String user = "root";
    private final String password = "Runo1101";
    private final String url = "jdbc:mysql://localhost/" + base + "?useSSL=false&serverTimezone=UTC";

    private Connection con;
    private Statement sql;
    private ResultSet rs;

    public Connection getCon() {
        return con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    private boolean cargarControlador() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error...No se cargó el controlador de Bases de Datos " + ex.getMessage());
            return false;
        }
    }

    public boolean conectar() {
        this.cargarControlador();
        try {
            this.con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            this.sql = this.con.createStatement();
            JOptionPane.showMessageDialog(null, " se conecto a: " + con.getCatalog());

            System.out.println("conexion exitosa: " + con.getCatalog()
                    + "\n----------------------");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al intentar conectarse a la base de datos: " + ex.getMessage());
            return false;
        }
    }

    public void desconectar() {
        try {

            this.sql.close();
            this.con.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }

}

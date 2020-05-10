/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entidades.Empleado;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author smlar
 */
public class EmpleadosDAO {

    private Connection conexion = null;

    public EmpleadosDAO() {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error en la conexion: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    
    public Empleado read(Integer idEmpleado) {
        Empleado empleado = null;
        PreparedStatement stm = null;
        if (this.conexion == null)
        {
            return null;
        }
        try {
            String sql = "SELECT * from empleados where CodigoEmpleado = ?";
            stm = conexion.prepareStatement(sql);

            stm.setInt(1, idEmpleado);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                empleado = new Empleado(
                        rs.getInt("CodigoEmpleado"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido1"),
                        rs.getString("Apellido2"),
                        rs.getString("Extension"),
                        rs.getString("Email"),
                        rs.getString("CodigoOficina"),
                        rs.getInt("CodigoJefe"),
                        rs.getString("Puesto")
                );
            }

        } catch (SQLException ex) {
            System.err.println("Error en la ejecución de la sentencia: " + ex.getMessage()+ "\nQuery: " + stm.toString());
            
        }

        return empleado;
    }

    public Empleado update (Empleado empleadoConActualizaciones)
    {
        Empleado empleadoActualizado = null;
        
        
        
        
        return empleadoActualizado;
    }
}

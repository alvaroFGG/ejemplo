/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.EmpleadosDAO;
import entidades.Empleado;

/**
 *
 * @author smlar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Empleado empleado = null;
        EmpleadosDAO empleados = new EmpleadosDAO();
        if (empleados.getConexion() == null)
        {
            System.err.println("Program terminado. Error la conexión");
            System.exit(1);
        }
        
        empleado = empleados.read(5);
        if (empleado != null) {
            System.out.println(empleado.toString());
        }
        else
        {
            System.err.println("El empleado no existe o no se puede leer");
        }
    }

}

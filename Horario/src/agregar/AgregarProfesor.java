/**
* Instrucciones de reutilización:
*    void agregar(String nombre, String paterno, String materno, String correo)
*    Propósito: Agregar un profesor a la base de datos mediante un INSERT.
*    Limitaciones: No se pueden agregar más campos de los especificados.
*/

package agregar;

import horario.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Clase que contiene el método para agregar un profesor al programa.
 * @author Angel Eduardo Domínguez Delgado
 */
public class AgregarProfesor {
    
    static Connection con = null; 
    static Statement s = null;
    
    /**
     * Función que agrega un profesor a la base de datos.
     * @param nombre Nombre del profesor.
     * @param paterno Apellido paterno del profesor.
     * @param materno Apellido materno del profesor.
     * @param correo Correo electrónico del profesor.
     * @throws SQLException 
     */
    public void agregar(String nombre, String paterno, String materno, 
            String correo) 
            throws SQLException {
        String sentencia;
        sentencia = "INSERT INTO Profesor (nombreProfesor, apPaternoProfesor, apMaternoProfesor"
                + ", emailProfesor) VALUES ('" + nombre + "','" + paterno + "','" + materno + "','" 
                + correo + "');";
        
        try{
            con = new Connect().connection();
            s = con.createStatement();
            s.executeUpdate(sentencia);
        } catch(SQLException e){
            System.err.print("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally{
            con.close();
        }
    }
}

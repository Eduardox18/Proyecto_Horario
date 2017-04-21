/**
* Instrucciones de reutilización:
*    void agregar(int nrc, String nombreEE, int creditosEE)
*    Propósito: Agregar una EE a la base de datos mediante un INSERT.
*    Limitaciones: No se pueden agregar más campos de los especificados.
*/

package agregar;

import horario.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Clase que contiene el método para agregar una EE al programa.
 * @author Angel Eduardo Domínguez Delgado
 */
public class AgregarExperienciaEducativa {
    
    static Connection con = null;
    static Statement s = null;
    
    /**
     * Función que agrega una Experiencia Educativa a la base de datos.
     * @param nrc NRC de la EE.
     * @param nombreEE Nombre de la EE.
     * @param creditosEE Créditos que otorga la EE.
     * @throws SQLException 
     */
    public void agregar(int nrc, String nombreEE, int creditosEE) throws SQLException {
        
        String sentencia = "INSERT INTO ExperienciaEducativa (nrc, nombreEE, creditosEE) VALUES (" + 
                nrc + ", '" + nombreEE + "', " + creditosEE + ");";
        try {
            con = new Connect().connection();
            s = con.createStatement();
            s.executeUpdate(sentencia);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            con.close();
        } 
    }
}

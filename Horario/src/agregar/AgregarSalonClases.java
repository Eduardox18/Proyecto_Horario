/**
* Instrucciones de reutilización:
*    void agregar(String noSalon)
*    Propósito: Agregar un salón de clases a la base de datos mediante un 
*       INSERT.
*    Limitaciones: No se pueden agregar más campos de los especificados.
*/

package agregar;

import horario.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Clase que contiene el método para agregar un salón de clases al programa.
 * @author Angel Eduardo Domínguez Delgado
 */
public class AgregarSalonClases {
    
    static Connection con = null;
    static Statement s = null;
    
    /**
     * Función que permite agregar un salon de clases a la base de datos
     * @param noSalon Número del salón de clases. También puede contener letras.
     * @throws SQLException 
     */
    public void agregar(String noSalon) throws SQLException {
        
        String sentencia = "INSERT INTO SalonClases (noSalonClases) VALUES ('" + noSalon + "');";
        
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

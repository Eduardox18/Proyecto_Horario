/**
* Instrucciones de reutilización:
*    void agregar(String horaInicio, String horaFin)
*    Propósito: Agregar un intervalos de horas a la base de datos mediante un INSERT.
*    Limitaciones: No se pueden agregar más campos de los especificados.
*/

package agregar;

import horario.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Clase que contiene el método para agregar horas al programa.
 * @author Angel Eduardo Domínguez Delgado
 */
public class AgregarHora {
    
    static Connection con = null;
    static Statement s = null;
    
    /**
     * Función que agrega un intervalo de horas al programa.
     * @param horaInicio Hora de inicio.
     * @param horaFin Hora de fin.
     * @throws SQLException 
     */
    public void agregar(String horaInicio, String horaFin) throws SQLException {
        
        String sentencia = "INSERT INTO Horario (horaInicioHorario, horaFinHorario) VALUES "
                + "('" + horaInicio + "', '" + horaFin + "');";
        
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

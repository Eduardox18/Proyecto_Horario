package agregar;

import horario.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lalo
 */
public class AgregarHora {
    
    static Connection con = null;
    static Statement s = null;
    
    public int agregar(String horaInicio, String horaFin ) throws SQLException {
        
        String sentencia = "INSERT INTO Horario (horaInicioHorario, horaFinHorario) VALUES "
                + "('" + horaInicio + "', '" + horaFin + "');";
        
        try {
            con = new Connect().connection();
            s = con.createStatement();
            return s.executeUpdate(sentencia);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            con.close();
        }
        return 0;
    }
}

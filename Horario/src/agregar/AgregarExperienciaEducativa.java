package agregar;

import static agregar.AgregarSalonClases.con;
import horario.Connect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lalo
 */
public class AgregarExperienciaEducativa {
    
    static Connection con = null;
    static Statement s = null;
    
    public int agregar(int nrc, String nombreEE, int creditosEE) throws SQLException {
        
        String sentencia = "INSERT INTO ExperienciaEducativa (nrc, nombreEE, creditosEE) VALUES (" + 
                nrc + ", '" + nombreEE + "', " + creditosEE + ");";
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

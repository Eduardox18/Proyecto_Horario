package consultas;

import horario.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lalo
 */
public class ConsultarEE {
    private Statement s;
    private Connection con;
    private ResultSet rs = null;
    private int nrc;
    private String nombreEE = null;
    
    public void consultarLista () throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT nrc, nombreEE, creditosEE from ExperienciaEducativa;";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                nrc = rs.getInt("nrc");
                nombreEE = rs.getString("nombreEE");
                    
                System.out.println(nrc + ". " + nombreEE);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
}

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
public class ConsultarSalon {
    
    private int idSalon;
    private String noSalon = null;
    private Statement s;
    private Connection con;
    private ResultSet rs = null;
    
    public void consultarLista () throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT idSalonClases, noSalonClases FROM SalonClases;";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                
                idSalon = rs.getInt("idSalonClases");
                noSalon = rs.getString("noSalonClases");
                    
                System.out.println(idSalon + ". " + noSalon);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
}

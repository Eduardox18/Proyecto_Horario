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
public class ConsultarHora {
    
    private int idHorario;
    private String horaInicio = null;
    private String horaFin = null;
    private Statement s;
    private Connection con;
    private ResultSet rs = null;
    
    public void consultarLista () throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT idHorario, horaInicioHorario, horaFinHorario from Horario;";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                
                idHorario = rs.getInt("idHorario");
                horaInicio = rs.getString("horaInicioHorario");
                horaFin = rs.getString("horaFinHorario");
                    
                System.out.println(idHorario + ". " + horaInicio + " - " + horaFin);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
}

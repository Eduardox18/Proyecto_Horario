package eliminar;

import horario.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Angel Eduardo Domínguez Delgado
 */
public class EliminarEEHorario {
    
    private int idHorario;
    private String nombreEE;
    private String dia;
    private String hora;
    private Statement s;
    private Connection con;
    private ResultSet rs;
    
    public void consultarLista() throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT idHorario, nombreEE, nombreDia, hora FROM Horario;";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                idHorario = rs.getInt("idHorario");
                nombreEE = rs.getString("nombreEE");
                dia = rs.getString("nombreDia");
                hora = rs.getString("hora");
                
                System.out.println(idHorario + ". " + nombreEE + ", " + dia + ", " + hora);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL en Eliminar EE (consultar)");
        } finally {
            con.close();
        }
    }
    
    public void eliminarEE(int idHor) throws SQLException {
        
        String sQuery = "DELETE FROM Horario WHERE idHorario = " + idHor + ";";
        
        try {
            con = new Connect().connection();
            s = con.createStatement();
            s.executeUpdate(sQuery);
        } catch (SQLException e) {
            System.out.println("Error SQL en eliminarEE");
        } finally {
            con.close();
        }
    }
}

package horario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lalo
 */
public class AgregarHorario {
    
    private Statement s;
    private Connection con; 
    private ResultSet rs = null;
    private String nombreEE;
    private String nombreProfesor;
    private String apPaternoProfesor;
    private String nombreDia;
    private String horaInicio;
    private String horaFin;
    private String noSalon;
    
    public void agregar(int nrcx, int idpx, int diax, int horx, int salonx) throws SQLException {
        
        nombreEE = "SELECT nombreEE AS `funconsulta` FROM ExperienciaEducativa "
                + "WHERE nrc = " + nrcx + ";";
        String eeRecuperado = update(nombreEE);
        
        nombreProfesor = "SELECT nombreProfesor AS `funconsulta` FROM Profesor "
                + "WHERE idProfesor = " + idpx + ";";
        String nombreProfesorRecuperado = update(nombreProfesor);
        
        apPaternoProfesor = "SELECT apPaternoProfesor AS `funconsulta` FROM Profesor "
                + "WHERE idProfesor = " + idpx + ";";
        String apPaternoProfesorRecuperado = update(apPaternoProfesor);
        
        nombreDia = "SELECT nombreDia AS `funconsulta`FROM Dia WHERE idDia = " 
                + diax + ";";
        String diaRecuperado = update(nombreDia);
        
        horaInicio = "SELECT horaInicioHorario AS `funconsulta` FROM Hora WHERE "
                + "idHorario = " + horx + ";";
        String inicioRecuperado = update(horaInicio);
        
        horaFin = "SELECT horaFinHorario AS `funconsulta` FROM Hora WHERE "
                + "idHorario = " + horx + ";";
        String finRecuperado = update(horaFin);
        
        noSalon = "SELECT noSalonClases AS `funconsulta`FROM SalonClases WHERE "
                + "idSalonClases = " + salonx + ";";
        String salonRecuperado = update(noSalon);
        
        String queryAgregar = "INSERT INTO Horario (nombreEE, nombreProfesor, nombreDia, hora, "
                + "noSalon) VALUES (' " + eeRecuperado + "', ' " + nombreProfesorRecuperado + 
                " " + apPaternoProfesorRecuperado + "', '" + 
                diaRecuperado + "', '" + inicioRecuperado + " - " + finRecuperado + "', '" + 
                salonRecuperado + "');";
        
        try {
            con = new Connect().connection();
            s = con.createStatement();
            s.executeUpdate(queryAgregar);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            con.close();
        }
    }
    
    public String update(String sQuery) throws SQLException {
        String consulta = null;
        
        con = new Connect().connection();
        
        try {
            
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while(rs!=null && rs.next()) {
                consulta = rs.getString("funconsulta");
            }
        } catch (SQLException e) {
            System.out.println("Error en Update");
        } finally {
        con.close();
        }
        return consulta;
    }
}

/**
* Instrucciones de reutilización:
*    void realizarConsulta()
*    Propósito: Permite consultar el horario completo de la base de datos mediante un SELECT.
*    Limitaciones: Los horarios aparecen por día.
*/

package consultas;

import horario.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Clase que contiene el método para consultar el horario de clases.
 * @author Angel Eduardo Domínguez Delgado
 */
public class ConsultarHorario {
    
    private Statement s;
    private Connection con;
    private ResultSet rs = null;
    private String nombreEE;
    private String nombreProfesor;
    private String nombreDia;
    private String hora;
    private String noSalon;
    
    String sQuery = "SELECT nombreEE, nombreProfesor, nombreDia, hora, noSalon FROM Horario "
            + "ORDER BY nombreDia AND hora;";
    
    /**
     * Función que conecta con la base de datos y recupera el horario de clases completo.
     * @throws SQLException 
     */
    public void realizarConsulta() throws SQLException {
        con = new Connect().connection();
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                nombreEE = rs.getString("nombreEE");
                nombreProfesor = rs.getString("nombreProfesor");
                nombreDia = rs.getString("nombreDia");
                hora = rs.getString("hora");
                noSalon = rs.getString("noSalon");
                    
                System.out.println("Día de la semana: " + nombreDia);
                System.out.println("Experiencia Educativa: " + nombreEE);
                System.out.println("Profesor: " + nombreProfesor);
                System.out.println("Horario: " + hora);
                System.out.println("Salón: " + noSalon);
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
    
}

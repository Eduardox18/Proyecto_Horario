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
    private String horaInicioHorario;
    private String horaFinHorario;
    private String noSalonClases;
    
    String sQuery = "SELECT ExperienciaEducativa.nombreEE, Profesor.nombreProfesor, Dia.nombreDia, "
            + "Horario.horaInicioHorario, Horario.horaFinHorario, SalonClases.noSalonClases FROM "
            + "ExperienciaEducativa, Profesor, Dia, Horario, SalonClases, "
            + "ExperienciaEducativa_has_SalonClases, Horario_has_Dia, "
            + "Horario_has_ExperienciaEducativa, Profesor_has_ExperienciaEducativa WHERE "
            + "ExperienciaEducativa.nrc = "
            + "ExperienciaEducativa_has_SalonClases.ExperienciaEducativa_nrc AND "
            + "SalonClases.idSalonClases = "
            + "ExperienciaEducativa_has_SalonClases.SalonClases_idSalonClases AND "
            + "Horario.idHorario = Horario_has_Dia.Horario_idHorario AND Dia.idDia = "
            + "Horario_has_Dia.Dia_idDia AND Horario.idHorario = "
            + "Horario_has_ExperienciaEducativa.Horario_idHorario AND ExperienciaEducativa.nrc = "
            + "Horario_has_ExperienciaEducativa.ExperienciaEducativa_nrc AND Profesor.idProfesor = "
            + "Profesor_has_ExperienciaEducativa.Profesor_idProfesor AND ExperienciaEducativa.nrc "
            + "= Profesor_has_ExperienciaEducativa.ExperienciaEducativa_nrc;";
    
    /**
     * Función que conecta con la base de datos y recupera el horario de clases.
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
                horaInicioHorario = rs.getString("horaInicioHorario");
                horaFinHorario = rs.getString("horaFinHorario");
                noSalonClases = rs.getString("noSalonClases");
                    
                System.out.println("Día de la semana: " + nombreDia);
                System.out.println("Experiencia Educativa: " + nombreEE);
                System.out.println("Profesor: " + nombreProfesor);
                System.out.println("Horario: " + horaInicioHorario + " - " + horaFinHorario);
                System.out.println("Salón: " + noSalonClases);
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
    
}

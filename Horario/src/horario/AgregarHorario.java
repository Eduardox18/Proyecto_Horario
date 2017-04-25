/**
* Instrucciones de reutilización:
*    void agregar(int nrcx, int idpx, int diax, int horx, int salonx)
*    Propósito: Agregar una EE con todos sus datos relacionados al Horario.
*    Limitaciones: Ninguna.
* 
*    String update(String sQuery)
*    Propósito: Consultar la base de datos con la sentencia que se le mande y 
*       regresar el valor de la columna solicitada.
*    Limitaciones: Ninguna
*/

package horario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que contiene los métodos necesarios para agregar una EE al Horario.
 * @author Angel Eduardo Domínguez Delgado
 */
public class AgregarHorario {
    
    private Statement s;
    private Connection con; 
    private ResultSet rs = null;
    private String nombreEE;
    private String nombreProfesor;
    private String apPaternoProfesor;
    private String nombreDia;
    private String hora;
    private String noSalon;
    
    /**
     * Función que realiza las consultas y agrega una nueva EE al Horario.
     * @param nrcx NRC de la EE
     * @param idpx ID del Profesor
     * @param diax ID del Día
     * @param horx ID del intervalo de horas.
     * @param salonx ID del Salón
     * @throws SQLException  
     */
    public void agregar(int nrcx, int idpx, int diax, int horx, int salonx) 
            throws SQLException {
        
        boolean flag = true;
        
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
        
        hora = "SELECT intervaloHoras AS `funconsulta` FROM Hora WHERE "
                + "idHorario = " + horx + ";";
        String horaRecuperada = update(hora);
        
        noSalon = "SELECT noSalonClases AS `funconsulta`FROM SalonClases WHERE "
                + "idSalonClases = " + salonx + ";";
        String salonRecuperado = update(noSalon);
        
        String queryAgregar = "INSERT INTO Horario (nombreEE, nombreProfesor, "
                + "nombreDia, hora, noSalon) VALUES (' " + eeRecuperado + "', "
                + "' " + nombreProfesorRecuperado + 
                " " + apPaternoProfesorRecuperado + "', '" + 
                diaRecuperado + "', '" + horaRecuperada  + "', '" + 
                salonRecuperado + "');";
        
        String comprobacion = "SELECT nombreDia, hora FROM Horario";
        String nombreDiaC;
        String horaC;
        
        try {
            con = new Connect().connection();
            s = con.createStatement();
            rs = s.executeQuery(comprobacion);
            
            while (rs!=null && rs.next()) {
                
                nombreDiaC = rs.getString("nombreDia");
                horaC = rs.getString("hora");
                    
                if(nombreDiaC.equalsIgnoreCase(diaRecuperado) && 
                        horaC.equalsIgnoreCase(horaRecuperada)) {
                    flag = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally {
            con.close();
        }
        
        if(flag == true) {
            try {
                con = new Connect().connection();
                s = con.createStatement();
                s.executeUpdate(queryAgregar);
                System.out.println("Experiencia Educativa agregada con éxito.");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
            } finally {
                con.close();
            }
        } else {
            System.out.println("Ya existe clase a esa hora, pruebe con otra.");
        }
        
    }
    
    /**
     * Función que permite realizar una consulta en la base de datos y recuperar
     *  el valor de una columna solicitada.
     * @param sQuery
     * @return Valor String de la columna.
     * @throws SQLException 
     */
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

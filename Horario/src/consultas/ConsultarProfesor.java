/**
* Instrucciones de reutilización:
* 
*    void consultaAgenda()
*    Propósito: Permite consultar todos los datos de los profesores registrados en la base de datos.
*    Limitaciones: Ninguna.
* 
*    void consultarLista()
*    Propósito: Permite consultar la lista de profesores existentes en la base de datos mediante 
*       un SELECT.
*    Limitaciones: Sólo recupera los nombres de los profesores.
*/

package consultas;

import horario.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Clase que contiene el método para consultar la agenda y la lista de profesores almacenados.
 * @author Angel Eduardo Domínguez Delgado
 */
public class ConsultarProfesor {
    
    private int idProfesor;
    private String nombre = null;
    private String paterno = null;
    private String materno = null;
    private String correo = null;
    private Statement s;
    private Connection con; 
    private ResultSet rs = null;
        
    /**
     * Función que conecta con la base de datos y recupera la agenda de profesores.
     * @throws SQLException 
     */
    public void consultarAgenda() throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT nombreProfesor, apMaternoProfesor, apPaternoprofesor, "
                + "emailProfesor from Profesor";
        try{
                s = con.createStatement();
                rs = s.executeQuery(sQuery);
                
                while(rs!=null && rs.next()) {
                    nombre = rs.getString("nombreProfesor");
                    paterno = rs.getString("apPaternoProfesor");
                    materno = rs.getString("apMaternoProfesor");
                    correo = rs.getString("emailProfesor");
                    
                    System.out.println("Nombre: " + nombre + " " + paterno + " " + materno);
                    System.out.println("Correo electrónico: " + correo);
                    System.out.println("-------------------------");
                }  
        } catch(SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
    
    /**
     * Función que conecta con la base de datos y recupera la lista de profesores.
     * @throws SQLException 
     */
    public void consultarLista () throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT idProfesor, nombreProfesor, apMaternoProfesor, apPaternoprofesor "
                + "from Profesor";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                idProfesor = rs.getInt("idProfesor");
                nombre = rs.getString("nombreProfesor");
                paterno = rs.getString("apPaternoProfesor");
                materno = rs.getString("apMaternoProfesor");
                    
                System.out.println(idProfesor + ". " + nombre + " " + paterno + " " + 
                        materno);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
}

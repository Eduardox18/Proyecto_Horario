/**
* Instrucciones de reutilización:
*    void consultarLista()
*    Propósito: Permite consultar la lista de EE existentes en la base de datos 
*       mediante un SELECT.
*    Limitaciones: Sólo realiza la consulta de las EE.
* 
*    void eliminarEE(int idHor)
*    Propósito: Permite eliminar un registro de una EE agregada al horario.
*    Limitaciones: Ninguna.
*/

package eliminar;

import horario.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase encargada de eliminar las experiencias educativas seleccionadas por
 * el usuario, ingresando el idHorario de la tabla Horario en la base de datos.
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
    
    /**
     * Función que conecta con la base de datos y recupera la lista de EE
     * registradas en el Horario.
     * @throws SQLException 
     */
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
    
    /**
     * Función que conecta con la base de datos y elimina una EE registrada en
     * el horario.
     * @param idHor ID de un registro de EE en el Horario.
     * @throws SQLException 
     */
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

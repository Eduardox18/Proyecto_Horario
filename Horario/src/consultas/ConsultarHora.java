/**
* Instrucciones de reutilización:
*    void consultarLista()
*    Propósito: Permite consultar la lista de los intervalos de horas existentes 
*       en la base de datos mediante un SELECT.
*    Limitaciones: Sólo realiza la consulta de los intervalos de horas.
*/

package consultas;

import horario.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Clase que contiene el método para consultar los intervalos de horas almacenados.
 * @author Angel Eduardo Domínguez Delgado
 */
public class ConsultarHora {
    
    private int idHorario;
    private String intervaloHoras = null;
    private Statement s;
    private Connection con;
    private ResultSet rs = null;
    
    /**
     * Función que conecta con la base de datos y recupera la lista de intervalos de horas.
     * @throws SQLException 
     */
    public void consultarLista () throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT idHorario, intervaloHoras from Hora;";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                
                idHorario = rs.getInt("idHorario");
                intervaloHoras = rs.getString("intervaloHoras");
                    
                System.out.println(idHorario + ". " + intervaloHoras);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
}

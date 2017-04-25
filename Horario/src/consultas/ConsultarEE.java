/**
* Instrucciones de reutilización:
*    void consultarLista()
*    Propósito: Permite consultar la lista de EE existentes en la base de 
*       datos mediante un SELECT.
*    Limitaciones: Sólo realiza la consulta de las EE.
*/

package consultas;

import horario.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Clase que contiene el método para consultar las EE almacenadas.
 * @author Angel Eduardo Domínguez Delgado
 */
public class ConsultarEE {
    private Statement s;
    private Connection con;
    private ResultSet rs = null;
    private int nrc;
    private String nombreEE = null;
    
    /**
     * Función que conecta con la base de datos y recupera la lista de EE.
     * @throws SQLException 
     */
    public void consultarLista () throws SQLException {
        
        con = new Connect().connection();
        
        String sQuery = "SELECT nrc, nombreEE, creditosEE from ExperienciaEducativa;";
        
        try {
            s = con.createStatement();
            rs = s.executeQuery(sQuery);
            
            while (rs!=null && rs.next()) {
                nrc = rs.getInt("nrc");
                nombreEE = rs.getString("nombreEE");
                    
                System.out.println(nrc + ". " + nombreEE);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
}

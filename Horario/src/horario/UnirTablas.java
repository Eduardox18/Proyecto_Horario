/**
* Instrucciones de reutilización:
* 
*    void unir(int nrcx, int idpx, int diax, int horx, int salonx)
*    Propósito: Realizar la inserción de llaves primarias en las tablas ternarias de la base
*       de datos.
*    Limitaciones: Ninguna.
* 
*    void update(String sQuery)
*    Propósito: Relizar un update cualquiera en la base de datos.
*    Limitaciones: Ninguna.
*/

package horario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lalo
 */
public class UnirTablas {
    
    private Statement s;
    private Connection con; 
    private ResultSet rs = null;
    
    public void unir(int nrcx, int idpx, int diax, int horx, int salonx) throws SQLException {
        
        String unionUno = "INSERT INTO ExperienciaEducativa_has_SalonClases "
                + "(ExperienciaEducativa_nrc, SalonClases_idSalonClases) VALUES "
                + "(" + nrcx +", " + salonx + ");";
        update(unionUno);
        
        String unionDos = "INSERT INTO Horario_has_Dia (Horario_idHorario, Dia_idDia) VALUES "
                + "(" + horx +", " + diax + ");";
        update(unionDos);
        
        String unionTres = "INSERT INTO Horario_has_ExperienciaEducativa "
                + "(Horario_idHorario, ExperienciaEducativa_nrc) VALUES "
                + "(" + horx +", " + nrcx + ");";
        update(unionTres);
        
        String unionCuatro = "INSERT INTO Profesor_has_ExperienciaEducativa "
                + "(Profesor_idProfesor, ExperienciaEducativa_nrc) VALUES "
                + "(" + idpx +", " + nrcx + ");";
        update(unionCuatro);
    }
    
    public void update(String sQuery) throws SQLException {
        try {
            con = new Connect().connection();
            s = con.createStatement();
            s.executeUpdate(sQuery);
        } catch (SQLException e) {
            System.out.println("Error en Update");
        } finally {
        con.close();
        }
    }
}

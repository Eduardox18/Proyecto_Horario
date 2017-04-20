package horario;

import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lalo
 */
public class AgregarProfesor {
    
    static Connection con = null; 
    static Statement s = null;
    
    public static void main (String args[]) {
        
    }
    
    public int agregar(String nombre, String paterno, String materno, String correo) throws SQLException {
        String sentencia;
        sentencia = "INSERT INTO Profesor (nombreProfesor, apPaternoProfesor, apMaternoProfesor"
                + ", emailProfesor) VALUES ('" + nombre + "','" + paterno + "','" + materno + "','" 
                + correo + "');";
        
        try{
            con = new Connect().connection();
            s = con.createStatement();
            return s.executeUpdate(sentencia);
        } catch(SQLException e){
            System.err.print("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        } finally{
            con.close();
        }
        return 0;
    }
}

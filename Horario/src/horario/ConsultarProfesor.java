package horario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarProfesor {
    
    public void consultarAgenda() throws SQLException {
        
        String nombre = null;
        String paterno = null;
        String materno = null;
        String correo = null;
        Statement s;
        Connection con; 
        con = new Connect().connection();
        ResultSet rs = null;
        String sQuery = "SELECT nombreProfesor, apMaternoProfesor, apPaternoprofesor, "
                + "emailProfesor from Profesor";
        try{
                s = con.createStatement();
                rs = s.executeQuery(sQuery);
                
                while(rs!=null && rs.next())
                {
                    nombre = rs.getString("nombreProfesor");
                    paterno = rs.getString("apPaternoProfesor");
                    materno = rs.getString("apMaternoProfesor");
                    correo = rs.getString("emailProfesor");
                    
                    System.out.println("Nombre: " + nombre + " " + paterno + " " + materno);
                    System.out.println("Correo electrónico: " + correo);
                    System.out.println("-------------------------");
                }  
        } catch(SQLException e) {
            System.out.println("Error");
        }
        finally {
            con.close();
        }
    }
}

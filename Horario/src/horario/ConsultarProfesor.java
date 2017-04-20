package horario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarProfesor {
    
    private int idProfesor;
    private String nombre = null;
    private String paterno = null;
    private String materno = null;
    private String correo = null;
    private Statement s;
    private Connection con; 
    ResultSet rs = null;
        
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
                    
                System.out.println(idProfesor + ". Nombre: " + nombre + " " + paterno + " " + 
                        materno);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            con.close();
        }
    }
}

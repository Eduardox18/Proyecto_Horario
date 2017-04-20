package horario;

/**
 *
 * @author lalo
 */
public class AgregarExperienciaEducativa {
    static Connection con = null;
    static Statement s = null;
    
    public int agregar(int nrc, String nombreEE, int creditosEE, String horaInicio, String horaFin,
            String dia, int noSalonClases, int idProfesor) {
        
        String sentenciaEE;
        String sentenciaHor;
        String sentenciaSalon;
        
        sentenciaEE = "INSERT INTO ExperienciaEducativa (nrc, nombreEE, creditosEE) VALUES (" + 
                nrc + ", '" + nombreEE + "', " + creditosEE + ");";
        
        sentenciaHor = "INSERT INTO Horario (horaInicioHorario, horaFinHorario, diaHorario) VALUES "
                + "('" + horaInicio + "', '" + horaFin + "', '" + dia + "');";
        
        sentenciaSalon = "INSERT INTO SalonClases (noSalonClases) VALUES (" + noSalonClases + ");";
         return 0;
    }
    
    public void unir() {
        
        String sentenciaEE_Horario;
        String sentenciaEE_Salon;
        String sentenciaEE_Profesor;
        
        sentenciaEE_Horario = "INSERT INTO Horario_has_ExperienciaEducativa (Horario_idHorario, "
                + "ExperienciaEducativa_nrc) VALUES ()";
        
    }
}

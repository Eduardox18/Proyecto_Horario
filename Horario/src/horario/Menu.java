/**
* Instrucciones de reutilización:
*    void mostrar()
*    Propósito: Muestra el menú principal del programa.
*    Limitaciones: Se navega mediante inserciones de números.
* 
*    void realizarOpcion(int op)
*    Propósito: Realiza la acción ingresada por el usuario.
*    Limitaciones: Ninguna.
* 
*    void opcionUno()
*    Propósito: Muestra la primera opción del menú principal.
*    Limitaciones: Ninguna.
* 
*    void opcionDos()
*    Propósito: Muestra la segunda opción del menú principal.
*    Limitaciones: Ninguna.
*/

package horario;

import agregar.*;
import consultas.*;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 
 * Clase que contiene el menú principal y la invocación de todas sus acciones.
 * @author Angel Eduardo Domínguez Delgado
 */
public class Menu {
    
    static int op;
    static Scanner sc = new Scanner(System.in);
    
    /**
     * Función que muestra el menú principal.
     */
    public void mostrar() {
        System.out.println("Horario de clases del alumno Ángel Eduardo Domínguez Delgado");
        System.out.println("1. Agenda de profesores");
        System.out.println("2. Horario");
        System.out.println("3. About");
        System.out.println("4. Salir");
    }
    
    /**
     * Función que realiza la opción ingresada por el usuario.
     * @param op
     * @throws SQLException 
     */
    public void realizarOpcion(int op) throws SQLException {
        switch(op) {
            case 1:
                opcionUno();
                break;
            case 2:
                opcionDos();
                break;
            case 3:
                System.out.println("Programa simple de un horario de clases.");
                System.out.println("Diseñado y programado por Angel Eduardo Domínguez Delgado, "
                        + "estudiante de Ingeniería de Software de la Universidad Veracruzana.");
                System.out.println("-------------------");
                break;
            case 4:
                System.out.println("Gracias por usar el programa");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
    
    /**
     * Función que invoca los métodos contenidos en la primera opción del menú principal.
     * @throws SQLException 
     */
    public void opcionUno() throws SQLException {
        String nombre;
        String paterno;
        String materno;
        String correo;
        
        System.out.println("1. Agregar profesor");
        System.out.println("2. Consultar agenda");
        System.out.println("3. Regresar al menú principal");
        System.out.println("Opción a elegir: ");
        op = sc.nextInt();
        sc.nextLine();
        
        switch(op) {
            case 1:
                System.out.println("Ingrese el nombre del profesor: ");
                nombre = sc.nextLine();
                System.out.println("Ingrese el apellido paterno: ");
                paterno = sc.nextLine();
                System.out.println("Ingrese el apellido materno: ");
                materno = sc.nextLine();
                System.out.println("Ingrese el correo electrónico: ");
                correo = sc.nextLine();
                AgregarProfesor ap = new AgregarProfesor();
                ap.agregar(nombre, paterno, materno, correo);
                System.out.println("Se agregó el profesor con éxito");
                break;
            case 2:
                ConsultarProfesor cp = new ConsultarProfesor();
                cp.consultarAgenda();
                break;
            case 3:
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
    
    /**
     * Función que invoca los métodos contenidos en la segunda opción del menú principal.
     * @throws SQLException 
     */
    public void opcionDos() throws SQLException {
        
        //Atributos ExperienciaEducativa
        int nrc;
        String nombreEE;
        int creditosEE;
        
        //Atributos Horario
        String horaInicio;
        String horaFin;
        String dia;
        
        //Atributos SalonClases
        String noSalonClases;
        
        System.out.println("Menú de opciones de Horario");
        System.out.println("1. Agregar Experiencia Educativa");
        System.out.println("2. Agregar Hora (Intervalo)");
        System.out.println("3. Agregar Salón de clases");
        System.out.println("4. Agregar EE al horario de clases");
        System.out.println("5. Consultar horario");
        System.out.println("6. Regresar al menú principal");
        System.out.println("Elige una opción: ");
        op = sc.nextInt();
        sc.nextLine();
        
        switch(op) {
            case 1:
                System.out.println("NRC: ");
                nrc = sc.nextInt();
                sc.nextLine();
                System.out.println("Nombre: ");
                nombreEE = sc.nextLine();
                System.out.println("Créditos ");
                creditosEE = sc.nextInt();
                sc.nextLine();
                AgregarExperienciaEducativa aee = new AgregarExperienciaEducativa();
                aee.agregar(nrc, nombreEE, creditosEE);
                System.out.println("Experiencia Educativa agregada con éxito.");
                break;
            case 2:
                System.out.println("El formato de la hora debe ser XX:XX (Ejemplo: 14:00)");
                System.out.println("Hora de inicio: ");
                horaInicio = sc.nextLine();
                System.out.println("Hora de fin: ");
                horaFin = sc.nextLine();
                AgregarHora ah = new AgregarHora();
                ah.agregar(horaInicio, horaFin);
                System.out.println("Hora agregada con éxito.");
                break;
            case 3:
                System.out.println("Salón en el que se impartirá la EE: ");
                noSalonClases = sc.nextLine();
                AgregarSalonClases asc = new AgregarSalonClases();
                asc.agregar(noSalonClases);
                System.out.println("Salón de clases agregado con éxito.");
                break;
            case 4:
                System.out.println("Lista de Experiencias Educativas: ");
                ConsultarEE cee = new ConsultarEE();
                cee.consultarLista();
                System.out.println("NRC de EE a agregar: ");
                int nrcx = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Lista de profesores: ");
                ConsultarProfesor cp = new ConsultarProfesor();
                cp.consultarLista();
                System.out.println("Número del profesor que dará la EE: ");
                int idpx = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Lista de días: ");
                System.out.println("1. Lunes \n2. Martes\n3. Miércoles\n4. Jueves\n5. Viernes\n"
                        + "6. Sábado\n7. Domingo");
                System.out.println("Número de día en que se impartirá la EE: ");
                int diax = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Lista de horarios: ");
                ConsultarHora ch = new ConsultarHora();
                ch.consultarLista();
                System.out.println("Número de hora en que se impartirá la EE: ");
                int horx = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Lista de salones de clases: ");
                ConsultarSalon cs = new ConsultarSalon();
                cs.consultarLista();
                System.out.println("Número de Salón donde se impartirá la EE: ");
                int salonx = sc.nextInt();
                sc.nextLine();
                
                UnirTablas ut = new UnirTablas();
                ut.unir(nrcx, idpx, diax, horx, salonx);
                
                System.out.println("Experiencia Educativa agregada con éxito.");
                break;
            case 5:
                ConsultarHorario coh = new ConsultarHorario();
                coh.realizarConsulta();
                break;
            case 6:
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        
    }
}

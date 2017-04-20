package horario;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author lalo
 */
public class Menu {
    
    static int op;
    static Scanner sc = new Scanner(System.in);
    
    public void mostrar() {
        System.out.println("Horario de clases del Alumno Ángel Eduardo Domínguez Delgado");
        System.out.println("1. Agenda de profesores");
        System.out.println("2. Horario");
        System.out.println("3. About");
        System.out.println("4. Salir");
    }
    
    public void realizarOpcion(int op) throws SQLException {
        switch(op) {
            case 1:
                opcionUno();
                break;
            case 2:
                System.out.println("1. Agregar clase al horario");
                System.out.println("2. Consultar horario");
                break;
            case 3:
                break;
            case 4:
                System.out.println("Gracias por usar el programa");
                break;
        }
    }
    
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
                mostrar();
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
    
}

package horario;

import java.sql.SQLException;
import java.util.Scanner;

/**
* Nombre: iSchoolHours
* Versión: 0.1
* Autor: Angel Eduardo Domínguez Delgado
* Fecha: 6 de Abril de 2017
* Descripción: Este programa permite crear un horario de clases, incluyendo también una agenda
* de los profesores.
*/

public class Main {
     
    /**
     * Función principal del programa
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        int op;
        
        
        do {
            menu.mostrar();
            System.out.println("Opción a elegir: ");
            op = sc.nextInt();
            sc.nextLine();
            menu.realizarOpcion(op);
        } while (op!=4);
    }
}

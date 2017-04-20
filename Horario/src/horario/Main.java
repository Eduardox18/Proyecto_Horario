package horario;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author lalo
 */
public class Main {
        
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

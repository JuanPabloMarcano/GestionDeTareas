package proyecto_gestión_de_tareas;
/*Integrantes:
Edwin Rodriguez
Juan Marcano
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Proyecto_gestión_de_tareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("------------------");
            System.out.println("| Iniciar sesión |");
            System.out.println("|----------------|");
            System.out.println("|1.    Usuario   |");
            System.out.println("|2. Administrador|");
            System.out.println("|3.     Salir    |");
            System.out.println("------------------");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    // Lógica para usuario
                    System.out.println("Has seleccionado Usuario.");
                    break;
                case 2:
                    System.out.println("Has seleccionado Administrador.");
                    System.out.flush();
                    
                    // Pedir clave de administrador
                    System.out.print("Ingrese la clave de 4 dígitos: ");
                    int clave = scanner.nextInt();
                    
                    if (clave == 1234) {
                        
                        // Mostrar menú de administrador
                        int opcion1;
                        do {
                            System.out.println("----------------------------");
                            System.out.println("|     Menú Administrador   |");
                            System.out.println("|--------------------------|");
                            System.out.println("|1.      Crear usuario     |");
                            System.out.println("|2.   Eliminar usuario     |");
                            System.out.println("|3.  Usuarios registrados  |");
                            System.out.println("|4.  Modificar usuario     |");
                            System.out.println("|5.        Volver          |");
                            System.out.println("----------------------------");
                            System.out.print("Seleccione una opción: ");
                            opcion1 = scanner.nextInt();
                            
    }
    
}

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
                            System.out.println("|3.  Modificar usuario     |");
                            System.out.println("|4.        Volver          |");
                            System.out.println("----------------------------");
                            System.out.print("Seleccione una opción: ");
                            opcion1 = scanner.nextInt();
                            
                            switch(opcion1) {
                                case 1:
                                    // Lógica para crear usuario
                                    System.out.print("Ingrese el nombre del usuario: ");
                                    String nombre = scanner.next();
                                    guardarUsuario(nombre);
                                    break;
                                case 2:
                                    // Lógica para eliminar usuario
                                    System.out.print("Ingrese el nombre del usuario a eliminar: ");
                                    String nombreEliminar = scanner.next();
                                    eliminarUsuario(nombreEliminar);
                                    break;
                                case 3:
                                    // Lógica para modificar usuario
                                    System.out.print("Ingrese el nombre del usuario a modificar: ");
                                    String nombreModificar = scanner.next();
                                    modificarUsuario(nombreModificar);
                                    break;
                                case 4:
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                default:
                                    System.out.println("Opción no válida, por favor intente de nuevo.");
                            }
                        } while (opcion1 != 4);
                    } else {
                        System.out.println("Clave incorrecta.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 3);
        
        scanner.close();
    }
    
    public static void guardarUsuario(String nombre) {
        // Lógica para guardar usuario en un archivo txt
        try {
            File file = new File("C:\\Users\\Edwin\\Documents\\NetBeansProjects\\Proyecto_gestión_de_tareas\\build\\classes\\info\\" + nombre + ".txt");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            writer.write("Nombre: " + nombre);
            writer.close();
            System.out.println("Usuario guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el usuario.");
            e.printStackTrace();
        }
    }
    
    public static void eliminarUsuario(String nombre) {
        // Lógica para eliminar usuario
        File file = new File("C:\\Users\\Edwin\\Documents\\NetBeansProjects\\Proyecto_gestión_de_tareas\\build\\classes\\info\\" + nombre + ".txt");
        if (file.delete()) {
        } else {
            System.out.println("Ocurrió un error al eliminar el usuario.");
        }
    }
    
    public static void modificarUsuario(String nombre) {
        // Lógica para modificar usuario

        System.out.print("Ingrese el nuevo nombre del usuario: ");
        Scanner scanner = new Scanner(System.in);
        String nuevoNombre = scanner.next();
        guardarUsuario(nuevoNombre);
    }
}

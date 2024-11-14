package proyecto_gestión_de_tareas;
/*Integrantes:
Edwin Rodriguez
Juan Marcano
*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto_gestión_de_tareas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("------------------");
            System.out.println("| Iniciar sesión |");
            System.out.println("|----------------|");
            System.out.println("|1.    Usuario   |");
            System.out.println("|2. Administrador|");
            System.out.println("|3.     Salir    |");
            System.out.println("------------------");
            System.out.print("Seleccione una opción: ");

            // Validación de entrada para opción del menú principal
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // limpiar el scanner
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado Usuario.");
                    break;
                case 2:
                    boolean claveValida = false;
                    while (!claveValida) {
                        System.out.print("Ingrese la clave de 4 dígitos: ");
                        int clave = 0;

                        // Validación de entrada para clave de administrador
                        try {
                            clave = scanner.nextInt();
                            if (clave != 1234) {
                                System.out.println("Clave incorrecta.");
                                continue; // volver a pedir la clave
                            }
                            claveValida = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese una clave válida (4 dígitos numéricos).");
                            scanner.next(); 
                            continue; // volver a pedir la clave
                        }
                    }

                    int opcion1 = 0;
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

                        try {
                            opcion1 = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // limpiar el scanner
                            continue;
                        }

                        switch (opcion1) {
                            case 1:
                                System.out.println("Ingrese los datos del usuario:");
                                System.out.print("Nombre: ");
                                String nombre = scanner.next();
                                System.out.print("Apellido: ");
                                String apellido = scanner.next();
                                System.out.print("Cédula: ");
                                String cedula = scanner.next();
                                System.out.print("Nombre de usuario: ");
                                String nombreUsuario = scanner.next();
                                System.out.print("Contraseña: ");
                                String contraseña = scanner.next();
                                System.out.print("Tipo de usuario (administrador/usuario): ");
                                String tipoUsuario = scanner.next();
                                crearUsuario(nombre, apellido, cedula, nombreUsuario, contraseña, tipoUsuario);
                                break;
                            case 2:
                                System.out.print("Ingrese el nombre de usuario a eliminar: ");
                                String nombreEliminar = scanner.next();
                                eliminarUsuario(nombreEliminar);
                                break;
                            case 3:
                                System.out.print("Ingrese el nombre de usuario a modificar: ");
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

    public static void crearUsuario(String nombre, String apellido, String cedula, String nombreUsuario, String contraseña, String tipoUsuario) {
        // para guardar usuario en un archivo txt
        try {
            File file = new File("usuarios\\" + nombreUsuario + ".txt");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            writer.write("Nombre: " + nombre + "\n");
            writer.write("Apellido: " + apellido + "\n");
            writer.write("Cédula: " + cedula + "\n");
            writer.write("Nombre de usuario: " + nombreUsuario + "\n");
            writer.write("Contraseña: " + contraseña + "\n");
            writer.write("Tipo de usuario: " + tipoUsuario + "\n");
            writer.close();
            System.out.println("Usuario guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el usuario.");
            e.printStackTrace();
        }
    }

    public static void eliminarUsuario(String nombreUsuario) {
        // para eliminar usuario
        File file = new File("usuarios\\" + nombreUsuario + ".txt");
        if (file.delete()) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Ocurrió un error al eliminar el usuario.");
        }
    }

    public static void modificarUsuario(String nombreUsuario) {
        // para modificar usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los nuevos datos del usuario:");
        System.out.print("Nombre: ");
        String nuevoNombre = scanner.next();
        System.out.print("Apellido: ");
        String nuevoApellido = scanner.next();
        System.out.print("Cédula: ");
        String nuevaCedula = scanner.next();
        System.out.print("Nombre de usuario: ");
        String nuevoNombreUsuario = scanner.next();
        System.out.print("Contraseña: ");
        String nuevaContraseña = scanner.next();
        System.out.print("Tipo de usuario (administrador/usuario): ");
        String nuevoTipoUsuario = scanner.next();

        eliminarUsuario(nombreUsuario); // Elimina el archivo antiguo
        crearUsuario(nuevoNombre, nuevoApellido, nuevaCedula, nuevoNombreUsuario, nuevaContraseña, nuevoTipoUsuario); // Crea un archivo nuevo con los datos modificados
    }
}

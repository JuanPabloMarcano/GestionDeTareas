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
                    // Aquí podrías se añadira lo de usuario
                    break;
                case 2:
                    boolean accesoAdministrador = false;
                    while (!accesoAdministrador) {
                        System.out.println("Has seleccionado Administrador.");
                        System.out.flush();

                        System.out.print("Ingrese la contraseña de administrador: ");
                        String claveIngresada = scanner.next();

                        // Verificara si habra administradores activos
                        if (verificarAdministrador(claveIngresada) || claveIngresada.equals("1234")) {
                            accesoAdministrador = true;
                        } else {
                            System.out.println("Clave incorrecta o no es una cuenta de administrador.");
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
        //para guardar usuario en un archivo txt
        try {
            File file = new File("usuarios/" + nombreUsuario + ".txt");
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
        //para eliminar usuario
        File file = new File("usuarios/" + nombreUsuario + ".txt");
        if (file.delete()) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Ocurrió un error al eliminar el usuario.");
        }
    }

    public static void modificarUsuario(String nombreUsuario) {
        //para modificar usuario
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

    public static boolean verificarAdministrador(String contraseña) {
        //para verificar si la contraseña corresponde a un administrador
        File folder = new File("usuarios");
        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains("Contraseña: " + contraseña)) {
                                while (scanner.hasNextLine()) {
                                    String userTypeLine = scanner.nextLine();
                                    if (userTypeLine.contains("Tipo de usuario: administrador")) {
                                        return true;
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}

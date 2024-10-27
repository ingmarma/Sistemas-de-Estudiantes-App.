package marma.presentacion;

import marma.datos.EstudianteDAO;
import marma.dominio.Estudiante;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SitemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Se crea instancia clase servicio
        var estudianteDao = new EstudianteDAO();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones (consola, estudianteDao);
            }catch (Exception e){
                System.out.println("Ocurrio un error al ejecutar operacion: " +e.getMessage());
            }
            System.out.println();

        }
    }
    private static void mostrarMenu(){
        System.out.println("""
                *** Sistema de Estudiantes ***
                1. Listar Estudiantes
                2. Buscar Estudiante6
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opcion: 
                """);
    }
    private static boolean ejecutarOpciones(Scanner consola,
                                            EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case  1 -> { //Listar estudiantes
                System.out.println("Listado de Estudiantes...");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> { //Buscar estudiante por id
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (encontrado)
                    System.out.println("Estudiante encontrado: " + estudiante);
                else
                    System.out.println("Estudiante no encontrado: " + estudiante);
            }
            case 3 -> {// Agregar estudiante
                System.out.println("Agregar Estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                // Crear el objeto persona (sin el id)
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if (agregado)
                    System.out.println("Estudiante agregado: " + estudiante);
                else
                    System.out.println("Estudiante No agregado: " + estudiante);
            }
            case 4 -> {// Modificar estudiante
                System.out.println("Modificar Estudiante: ");
                System.out.println("Id Estudiante");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //Crear objeto estudiante a modificar
                var estudiante =new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificar(estudiante);
                if (modificado)
                    System.out.println("Estudiante modificado:" + estudiante);
                else
                    System.out.println("Estudiante No Modificado: " + estudiante);
            }
            case 5 -> {// Eliminar estudiante
                System.out.println("Eliminar Estudiante: ");
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminar(estudiante);
                if (eliminado)
                    System.out.println("Estudiante eliminado: " + estudiante);
                else
                    System.out.println("Estudiante No eliminado: " + estudiante);
            }
            case 6 -> { // Salir
                System.out.println("Hasta Pronto! ");
                salir = true;
            }
            default -> System.out.println("Opcion No reconocida");
        }
        return salir;
    }
}
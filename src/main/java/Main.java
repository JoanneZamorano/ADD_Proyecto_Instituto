import dao.AlumnoDAO;
import dao.MatriculaDAO;
import dao.ModuloDAO;
import dao.ProfesorDAO;
import model.Alumno;
import model.Matricula;
import model.Modulo;
import model.Profesor;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ProfesorDAO profesorDAO = new ProfesorDAO();
    private static AlumnoDAO alumnoDAO = new AlumnoDAO();
    private static ModuloDAO moduloDAO = new ModuloDAO();
    private static MatriculaDAO matriculaDAO = new MatriculaDAO();

    public static void main(String[] args) {
        int opcionPrincipal;

        do {
            System.out.println("\n>>> Gestión IES <<<");
            System.out.println("\t1. Gestión de PROFESORES");
            System.out.println("\t2. Gestión de ALUMNOS");
            System.out.println("\t3. Gestión de MÓDULOS");
            System.out.println("\t4. Gestión de MATRÍCULAS");
            System.out.println("\t0. SALIR");
            System.out.print("Seleccione una opción: ");


            opcionPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    menuProfesores();
                    break;
                case 2:
                    menuAlumnos();
                    break;
                case 3:
                    menuModulos();
                    break;
                case 4:
                    menuMatriculas();
                    break;
                case 0:
                    System.out.println("Cerrando aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionPrincipal != 0);

        sc.close();
    }

    // --- SUBMENÚ DE PROFESORES ---
    private static void menuProfesores() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PROFESORES ---");
            System.out.println("\t1. Listar todos los profesores");
            System.out.println("\t2. Añadir nuevo profesor");
            System.out.println("\t3. Actualizar datos de un profesor");
            System.out.println("\t4. Eliminar un profesor");
            System.out.println("\t5. Buscar profesor por nombre");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    List<Profesor> lista = profesorDAO.consultarProfesores();
                    if (lista.isEmpty()) {
                        System.out.println("No hay profesores registrados.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    profesorDAO.insertarProfesor(new Profesor(nombre, dni, email));
                    break;

                case 3:
                    System.out.print("Introduce el ID del profesor a editar: ");
                    int idEdit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo Email: ");
                    String nuevoEmail = sc.nextLine();

                    profesorDAO.actualizarProfesor(idEdit, nuevoNombre, nuevoEmail);
                    break;

                case 4:
                    System.out.print("Introduce el ID del profesor a eliminar: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    profesorDAO.eliminarProfesor(idDel);
                    break;

                case 5:
                    System.out.print("Introduce el nombre (o parte) a buscar: ");
                    String busqueda = sc.nextLine();
                    List<Profesor> filtrados = profesorDAO.consultarProfesorPorNombre(busqueda);
                    filtrados.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // --- SUBMENÚ DE ALUMNOS ---
    private static void menuAlumnos() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ALUMNOS ---");
            System.out.println("\t1. Listar todos los alumnos");
            System.out.println("\t2. Añadir nuevo alumno");
            System.out.println("\t3. Actualizar datos de alumno");
            System.out.println("\t4. Eliminar alumno");
            System.out.println("\t5. Buscar alumno por DNI");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    List<Alumno> lista = alumnoDAO.consultarAlumnos();
                    if (lista.isEmpty()) {
                        System.out.println("No hay alumnos registrados.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String tlf = sc.nextLine();
                    System.out.print("Fecha Nacimiento (AAAA-MM-DD): ");
                    String fecha = sc.nextLine();

                    alumnoDAO.insertarAlumno(new Alumno(nombre, dni, tlf, fecha));
                    break;

                case 3:
                    System.out.print("Introduce el ID del alumno a editar: ");
                    int idEdit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    String nNombre = sc.nextLine();
                    System.out.print("Nuevo Teléfono: ");
                    String nTlf = sc.nextLine();

                    alumnoDAO.actualizarAlumno(idEdit, nNombre, nTlf);
                    break;

                case 4:
                    System.out.print("Introduce el ID del alumno a eliminar: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    alumnoDAO.eliminarAlumno(idDel);
                    break;

                case 5:
                    System.out.print("Introduce el DNI exacto: ");
                    String dniBusqueda = sc.nextLine();
                    Alumno a = alumnoDAO.buscarAlumnoPorDni(dniBusqueda);
                    if (a != null) {
                        System.out.println(a);
                    } else {
                        System.out.println("No se encontró ningún alumno con ese DNI");
                    }
                    break;

                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // --- SUBMENÚ DE MÓDULOS ---
    private static void menuModulos() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ MÓDULOS ---");
            System.out.println("\t1. Listar todos los módulos (con profesor)");
            System.out.println("\t2. Añadir nuevo módulo");
            System.out.println("\t3. Actualizar módulo (horas y profesor)");
            System.out.println("\t4. Eliminar módulo");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    List<Modulo> lista = moduloDAO.consultarModulos();
                    if (lista.isEmpty()) {
                        System.out.println("No hay módulos registrados.");
                    } else {
                        // El toString de tu clase Modulo mostrará los datos del Profesor gracias al JOIN
                        lista.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Nombre del Módulo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Horas semanales: ");
                    int horas = sc.nextInt();
                    System.out.print("ID del Profesor asignado: ");
                    int idProf = sc.nextInt();
                    sc.nextLine();

                    // Creamos un objeto profesor "dummy" solo con el ID para la FK
                    Profesor p = new Profesor();
                    p.setIdProfesor(idProf);

                    moduloDAO.insertarModulo(new Modulo(0, nombre, horas, p));
                    break;

                case 3:
                    System.out.print("ID del módulo a editar: ");
                    int idMod = sc.nextInt();
                    System.out.print("Nuevas horas semanales: ");
                    int nHoras = sc.nextInt();
                    System.out.print("ID del nuevo Profesor: ");
                    int nIdProf = sc.nextInt();
                    sc.nextLine();

                    moduloDAO.actualizarModulo(idMod, nHoras, nIdProf);
                    break;

                case 4:
                    System.out.print("ID del módulo a eliminar: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    moduloDAO.eliminarModulo(idDel);
                    break;

                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // --- SUBMENÚ DE MATRICULAS ---
    private static void menuMatriculas() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ MÓDULOS ---");
            System.out.println("\t1. Listar todas las matrículas (Detalle completo)");
            System.out.println("\t2. Matricular alumno en un módulo");
            System.out.println("\t3. Actualizar nota de una matrícula");
            System.out.println("\t4. Eliminar matrícula");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // Usamos el método que trae los nombres con JOIN
                    List<Matricula> lista = matriculaDAO.consultarMatriculas();
                    if (lista.isEmpty()) {
                        System.out.println("No hay matrículas registradas.");
                    } else {
                        System.out.println("\n--- LISTADO DE ALUMNOS MATRICULADOS:");
                        for (Matricula m : lista) {
                            System.out.println("\nALUMNO: " + m.getAlumno().getNombre());
                            System.out.println("\t >> MÓDULO: " + m.getModulo().getNombreModulo());
                            System.out.println("\t >> FECHA: " + m.getFechaInscripcion());
                            System.out.println("\t >> NOTA: " + m.getNotaFinal());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Introduce el ID del Alumno: ");
                    int idAl = sc.nextInt();
                    System.out.print("Introduce el ID del Módulo: ");
                    int idMod = sc.nextInt();
                    System.out.print("Introduce la nota inicial: ");
                    double nota = sc.nextDouble();
                    sc.nextLine();

                    // Creamos objetos "dummy" para pasar los IDs al DAO
                    Alumno a = new Alumno();
                    a.setIdAlumno(idAl);
                    Modulo m = new Modulo();
                    m.setIdModulo(idMod);

                    matriculaDAO.insertarMatricula(new Matricula(a, m, null, nota));
                    break;

                case 3:
                    System.out.print("ID del Alumno: ");
                    int idAlEdit = sc.nextInt();
                    System.out.print("ID del Módulo: ");
                    int idModEdit = sc.nextInt();
                    System.out.print("Nueva Nota: ");
                    double nuevaNota = sc.nextDouble();
                    sc.nextLine();

                    matriculaDAO.actualizarNota(idAlEdit, idModEdit, nuevaNota);
                    break;

                case 4:
                    System.out.print("ID del Alumno para anular matrícula: ");
                    int idAlDel = sc.nextInt();
                    System.out.print("ID del Módulo: ");
                    int idModDel = sc.nextInt();
                    sc.nextLine();

                    matriculaDAO.eliminarMatricula(idAlDel, idModDel);
                    break;

                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
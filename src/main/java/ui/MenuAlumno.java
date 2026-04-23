package ui;

import dao.AlumnoDAO;
import model.Alumno;
import java.util.Scanner;

public class MenuAlumno {
    private Scanner sc;
    private AlumnoDAO alumnoDAO;

    public MenuAlumno(Scanner sc) {
        this.sc = sc;
        this.alumnoDAO = new AlumnoDAO();
    }

    // MÉTODO AUXILIAR PARA VALIDAR
    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("\n*** ERROR: Introduce un número: ");
            }
        }
    }

    public void mostrarMenu() {
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

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    alumnoDAO.consultarAlumnos().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("DNI: "); String dni = sc.nextLine();
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    System.out.print("Teléfono: "); String tlf = sc.nextLine();
                    System.out.print("Fecha (AAAA-MM-DD): "); String fec = sc.nextLine();
                    alumnoDAO.insertarAlumno(new Alumno(nom, dni, tlf, fec));
                    break;
                case 3:
                    System.out.print("ID alumno: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo Nombre: "); String nN = sc.nextLine();
                    System.out.print("Nuevo Tlf: "); String nT = sc.nextLine();
                    alumnoDAO.actualizarAlumno(id, nN, nT);
                    break;
                case 4:
                    System.out.print("ID a eliminar: "); int idD = sc.nextInt();
                    sc.nextLine();
                    alumnoDAO.eliminarAlumno(idD);
                    break;
                case 5:
                    System.out.print("DNI: "); String d = sc.nextLine();
                    Alumno a = alumnoDAO.buscarAlumnoPorDni(d);
                    System.out.println(a != null ? a : "No encontrado.");
                    break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
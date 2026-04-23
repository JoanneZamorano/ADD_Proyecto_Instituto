package ui;

import dao.ProfesorDAO;
import model.Profesor;
import java.util.List;
import java.util.Scanner;

public class MenuProfesor {
    private Scanner sc;
    private ProfesorDAO profesorDAO;

    public MenuProfesor(Scanner sc) {
        this.sc = sc;
        this.profesorDAO = new ProfesorDAO();
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
            System.out.println("\n--- MENÚ PROFESORES ---");
            System.out.println("\t1. Listar todos los profesores");
            System.out.println("\t2. Añadir nuevo profesor");
            System.out.println("\t3. Actualizar datos de un profesor");
            System.out.println("\t4. Eliminar un profesor");
            System.out.println("\t5. Buscar profesor por nombre");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    List<Profesor> lista = profesorDAO.consultarProfesores();
                    if (lista.isEmpty()) System.out.println("No hay profesores registrados");
                    else lista.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("DNI: "); String dni = sc.nextLine();
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    profesorDAO.insertarProfesor(new Profesor(nombre, dni, email));
                    break;
                case 3:
                    System.out.print("ID profesor a editar: "); int idEdit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo Nombre: "); String nNom = sc.nextLine();
                    System.out.print("Nuevo Email: "); String nEma = sc.nextLine();
                    profesorDAO.actualizarProfesor(idEdit, nNom, nEma);
                    break;
                case 4:
                    System.out.print("ID profesor a eliminar: "); int idDel = sc.nextInt();
                    sc.nextLine();
                    profesorDAO.eliminarProfesor(idDel);
                    break;
                case 5:
                    System.out.print("Nombre a buscar: "); String busq = sc.nextLine();
                    profesorDAO.consultarProfesorPorNombre(busq).forEach(System.out::println);
                    break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
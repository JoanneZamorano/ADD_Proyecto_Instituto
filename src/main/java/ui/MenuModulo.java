package ui;

import dao.ModuloDAO;
import model.Modulo;
import model.Profesor;
import java.util.Scanner;

public class MenuModulo {
    private Scanner sc;
    private ModuloDAO moduloDAO;

    public MenuModulo(Scanner sc) {
        this.sc = sc;
        this.moduloDAO = new ModuloDAO();
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
            System.out.println("\n--- MENÚ MÓDULOS ---");
            System.out.println("\t1. Listar todos los módulos (con profesor)");
            System.out.println("\t2. Añadir nuevo módulo");
            System.out.println("\t3. Actualizar módulo (horas y profesor");
            System.out.println("\t4. Eliminar módulo");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1: moduloDAO.consultarModulos().forEach(System.out::println); break;
                case 2:
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Horas: "); int h = sc.nextInt();
                    System.out.print("ID Profesor: "); int idP = sc.nextInt();
                    sc.nextLine();
                    Profesor p = new Profesor(); p.setIdProfesor(idP);
                    moduloDAO.insertarModulo(new Modulo(0, n, h, p));
                    break;
                case 3:
                    System.out.print("ID Módulo: "); int idM = sc.nextInt();
                    System.out.print("Nuevas Horas: "); int nH = sc.nextInt();
                    System.out.print("Nuevo ID Prof: "); int nP = sc.nextInt();
                    sc.nextLine();
                    moduloDAO.actualizarModulo(idM, nH, nP);
                    break;
                case 4:
                    System.out.print("ID a borrar: "); int idB = sc.nextInt();
                    sc.nextLine();
                    moduloDAO.eliminarModulo(idB);
                    break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
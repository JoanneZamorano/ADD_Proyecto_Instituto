package ui;

import dao.MatriculaDAO;
import model.Alumno;
import model.Matricula;
import model.Modulo;

import java.util.List;
import java.util.Scanner;

public class MenuMatricula {
    private Scanner sc;
    private MatriculaDAO matriculaDAO;

    public MenuMatricula(Scanner sc) {
        this.sc = sc;
        this.matriculaDAO = new MatriculaDAO();
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
            System.out.println("\n--- MENÚ MATRÍCULAS ---");
            System.out.println("\t1. Listar todas las matrículas (Detalle completo)");
            System.out.println("\t2. Matricular alumno en un módulo");
            System.out.println("\t3. Actualizar nota de una matrícula");
            System.out.println("\t4. Eliminar matrícula");
            System.out.println("\t5. TOP 5 MEJORES NOTAS");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    for (Matricula m : matriculaDAO.consultarMatriculas()) {
                        System.out.println("\nALUMNO: " + m.getAlumno().getNombre());
                        System.out.println("\t >> MÓDULO: " + m.getModulo().getNombreModulo());
                        System.out.println("\t >> NOTA: " + m.getNotaFinal());
                    }
                    break;
                case 2:
                    System.out.print("ID Alumno: "); int idA = sc.nextInt();
                    System.out.print("ID Módulo: "); int idM = sc.nextInt();
                    System.out.print("Nota: "); double nt = sc.nextDouble();
                    sc.nextLine();
                    Alumno al = new Alumno(); al.setIdAlumno(idA);
                    Modulo mo = new Modulo(); mo.setIdModulo(idM);
                    matriculaDAO.insertarMatricula(new Matricula(al, mo, null, nt));
                    break;
                case 3:
                    System.out.print("ID Alumno: "); int iA = sc.nextInt();
                    System.out.print("ID Módulo: "); int iM = sc.nextInt();
                    System.out.print("Nueva Nota: "); double nNt = sc.nextDouble();
                    sc.nextLine();
                    matriculaDAO.actualizarNota(iA, iM, nNt);
                    break;
                case 4:
                    System.out.print("ID Alumno: "); int dA = sc.nextInt();
                    System.out.print("ID Módulo: "); int dM = sc.nextInt();
                    sc.nextLine();
                    matriculaDAO.eliminarMatricula(dA, dM);
                    break;
                case 5:
                    System.out.println("\n--- TOP 5 MEJORES NOTAS ---");
                    List<Matricula> top = matriculaDAO.obtenerTopNotas();
                    if (top.isEmpty()) {
                        System.out.println("No hay notas registradas");
                    } else {
                        for (Matricula m : top) {
                            System.out.println(" - Nota: " + m.getNotaFinal() + " | Alumno: " + m.getAlumno().getNombre() + " | Módulo: " + m.getModulo().getNombreModulo());
                        }
                    }
                    break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
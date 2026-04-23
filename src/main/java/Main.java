import ui.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionPrincipal;

        // instancio los menús:
        MenuProfesor menuProfesor = new MenuProfesor(sc);
        MenuAlumno menuAlumno = new MenuAlumno(sc);
        MenuModulo menuModulo = new MenuModulo(sc);
        MenuMatricula menuMatricula = new MenuMatricula(sc);

        do {
            System.out.println("\n>>> GESTIÓN IES <<<");
            System.out.println("\t1. Gestión de PROFESORES");
            System.out.println("\t2. Gestión de ALUMNOS");
            System.out.println("\t3. Gestión de MÓDULOS");
            System.out.println("\t4. Gestión de MATRÍCULAS");
            System.out.println("\t0. SALIR");
            System.out.print("Seleccione una opción: ");

            // VALIDACIÓN DEL MAIN
            try {
                opcionPrincipal = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("***ERROR: Tienes que meter un número.");
                opcionPrincipal = -1; //forzamos que entre al default del switch
            }

            switch (opcionPrincipal) {
                case 1: menuProfesor.mostrarMenu(); break;
                case 2: menuAlumno.mostrarMenu(); break;
                case 3: menuModulo.mostrarMenu(); break;
                case 4: menuMatricula.mostrarMenu(); break;
                case 0: System.out.println("Cerrando aplicación..."); break;
                default: System.out.println("Opción no válida");
            }
        } while (opcionPrincipal != 0);

        sc.close();
    }
}
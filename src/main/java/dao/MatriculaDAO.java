package dao;

import database.DatabaseConnection;
import model.Alumno;
import model.Matricula;
import model.Modulo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    // 1. CREATE
    public void insertarMatricula(Matricula matricula) {
        String sql = "INSERT INTO matriculas(id_alumno, id_modulo, nota_final) VALUES (?,?,?)";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            /**
             * obtengo los IDs de los objetos Alumno y Modulo que contiene la Matricula
             */
            ps.setInt(1, matricula.getAlumno().getIdAlumno());
            ps.setInt(2, matricula.getModulo().getIdModulo());
            ps.setDouble(3, matricula.getNotaFinal());

            ps.executeUpdate();
            ps.close();

            System.out.println("Matrícula registrada con éxito");

        } catch (SQLException e) {
            throw new RuntimeException("Error: el alumno ya existe en este módulo o IDs erroneos");
        }
    }

    // 2. READ
    public List<Matricula> consultarMatriculas() {
        List<Matricula> lista = new ArrayList<>();

        String sql = "SELECT m.*, a.nombre as nom_al, mod.nombre_modulo as nom_mod " +
                "FROM matriculas m " +
                "JOIN alumnos a ON m.id_alumno = a.id_alumno " +
                "JOIN modulos mod ON m.id_modulo = mod.id_modulo";

        try {
            Connection conn = DatabaseConnection.conectar();
            ResultSet rs = conn.createStatement().executeQuery(sql);

            // 2. Por cada fila que nos devuelva la base de datos...
            while (rs.next()) {

                // Creamos un alumno y le ponemos el nombre que viene en la fila
                Alumno al = new Alumno();
                al.setIdAlumno(rs.getInt("id_alumno"));
                al.setNombre(rs.getString("nom_al"));

                // Creamos el módulo y le ponemos su nombre
                Modulo mo = new Modulo();
                mo.setIdModulo(rs.getInt("id_modulo"));
                mo.setNombreModulo(rs.getString("nom_mod"));

                // Juntamos todo en el objeto Matricula
                Matricula mat = new Matricula(
                        al,
                        mo,
                        rs.getDate("fecha_inscripcion"),
                        rs.getDouble("nota_final")
                );

                // Guardamos la matrícula en nuestra lista
                lista.add(mat);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }

        return lista; // Devolvemos la lista llena de matrículas
    }

    // 3. UPDATE
    public void actualizarNota(int idAlumno, int idModulo, double nuevaNota) {
        String sql = "UPDATE matriculas SET nota_final = ? WHERE id_alumno = ? AND id_modulo = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, nuevaNota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idModulo);

            ps.executeUpdate();
            ps.close();

            System.out.println("Nota actualizada con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 4. DELETE
    public void eliminarMatricula(int idAlumno, int idModulo) {
        String sql = "DELETE FROM matriculas WHERE id_alumno = ? AND id_modulo = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idAlumno);
            ps.setInt(2, idModulo);

            ps.executeUpdate();
            ps.close();

            System.out.println("Matrícula eliminada con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
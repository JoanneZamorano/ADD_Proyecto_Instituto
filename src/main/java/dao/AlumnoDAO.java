package dao;

import database.DatabaseConnection;
import model.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    // 1. CREATE
    public void insertarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos(dni, nombre, telefono, fecha_nacimiento) VALUES (?,?,?,?)";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getTelefono());
            // Convertimos el String de fecha a java.sql.Date
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));

            ps.executeUpdate();
            ps.close();

            System.out.println("Alumno insertado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: El formato de fecha debe ser YYYY-MM-DD");
        }
    }

    // 2. READ (todos los alumnos)
    public List<Alumno> consultarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try {
            Connection conn = DatabaseConnection.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getInt("id_alumno"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("fecha_nacimiento")
                );
                alumnos.add(alumno);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alumnos;
    }

    // 3. UPDATE
    public void actualizarAlumno(int id, String nombre, String telefono) {
        String sql = "UPDATE alumnos SET nombre = ?, telefono = ? WHERE id_alumno = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setInt(3, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Alumno actualizado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 4. DELETE
    public void eliminarAlumno(int id) {
        String sql = "DELETE FROM alumnos WHERE id_alumno = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Alumno eliminado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 5. CONSULTA FILTRO POR DNI
    public Alumno buscarAlumnoPorDni(String dni) {
        String sql = "SELECT * FROM alumnos WHERE dni = ?";
        Alumno alumno = null;

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno(
                        rs.getInt("id_alumno"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("fecha_nacimiento")
                );
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alumno;
    }
}
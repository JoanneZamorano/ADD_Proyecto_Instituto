package dao;

import database.DatabaseConnection;
import model.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    // 1. CREATE
    public void insertarProfesor(Profesor profesor) {
        String sql = "INSERT INTO profesores(dni, nombre, email) VALUES (?,?,?)";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, profesor.getDni());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getEmail());

            ps.executeUpdate();
            ps.close();

            System.out.println("Profesor insertado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 2. READ
    public List<Profesor> consultarProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT * FROM profesores";

        try {
            Connection conn = DatabaseConnection.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Profesor profesor = new Profesor(
                        rs.getInt("id_profesor"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("email")
                );
                profesores.add(profesor);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profesores;
    }

    // 3. UPDATE: Actualiza nombre y email
    public void actualizarProfesor(int id, String nombre, String email) {
        String sql = "UPDATE profesores SET nombre = ?, email = ? WHERE id_profesor = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setInt(3, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Profesor actualizado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 4. DELETE
    public void eliminarProfesor(int id) {
        String sql = "DELETE FROM profesores WHERE id_profesor = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Profesor eliminado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 5. CONSULTA POR FILTRO NOMBRE
    public List<Profesor> consultarProfesorPorNombre(String filtroNombre) {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT * FROM profesores WHERE nombre LIKE ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + filtroNombre + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                profesores.add(new Profesor(
                        rs.getInt("id_profesor"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("email")
                ));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profesores;
    }
}








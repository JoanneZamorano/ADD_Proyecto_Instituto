package dao;

import database.DatabaseConnection;
import model.Modulo;
import model.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuloDAO {

    // 1. CREATE:
    /**
     * Recibe el objeto Modulo y saca el id_profesor del objeto Profesor interno
     * @param modulo
     */
    public void insertarModulo(Modulo modulo) {
        String sql = "INSERT INTO modulos(nombre_modulo, horas_semanales, id_profesor) VALUES (?,?,?)";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, modulo.getNombreModulo());
            ps.setInt(2, modulo.getHorasSemanales());

            // Si el módulo tiene un profesor asignado, guardamos su ID
            if (modulo.getProfesor() != null) {
                ps.setInt(3, modulo.getProfesor().getIdProfesor());
            } else {
                ps.setNull(3, Types.INTEGER);
            }

            ps.executeUpdate();
            ps.close();
            System.out.println("Módulo insertado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 2.READ
    /**
     * Aquí hacemos un JOIN para traer los datos del profesor de una vez
     * @return
     */
    public List<Modulo> consultarModulos() {
        List<Modulo> modulos = new ArrayList<>();
        // Consulta con JOIN para obtener nombre del profesor también
        String sql = "SELECT m.*, p.nombre as nombre_prof, p.dni, p.email " +
                "FROM modulos m " +
                "LEFT JOIN profesores p ON m.id_profesor = p.id_profesor";

        try {
            Connection conn = DatabaseConnection.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Creamos el objeto Profesor con los datos del JOIN
                Profesor prof = null;
                if (rs.getInt("id_profesor") != 0) {
                    prof = new Profesor(
                            rs.getInt("id_profesor"),
                            rs.getString("nombre_prof"),
                            rs.getString("dni"),
                            rs.getString("email")
                    );
                }

                // Creamos el Modulo pasándole el objeto Profesor
                Modulo modulo = new Modulo(
                        rs.getInt("id_modulo"),
                        rs.getString("nombre_modulo"),
                        rs.getInt("horas_semanales"),
                        prof
                );
                modulos.add(modulo);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return modulos;
    }

    // 3. UPDATE
    public void actualizarModulo(int idModulo, int nuevasHoras, int idNuevoProfesor) {
        String sql = "UPDATE modulos SET horas_semanales = ?, id_profesor = ? WHERE id_modulo = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, nuevasHoras);
            ps.setInt(2, idNuevoProfesor);
            ps.setInt(3, idModulo);

            ps.executeUpdate();
            ps.close();
            System.out.println("Módulo actualizado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 4. DELETE
    public void eliminarModulo(int id) {
        String sql = "DELETE FROM modulos WHERE id_modulo = ?";

        try {
            Connection conn = DatabaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Módulo eliminado con éxito");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
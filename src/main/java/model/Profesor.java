package model;

public class Profesor {
    private int idProfesor;
    private String nombre;
    private String dni;
    private String email;

    //Constructores:
    public Profesor() { }

    public Profesor(int id_profesor, String nombre, String dni, String email) {
        this.idProfesor = id_profesor;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public Profesor(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    //GETTERS y SETTERS

    public int getIdProfesor() { return idProfesor; }

    public void setIdProfesor(int idProfesor) { this.idProfesor = idProfesor; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    //toString
    @Override
    public String toString() {
        return "Profesor{" +
                "id_profesor=" + idProfesor +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

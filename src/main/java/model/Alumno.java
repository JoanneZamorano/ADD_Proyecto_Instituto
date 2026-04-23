package model;

public class Alumno {
    private int idAlumno;
    private String nombre;
    private String dni;
    private String telefono;
    private String fechaNacimiento;

    //Constructores:
    public Alumno() {}

    public Alumno(int idAlumno, String nombre, String dni, String telefono, String fechaNacimiento) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Alumno(String nombre, String dni, String telefono, String fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    //GETTERS y SETTERS
    public int getIdAlumno() { return idAlumno; }
    public void setIdAlumno(int idAlumno) { this.idAlumno = idAlumno; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getTelefono() {return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    //toString
    @Override
    public String toString() {
        return "Alumno: " + nombre.toUpperCase() +
                "\n\tID Alumno: " + idAlumno + "\t| DNI: " + dni +
                "\n\tteléfono: " + telefono + "\t| fecha Nacimiento: " + fechaNacimiento + "\n";
    }
}

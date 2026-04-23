package model;

import java.util.Date;

public class Matricula {
    /**
     * La clave primaria en la BD es compuesta (id_alumno + id_modulo),
     * así que usamos los objetos completos para representarla
     */
    private Alumno alumno;
    private Modulo modulo;
    private Date fechaInscripcion;
    private double notaFinal;

    // Constructores
    public Matricula() { }

    public Matricula(Alumno alumno, Modulo modulo, Date fechaInscripcion, double notaFinal) {
        this.alumno = alumno;
        this.modulo = modulo;
        this.fechaInscripcion = fechaInscripcion;
        this.notaFinal = notaFinal;
    }

    // Getters y Setters
    public Alumno getAlumno() { return alumno; }

    public void setAlumno(Alumno alumno) { this.alumno = alumno; }

    public Modulo getModulo() { return modulo; }

    public void setModulo(Modulo modulo) { this.modulo = modulo; }

    public Date getFechaInscripcion() { return fechaInscripcion; }

    public void setFechaInscripcion(Date fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    public double getNotaFinal() { return notaFinal; }

    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }

    @Override
    public String toString() {
        return "Matricula{" +
                "alumno=" + alumno +
                ", modulo=" + modulo +
                ", fechaInscripcion=" + fechaInscripcion +
                ", notaFinal=" + notaFinal +
                '}';
    }
}
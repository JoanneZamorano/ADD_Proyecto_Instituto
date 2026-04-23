package model;

public class Modulo {
    private int idModulo;
    private String nombreModulo;
    private int horasSemanales;
    private Profesor profesor; // idProfesor

    // Constructores:
    public Modulo() { }

    public Modulo(String nombreModulo, int horasSemanales, Profesor profesor) {
        this.nombreModulo = nombreModulo;
        this.horasSemanales = horasSemanales;
        this.profesor = profesor;
    }

    public Modulo(int idModulo, String nombreModulo, int horasSemanales, Profesor profesor) {
        this.idModulo = idModulo;
        this.nombreModulo = nombreModulo;
        this.horasSemanales = horasSemanales;
        this.profesor = profesor;
    }

    //Getters y Setters
    public int getIdModulo() { return idModulo;}

    public void setIdModulo(int idModulo) { this.idModulo = idModulo;}

    public String getNombreModulo() { return nombreModulo;}

    public void setNombreModulo(String nombreModulo) { this.nombreModulo = nombreModulo;}

    public int getHorasSemanales() { return horasSemanales;}

    public void setHorasSemanales(int horasSemanales) { this.horasSemanales = horasSemanales;}

    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    //toString
    @Override
    public String toString() {
        return "Modulo{" +
                "idModulo=" + idModulo +
                ", nombreModulo='" + nombreModulo + '\'' +
                ", horasSemanales=" + horasSemanales +
                ", profesor=" + profesor +
                '}';
    }
}

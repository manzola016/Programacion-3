public class Estudiante {
    private final String cedula;
    private String nombre;
    private int edad;
    private float nota;

    public Estudiante(String cedula, String nombre, int edad, float nota) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nota=" + nota +
                '}';
    }
}

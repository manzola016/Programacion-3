public class ValidadorEntrada {

    public static String validarLetras(String str) throws IllegalArgumentException {
        if (!str.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Se deben ingresar solo letras");
        }
        return str;
    }

    public static int validarEdad(int edad) throws EdadInvalidaExcepcion {
        if (edad <= 0) {
            throw new EdadInvalidaExcepcion("La edad debe ser mayor a 0");
        }
        return edad;
    }

    public static float validarNota(float nota) throws IllegalArgumentException {
        if (nota <= 0 || nota > 20) {
            throw new IllegalArgumentException("Nota invalida. Rango (1 - 20)");
        }
        return nota;
    }
}
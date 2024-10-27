public class ValidadorEntrada {

    public static String validarLetras(String str) throws IllegalArgumentException {
        if (!str.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Se deben ingresar solo letras");
        }
        return str;
    }

    public static int validarCantidad(int cantidad) throws CantidadInvalidaExcepcion {
        if (cantidad <= 0) {
            throw new CantidadInvalidaExcepcion("La cantidad debe ser mayor a 0");
        }
        return cantidad;
    }

    public static float validarPrecio(float precio) throws IllegalArgumentException {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        return precio;
    }
}
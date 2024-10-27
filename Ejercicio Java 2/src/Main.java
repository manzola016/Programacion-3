import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utilidades utilidades = new Utilidades();
        utilidades.cargarProductos();
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        while (x == 1) {
            System.out.println("CRUD DE PRODUCTOS\n1 - Agregar\n2 - Mostrar\n3 - Actualizar\n4 - Eliminar\n5 - Generar reporte\n6 - Salir\nSeleccione una opcion: ");
            int opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    utilidades.agregar();
                    break;
                case 2:
                    utilidades.mostrar();
                    break;
                case 3:
                    utilidades.actualizar();
                    break;
                case 4:
                    utilidades.eliminar();
                    break;
                case 5:
                    utilidades.generarReporte();
                    break;
                case 6:
                    x = 2;
                    break;
                default:
                    System.out.println("Ingrese una opcion del 1 al 6. Intente de nuevo.");
            }
        }
    }
}
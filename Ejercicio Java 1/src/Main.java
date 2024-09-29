
//MANUEL ANZOLA - 32666091

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utilidades utilidades = new Utilidades();
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        while (x == 1) {
            System.out.println("CRUD DE ESTUDIANTES\n1 - Agregar\n2 - Mostrar\n3 - Actualizar\n4 - Eliminar\n5 - Salir\nSeleccione una opcion: ");
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
                    x = 2;
                    break;
                default:
                    System.out.println("No sea idiota. No ve que tiene que elegir una opcion del 1 al 5. Inutil");
            }
        }
    }
}

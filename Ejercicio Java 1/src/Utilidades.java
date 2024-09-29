import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {
    private final ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void agregar() {
        String nombre = null;
        int edad = 0;
        float nota = 0f;
        System.out.println("Ingrese la cedula del estudiante: ");
        String cedula = scanner.nextLine();
        while (nombre == null) {
            System.out.println("Ingrese el nombre del estudiante: ");
            try {
                nombre = ValidadorEntrada.validarLetras(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
            }
        }
        while (edad <= 0) {
            System.out.println("Ingrese la edad del estudiante: ");
            try {
                edad = ValidadorEntrada.validarEdad(scanner.nextInt());
                scanner.nextLine();
            } catch (EdadInvalidaExcepcion e) {
                System.out.println(e.getMessage());
            }
        }
        while (nota <= 0 || nota > 20) {
            System.out.println("Ingrese la nota del estudiante: ");
            try {
                nota = ValidadorEntrada.validarNota(scanner.nextFloat());
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("El decimal debe marcarse con una coma (,)");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
            }
        }
        Estudiante nuevoEstudiante = new Estudiante(cedula, nombre, edad, nota);
        estudiantes.add(nuevoEstudiante);
        System.out.println("Estudiante agregado exitosamente :-)");
    }

    public void mostrar() {
        System.out.println("LISTA DE ESTUDIANTES");
        int contador = 1;
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Estudiante #" + contador + ":" + "\nCedula: " + estudiante.getCedula() + "\nNombre: " + estudiante.getNombre() + "\nEdad: " + estudiante.getEdad() + "\nNota: " + estudiante.getNota() + "\n");
            contador++;
        }
    }

    public void actualizar() {
        String nuevoNombre = null;
        int nuevaEdad = 0;
        float nuevaNota = 0f;
        System.out.println("Ingrese la cedula del estudiante: ");
        String cedula = scanner.nextLine();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                System.out.println("1 - Nombre\n2 - Edad\n3 - Nota\n4 - Todos los datos\n5 - Cancelar\nSeleccione que dato desea actualizar: ");
                int opc = scanner.nextInt();
                scanner.nextLine();
                switch (opc) {
                    case 1:
                        while (nuevoNombre == null) {
                            System.out.println("Ingrese el nombre del estudiante: ");
                            try {
                                nuevoNombre = ValidadorEntrada.validarLetras(scanner.nextLine());
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Error no controlado");
                                System.out.println(e.getMessage());
                            }
                        }
                        estudiante.setNombre(nuevoNombre);
                        System.out.println("Nombre actualizado exitosamente :-)");
                        return;
                    case 2:
                        while (nuevaEdad <= 0) {
                            System.out.println("Ingrese la edad del estudiante: ");
                            try {
                                nuevaEdad = ValidadorEntrada.validarEdad(scanner.nextInt());
                                scanner.nextLine();
                            } catch (EdadInvalidaExcepcion e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        estudiante.setEdad(nuevaEdad);
                        System.out.println("Edad actualizada exitosamente :-)");
                        return;
                    case 3:
                        while (nuevaNota <= 0 || nuevaNota > 20) {
                            System.out.println("Ingrese la nota del estudiante: ");
                            try {
                                nuevaNota = ValidadorEntrada.validarNota(scanner.nextFloat());
                                scanner.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("El decimal debe marcarse con una coma (,)");
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Error no controlado");
                                System.out.println(e.getMessage());
                            }
                        }
                        estudiante.setNota(nuevaNota);
                        System.out.println("Nota actualizada exitosamente :-)");
                        return;
                    case 4:
                        while (nuevoNombre == null) {
                            System.out.println("Ingrese el nombre del estudiante: ");
                            try {
                                nuevoNombre = ValidadorEntrada.validarLetras(scanner.nextLine());
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Error no controlado");
                                System.out.println(e.getMessage());
                            }
                        }
                        while (nuevaEdad <= 0) {
                            System.out.println("Ingrese la edad del estudiante: ");
                            try {
                                nuevaEdad = ValidadorEntrada.validarEdad(scanner.nextInt());
                                scanner.nextLine();
                            } catch (EdadInvalidaExcepcion e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        while (nuevaNota <= 0 || nuevaNota > 20) {
                            System.out.println("Ingrese la nota del estudiante: ");
                            try {
                                nuevaNota = ValidadorEntrada.validarNota(scanner.nextFloat());
                                scanner.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("El decimal debe marcarse con una coma (,)");
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Error no controlado");
                                System.out.println(e.getMessage());
                            }
                        }
                        estudiante.setNombre(nuevoNombre);
                        estudiante.setEdad(nuevaEdad);
                        estudiante.setNota(nuevaNota);
                        System.out.println("Datos del estudiante actualizados exitosamente :-)");
                        return;
                    case 5:
                        return;
                    default:
                        System.out.println("No sea idiota. No ve que tiene que elegir una opcion del 1 al 5. Inutil");
                }
            }
        }
        System.out.println("Estudiante no encontrado. Seguro puso la cedula mal, maldito(a) idiota");
    }

    public void eliminar() {
        System.out.println("Ingrese la cedula del estudiante a eliminar: ");
        String cedula = scanner.nextLine();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                estudiantes.remove(estudiante);
                System.out.println("Estudiante eliminado exitosamente :-)");
                return;
            }
        }
        System.out.println("Estudiante no encontrado. Seguro puso la cedula mal, maldito(a) idiota");
    }
}

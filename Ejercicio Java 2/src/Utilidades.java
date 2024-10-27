import java.io.*;
import java.util.*;

public class Utilidades {
    private ArrayList<Producto> productos = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void cargarProductos() {
        try (FileInputStream archivo = new FileInputStream("listaProductos.bin");
             ObjectInputStream entrada = new ObjectInputStream(archivo)) {
            productos = (ArrayList<Producto>)entrada.readObject();
            System.out.println("Productos cargados exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro un reporte anterior, se empezara con uno nuevo.");
            productos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los productos: " + e.getMessage());
            productos = new ArrayList<>();
        }
    }

    public void guardarProducto() {
        try (FileOutputStream archivo = new FileOutputStream("listaProductos.bin")){
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(productos);
        } catch (IOException e) {
            System.err.println("Error al guardar producto: " + e.getMessage());
        }
    }

    public void agregar() {
        String nombre = null;
        int cantidad = 0;
        float precio = 0f;
        System.out.println("Ingrese el ID del producto: ");
        String id = scanner.nextLine();
        while (nombre == null) {
            System.out.println("Ingrese el nombre del producto: ");
            try {
                nombre = ValidadorEntrada.validarLetras(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error no controlado.");
                System.out.println(e.getMessage());
            }
        }
        while (cantidad <= 0) {
            System.out.println("Ingrese la cantidad del producto: ");
            try {
                cantidad = ValidadorEntrada.validarCantidad(scanner.nextInt());
                scanner.nextLine();
            } catch (CantidadInvalidaExcepcion e) {
                System.out.println(e.getMessage());
            }
        }
        while (precio <= 0) {
            System.out.println("Ingrese el precio del producto: ");
            try {
                precio = ValidadorEntrada.validarPrecio(scanner.nextFloat());
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("El decimal debe marcarse con una coma (,)");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error no controlado.");
                System.out.println(e.getMessage());
            }
        }
        Producto nuevoProducto = new Producto(id, nombre, cantidad, precio);
        productos.add(nuevoProducto);
        guardarProducto();
        System.out.println("Producto agregado exitosamente.");
    }

    public void mostrar() {
        System.out.println("LISTA DE PRODUCTOS");
        int contador = 1;
        for (Producto producto : productos) {
            System.out.println("Producto #" + contador + ":" + "\nID: " + producto.getId() + "\nNombre: " + producto.getNombre() + "\nCantidad: " + producto.getCantidad() + "\nPrecio: " + producto.getPrecio() + "\n");
            contador++;
        }
    }

    public void actualizar() {
        String nuevoNombre = null;
        int nuevaCantidad = 0;
        float nuevoPrecio = 0f;
        System.out.println("Ingrese el ID del producto: ");
        String id = scanner.nextLine();
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                System.out.println("1 - Nombre\n2 - Cantidad\n3 - Precio\n4 - Todos los datos\n5 - Cancelar\nSeleccione que dato desea actualizar: ");
                int opc = scanner.nextInt();
                scanner.nextLine();
                switch (opc) {
                    case 1:
                        while (nuevoNombre == null) {
                            System.out.println("Ingrese el nombre del producto: ");
                            try {
                                nuevoNombre = ValidadorEntrada.validarLetras(scanner.nextLine());
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Error no controlado.");
                                System.out.println(e.getMessage());
                            }
                        }
                        producto.setNombre(nuevoNombre);
                        guardarProducto();
                        System.out.println("Nombre actualizado exitosamente.");
                        return;
                    case 2:
                        while (nuevaCantidad <= 0) {
                            System.out.println("Ingrese la cantidad del producto: ");
                            nuevaCantidad = ValidadorEntrada.validarCantidad(scanner.nextInt());
                            scanner.nextLine();
                        }
                        producto.setCantidad(nuevaCantidad);
                        guardarProducto();
                        System.out.println("Cantidad actualizada exitosamente.");
                        return;
                    case 3:
                        while (nuevoPrecio <= 0) {
                            System.out.println("Ingrese el precio del producto: ");
                            try {
                                nuevoPrecio = ValidadorEntrada.validarPrecio(scanner.nextFloat());
                                scanner.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("El decimal debe marcarse con una coma (,)");
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Error no controlado.");
                                System.out.println(e.getMessage());
                            }
                        }
                        producto.setPrecio(nuevoPrecio);
                        guardarProducto();
                        System.out.println("Precio actualizado exitosamente.");
                        return;
                    case 4:
                        while (nuevoNombre == null) {
                            System.out.println("Ingrese el nombre del producto: ");
                            try {
                                nuevoNombre = ValidadorEntrada.validarLetras(scanner.nextLine());
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Error no controlado.");
                                System.out.println(e.getMessage());
                            }
                        }
                        while (nuevaCantidad <= 0) {
                            System.out.println("Ingrese la cantidad del producto: ");
                            nuevaCantidad = ValidadorEntrada.validarCantidad(scanner.nextInt());
                            scanner.nextLine();
                        }
                        while (nuevoPrecio <= 0) {
                            System.out.println("Ingrese el precio del producto: ");
                            try {
                                nuevoPrecio = ValidadorEntrada.validarPrecio(scanner.nextFloat());
                                scanner.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("El decimal debe marcarse con una coma (,)");
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Error no controlado.");
                                System.out.println(e.getMessage());
                            }
                        }
                        producto.setNombre(nuevoNombre);
                        producto.setCantidad(nuevaCantidad);
                        producto.setPrecio(nuevoPrecio);
                        guardarProducto();
                        System.out.println("Datos del producto actualizados exitosamente.");
                        return;
                    case 5:
                        return;
                    default:
                        System.out.println("Ingrese una opcion del 1 al 5. Intente de nuevo.");
                }
            }
        }
        System.out.println("Producto no encontrado. Intente de nuevo.");
    }

    public void eliminar() {
        System.out.println("Ingrese el ID del producto a eliminar: ");
        String id = scanner.nextLine();
        Iterator<Producto> iterador = productos.iterator();
        while (iterador.hasNext()) {
            Producto producto = iterador.next();
            if (producto.getId().equals(id)) {
                iterador.remove();
                guardarProducto();
                System.out.println("Producto eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado. Intente de nuevo.");
    }

    public void generarReporte() {
        List<Producto> productosFiltrados = productos.stream().filter(p -> p.getCantidad() >= 12 && p.getPrecio() >= 10).toList();
        try (PrintWriter writer = new PrintWriter("reporte.txt")) {
            int contador = 1;
            for (Producto p : productosFiltrados) {
                writer.println("Producto #" + contador + ":" + "\nID: " + p.getId() + "\nNombre: " + p.getNombre() + "\nCantidad: " + p.getCantidad() + "\nPrecio: " + p.getPrecio() + "\n");
                contador++;
            }
            System.out.println("Reporte generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar reporte: " + e.getMessage());
        }
    }
}

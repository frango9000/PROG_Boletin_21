package libreria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Libreria {
    ArrayList<Libro> libreria = new ArrayList<>();

    public void agregarLibro(Libro libro){
        libreria.add(libro);
    }
    public void agregarLibro(Libro... libros){
        for (int i = 0; i < libros.length; i++) {
            libreria.add(libros[i]);
        }
    }

    public void mostrarInventario(){
        for (int i = 0; i < libreria.size(); i++) {
            System.out.printf("%d - %s %n", i+1, libreria.get(i).toString());
        }
    }
    public Libro elegirLibro(){
        mostrarInventario();
        int opcion;
        do {
            System.out.print("Elige un libro: ");
            opcion = scan().nextInt()-1;
        }while( opcion < 0 || opcion >= libreria.size() );
        return libreria.get(opcion);
    }


    public void limpiarInventario(){
        for (Iterator<Libro> iterator = libreria.iterator(); iterator.hasNext(); ) {
            Libro libro = iterator.next();
            if( libro.getStock() < 1 ){
                System.out.println("Eliminando " + libro.toString());
                iterator.remove();
            }
        }
    }
    //Menu
    public static String[] opciones = { "Nuevo Libro", "Mostrar Inventario", "Ver Libro", "Vender Libro", "Limpiar Inventario", "Salir" };

    public int mostrarMenu(){
        System.out.println("Menu Libreria:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.printf("%d - %s %n", i+1, opciones[i]);
        }
        System.out.print("Elige una opcion ");
        int select = -1;
        do{
            String input = scan().next();
            if(!isInteger(input))
                continue;
            select=Integer.parseInt(input)-1;
        }while(select<1 || select>opciones.length);
        return select;
    }


    public  void menuActions(int option){
        switch (option){
            case 0://Nuevo Libro
                agregarLibro(Libro.nuevoLibro());
                break;
            case 1://Mostrar Inventario
                mostrarInventario();
                scan().nextLine();
                break;
            case 2://Ver Libro
                elegirLibro().mostrarLibro();
                scan().nextLine();
                break;
            case 3://Vender Libro
                elegirLibro().venderLibro();
                break;
            case 4://Limpiar Inventario
                limpiarInventario();
                break;
            case 5://Salir
                System.exit(0);
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static Scanner scan(){
        return new Scanner(System.in);
    }
}

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
    public void eliminarLibro(Libro libro){
        if(libreria.contains(libro)){
            System.out.println("Eliminando " + libro.toString());
            libreria.remove(libro);
        }else System.out.println("No tenemos ese libro, no se puede eliminar.");

    }

    public void mostrarInventario(){
        for (int i = 0; i < libreria.size(); i++) {
            System.out.printf("%d - %s %n", i+1, libreria.get(i).toString());
        }
    }
    public Libro elegirLibro(){
        Scanner scan = new Scanner(System.in);

        mostrarInventario();
        int opcion;
        do {
            System.out.print("Elige un libro: ");
            opcion = scan.nextInt()-1;
        }while( opcion < 0 || opcion >= libreria.size() );
        return libreria.get(opcion);
    }


    public void limpiarInventario(){
        for (Iterator<Libro> iterator = libreria.iterator(); iterator.hasNext(); ) {
            Libro libro = iterator.next();
            if( libro.getStock() < 1 ){
                eliminarLibro(libro);
            }
        }
    }
}

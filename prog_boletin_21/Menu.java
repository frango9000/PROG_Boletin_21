package prog_boletin_21;

import libreria.Libreria;
import libreria.Libro;

import java.util.Scanner;

public class Menu {

    public static String[] opciones = { "Nuevo Libro", "Mostrar Inventario", "Ver Libro", "Vender Libro", "Limpiar Inventario", "Salir" };

    public static int mostrarMenu(){
        System.out.println("Menu Libreria:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.printf("%d - %s %n", i+1, opciones[i]);
        }
        System.out.print("Elige una opcion ");
        int select = -1;
        Scanner scan = new Scanner(System.in);
        do{
            String input = scan.next();
            if(!isInteger(input))
                continue;
            select=Integer.parseInt(input)-1;
        }while(select<1 || select>opciones.length);
        return select;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void menuActions(Libreria libreria, int option){
        switch (option){
            case 0://Nuevo Libro
                libreria.agregarLibro(Libro.nuevoLibro());
            case 1://Mostrar Inventario
                libreria.mostrarInventario();
            case 2://Ver Libro
                libreria.elegirLibro().mostrarLibro();
            case 3://Vender Libro
                libreria.elegirLibro().venderLibro();
            case 4://Limpiar Inventario
                libreria.limpiarInventario();
            case 5://Salir
                System.exit(0);
        }
    }



}

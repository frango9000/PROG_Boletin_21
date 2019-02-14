package prog_boletin_21;
//@author fsancheztemprano


import libreria.Libreria;
import libreria.Libro;

/*
Realiza un programa para levar o mantemento dunha librería. Para iso :
    1- Realiza un diagrama de clases que reflicta as relación entre as clases  e
logo implementa o programa tendo en conta :
Cada libro de levar : título , autor , ISBN (String ) , prezo , e numero de unidades.
O programa debe :
    • engadir libros
    • vender ( borrar ) libros
    • amosar  os libros que temos  ( Os libros deben estar ordenados polo campo titulo )
    • dar de baixa os libros con numero de unidades =0
    • consultar un libro determinado
Nos métodos vender, amosar, baixas e consultar debes comprobar que o array recibido non é null. 
No caso contrario lanza una excepción.
Para a clase aplicación utiliza un paquete e para as demais outro paquete.
Na aplicación do programa utiliza un menú con todas as opción .
*/
public class PROG_Boletin_21 {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Libro libro1 = new Libro("Libro 1", "Autor 1", "315479451", 3.50f, 3);
        Libro libro2 = new Libro("Libro 2", "Autor 2", "494949445", 3.50f, 5);
        Libro libro3 = new Libro("Libro 3", "Autor 3", "178494987", 3.50f, 1);
        libreria.agregarLibro(libro1, libro2, libro3);

        while(true) {
            libreria.menuActions(libreria.mostrarMenu());
        }
    }
}
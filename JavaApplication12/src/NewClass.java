

import java.util.*;
import java.io.*;

class NewClass {

    //programa que pide una ruta de directorio
    //almacena todos los archivos o carpetas dentro de una fila fifo
    //y por ultimo abre uno por uno en forma de fila el primero en entrar primero en salir 
    
    //funcion principal desde donde inicial el programa
    
    public static void main(String[] args) throws InterruptedException, IOException {
        iniciarFilaEnteros();
    }


    public static void iniciarFilaEnteros() throws InterruptedException {

        //creamos la fila en este caso de numeros enteros
        Queue<Integer> filaNumeros = new LinkedList<Integer>();

        //creamos la clase scan para pedir datos desde la consola
        Scanner scan = new Scanner(System.in);

        //pedimos la cantidad de numeros que tendra la fila
        System.out.println("Ingresa la cantidad de numeros; ");
        int can = scan.nextInt();

        //creamos un bucle desde 1 hasta la cantidad de numeros dada
        for (int i = 1; i <= can; i++) {
            //agregamos los numeros a la fila
            System.out.println("Agregando elemnto " + i + " a la fila");
            filaNumeros.offer(i);
        }

        //mostramos la cantidad de numeros 
        System.out.println("");
        System.out.println("Cantidad de elementos en la fila  " + filaNumeros.size());
        System.out.println("");

        //creamos un bucle se repetira mientras sea diferente de vacio
        while (!filaNumeros.isEmpty()) {
            //retiramos los numeros de la fila 
            //en este caso el primero en entrar sera el primero en salir
            System.out.println("Quitando elemento " + filaNumeros.poll() + " de la fila");
            Thread.sleep(1500);

        }

    }
}

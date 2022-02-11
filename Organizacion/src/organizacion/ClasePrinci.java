/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizacion;

import java.io.IOException;
import java.util.Scanner;

public class ClasePrinci {

    public static void main(String[] args) throws IOException {

        menuPrin();

    }

    public static void menuPrin() throws IOException {
        Scanner scan = new Scanner(System.in);
        String op = "";
        do {
            System.out.println("------------------------------------------");
            System.out.println("1.- Organizacion Secuencial");
            System.out.println("2.- Organizacion Secuencial indexada");
            System.out.println("3.- Organizacion Directa Random");
            System.out.println("0.- Salir");
            System.out.println("Ingresa una opcion");
            op = scan.nextLine();

            op = op.trim();

            if (op.equals("1")) {
                menuSecu();
            } else if (op.equals("2")) {
                menuSecuIndex();
            } else if (op.equals("3")) {
                menuRan();
            } else if (op.equals("0") == false) {
                System.out.println("Opcion incorrecta intenta de nuevo");
            }

            System.out.println("\n\n\n\n");
        } while (!"0".equals(op));
        System.out.println("------------------------------------------");

    }

    public static void menuSecu() throws IOException {
        OrgSecu secu = new OrgSecu();
        Scanner scan = new Scanner(System.in);
        String op = "";
        do {
            System.out.println("------------------------------------------");
            System.out.println("Organizacion secuencial\n");
            System.out.println("1.- Ingresar datos");
            System.out.println("2.- Observar datos en forma secuencial");
            System.out.println("3.- Abrir archivo");
            System.out.println("0.- Salir");
            System.out.println("Ingresa una opcion");
            op = scan.nextLine();

            //metodo trim quita espacios
            op = op.trim();

            System.out.println(op);
            if (op.equals("1")) {

                secu.guardarDatos();

            } else if (op.equals("2")) {

                System.out.println("\n-----------Observando datos del archivo");
                secu.obserDatos();

            } else if (op.equals("3")) {

                secu.abrirArchivo();
                System.out.println("Archivo arbierto");
            } else if (op.equals("0") == false) {

                System.out.println("Opcion incorrecta intenta de nuevo");

            }

        } while (!"0".equals(op));
        System.out.println("------------------------------------------");
    }

    public static void menuSecuIndex() throws IOException {
        OrgIndex secuIndex = new OrgIndex();
        Scanner scan = new Scanner(System.in);
        String op = "";
        do {
            System.out.println("------------------------------------------");
            System.out.println("Organizacion secuencial indexada\n");
            System.out.println("1.- Ingresar datos");
            System.out.println("2.- Observar datos en forma secuencial indexado");
            System.out.println("3.- Abrir archivo");
            System.out.println("4.- Buscar por indice");
            System.out.println("0.- Salir");
            System.out.println("Ingresa una opcion");
            op = scan.nextLine();

            //metodo trim quita espacios
            op = op.trim();

            System.out.println(op);

            //verificamos que opcion nos ingreso el usuario 
            //si puso opciones no disponibles mostramos un error
            if (op.equals("1")) {

                secuIndex.guardarDatos();

            } else if (op.equals("2")) {

                System.out.println("\n-----------Obsevando datos del archivo");
                secuIndex.obserDatos();

            } else if (op.equals("3")) {

                secuIndex.abrirArchivo();
                System.out.println("Archivo arbierto");

            } else if ("4".equals(op)) {

                secuIndex.BuscarPorId();

            } else if (op.equals("0") == false) {

                System.out.println("Opcion incorrecta intenta de nuevo");

            }

        } while (!"0".equals(op));
        System.out.println("------------------------------------------");
    }

    public static void menuRan() throws IOException {
        OrgAlea secuAle = new OrgAlea();
        Scanner scan = new Scanner(System.in);
        String op = "";
        do {
            System.out.println("------------------------------------------");
            System.out.println("Organizacion directa random\n");
            
            System.out.println("1.- Ingresar datos");
            System.out.println("2.- Observar datos");
            System.out.println("3.- Abrir archivo");
            System.out.println("4.- Observar datos de forma directa");
            System.out.println("0.- Salir");
            System.out.println("Ingresa una opcion");
            op = scan.nextLine();

            //metodo trim quita espacios
            op = op.trim();

            System.out.println(op);

            //verificamos que opcion nos ingreso el usuario 
            //si puso opciones no disponibles mostramos un error
            if (op.equals("1")) {

                secuAle.guardarDatos();

            } else if (op.equals("2")) {

                System.out.println("\n-----------Obsevando datos del archivo");
                secuAle.obserDatos();

            } else if (op.equals("3")) {

                secuAle.abrirArchivo();
                System.out.println("Archivo arbierto");

            } else if ("4".equals(op)) {

                secuAle.obserDatosRandom();

            } else if (op.equals("0") == false) {

                System.out.println("Opcion incorrecta intenta de nuevo");

            }

        } while (!"0".equals(op));
        System.out.println("------------------------------------------");
    }

}


import java.awt.Desktop;
import java.util.*;
import java.io.*;

class Fifo1 {

    //programa que pide una ruta de directorio
    //almacena todos los archivos o carpetas dentro de una fila fifo
    //y por ultimo abre uno por uno en forma de fila el primero en entrar primero en salir 
    
    //funcion principal desde donde inicia el programa
    
    public static void main(String[] args) throws InterruptedException, IOException {
        new Fifo1().iniciarFilaArchi();
    }

    public void iniciarFilaArchi() throws IOException, InterruptedException {

        //creamos una fila de archivos
        Fila<File> archivosFila = new Fila<File>();
        //creamos un array de archivos
        File[] archivos;
        
        
        //igualamos el array de archivos al metodo de obtiene archivos
        //este metodo pide un ruta por consola y de acuerdo a esa ruta obtiene todos los archivos dentro de ese directorio
        archivos = obtieneArchivos();

        
        //agregamos los archivos dentro de la fila
        for (int i = 0; i < archivos.length; i++) {
            archivosFila.Encolar(archivos[i]);
        }

        
        
        //mostramos por consola los archivos dentro de la capeta
        System.out.println("\nArchivos dentro de la carpeta");
        for (File f : archivosFila) {
            System.out.println(f.getPath());
        }

        
        //abrimos los archivos de la fila uno por uno esperando segundo y medio
        System.out.println("\nAbriendo archivos");
    
        
        //bucle que se repetira hasta que la fila quede vacia 
        while(!archivosFila.Vacio()){
            //desencolamos 
            File f=archivosFila.desencolar();
            Thread.sleep(1500);
            abrirarchivo(f.getPath());
            
            
            if(f.isDirectory()){
                System.out.print("Carpeta ");
            }else{
                System.out.print("Archivo ");
            }
            System.out.println(f.getName() + " abierto");
        }
   

    }

    public File[] obtieneArchivos() {
        String ruta = "";
        Scanner scan = new Scanner(System.in);
        File[] archivos;
        File direc;

        do {

            System.out.println("Ingrese una ruta: ");
            ruta = scan.nextLine();
            
            direc = new File(ruta);

        } while (!direc.exists() || !direc.isDirectory());

        archivos = direc.listFiles();
        return archivos;
    }

    public void abrirarchivo(String archivo) {

        try {

            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {

            System.out.println(ex);

        }

    }

    
}

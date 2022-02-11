import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.*;
import java.io.*;
 
public class FIFO {
    public static void main(String args[]) {
         
         //crea una fila de strings 
        Queue<String> fifo = new LinkedList<String>();
        int procesos=0;
        int conta;
        Scanner sc = new Scanner(System.in);
        
        
        //pedimos la cantidad de procesos a realizar
        System.out.print("Ingrese el numero los procesos a iniciar: ");
        procesos = sc.nextInt();
        conta=0;
        
        
        for(int i=1;i<=procesos;i++)
        {
           conta++;
           System.out.println("Creando nuevo proceso en..."+" ms"+" Numero: P_"+conta);
           
           
           //agregamos la cantidad de procesos 
           fifo.offer("P_"+Integer.toString(i));
        }   
         
        System.out.println("Numero procesos: " + fifo.size()+" Activos");
        conta=0;
        Object data;
        
        //realizamos los procesos
        //los primeros en entrar seran los primeros en realizarse
        while ((data = fifo.poll()) != null) {
            conta++;
                       try {
                 Thread.sleep(1500);
                } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
                }
 
            System.out.println("Proceso terminado "+data);
            }
        System.out.println("Numero procesos: " + fifo.size()+" Activos");
         
 
    }
}
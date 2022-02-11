/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizacion;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class OrgAlea {
    
    //clase que trabaja con archivos de forma aleatorio
    //con ello indicamos desde que posicion del archivo empezar a leer
    
    //ruta en donde se encuentre un arhcivo de texto
    private String ruta;
    public OrgAlea(){
        this.ruta="textopersonaAle.txt";
    }
    public OrgAlea(String ruta){
        this.ruta=ruta;
    }
    
    
    //meotodo para abrir el archivo 
    public void abrirArchivo() throws IOException{
        Desktop.getDesktop().open(new File(this.ruta));
    }
    //metodo para pedir datos al usuario por consola 
    private Persona pedirDatos(){
        Persona per= new Persona();
        Scanner scan = new Scanner(System.in);

        String dato;
        do{
            System.out.println("Ingresa un id: ");
            dato=scan.nextLine();
        }while(dato.trim()=="");
        
        per.setId(Integer.parseInt(dato));
        
        do{
            System.out.println("Ingresa tu nombre: ");
            dato=scan.nextLine();
        }while(dato.trim()=="");

        per.setNombre(dato);
        
        
        
        return per;
    }
    
    //metodo para guardar los datos en el archivo
    public void guardarDatos() throws IOException{
        Persona datos=pedirDatos();
        File f= new File(ruta);
        
        
        FileWriter wri= new FileWriter(f,true);
        wri.write(datos.getId()+",");
        wri.write(datos.getNombre());
        wri.write("\n");
        wri.close();
    }
    
    //metodo para observar los datos en consola en forma secuencial es decir uno por uno
    public void obserDatos() throws FileNotFoundException, IOException{
        
        
        File a = new File(this.ruta);
        if(!a.exists())return;
        
        
        
        FileReader re = new FileReader(this.ruta);
        
        BufferedReader le = new BufferedReader(re);
        
        
        StringBuilder buil = new StringBuilder();
        String aux;
        while((aux=le.readLine()) !=null ){
            
            aux.replace(',',' ');
            buil.append(aux).append("\n");
        }
        le.close();
        re.close();
        
        
        System.out.println(buil.toString());
    }
    
    public void obserDatosRandom() throws FileNotFoundException, IOException{
        File file= new File(ruta);
        RandomAccessFile ran= new RandomAccessFile(file,"r");
        Scanner scan = new Scanner(System.in);
        long dire=0;
        
        System.out.println("Ingresa la posicion desde donde leer: ");
        dire=scan.nextLong();
        ran.seek(dire);
        
        String lectura=ran.readLine();
        
        System.out.println("--------------------------------");
        System.out.println("Leyendo desde la poscion "+dire);
        System.out.println(lectura);
        
        
        ran.close();
        
        
        
    }
}
    

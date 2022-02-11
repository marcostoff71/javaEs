/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizacion;

import java.awt.Desktop;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author MARCO
 */
public class OrgSecu {
    
    //clase que trabaja con archivos de forma secuencial
    //para leer todos debemos pasar una por uno hasta el final
    
    //ruta en donde se encuentre un arhcivo de texto
    private String ruta;
    public OrgSecu(){
        this.ruta="textopersona.txt";
    }
    public OrgSecu(String ruta){
        this.ruta=ruta;
    }
    
    
    //meotodo para abrir el archivo 
    public void abrirArchivo() throws IOException{
        Desktop.getDesktop().open(new File(this.ruta));
    }
    //metodo para pedir datos al usuario por consola 
    private String pedirDatos(){
        
        Scanner scan = new Scanner(System.in);

        String dato;
        
        do{
            System.out.println("Ingresa tu nombre: ");
            dato=scan.nextLine();
        }while(dato.trim()=="");

        return dato;
    }
    
    //metodo para guardar los datos en el archivo
    public void guardarDatos() throws IOException{
        String datos=pedirDatos();
        File f= new File(ruta);
        
        
        FileWriter wri= new FileWriter(f,true);
        wri.write(datos);
        wri.write("\n");
        wri.close();
    }
    
    //metodo para observar los datos en consola en forma secuencial es decir uno por uno
    public void obserDatos() throws FileNotFoundException, IOException{
        FileReader re = new FileReader(this.ruta);
        
        BufferedReader le = new BufferedReader(re);
        
        
        StringBuilder buil = new StringBuilder();
        String aux;
        while((aux=le.readLine()) !=null ){
            
            
            buil.append(aux).append("\n");
        }
        
        
        le.close();
        re.close();
        System.out.println(buil.toString());
    }
}



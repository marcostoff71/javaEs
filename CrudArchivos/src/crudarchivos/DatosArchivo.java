
package crudarchivos;

import java.util.*;
import java.io.*;
public class DatosArchivo {
    
    private String ruta;
    
    public DatosArchivo(){
        
    }
    public DatosArchivo(String ruta){
        this.ruta=ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
   public ArrayList<Persona> Obtener() throws IOException{
       ArrayList<Persona> arr= new ArrayList<>();
       
       File f= new File(ruta);
       
       if(!f.exists())return arr;
       
       
       
       FileReader fr= new FileReader(ruta);
       BufferedReader br = new BufferedReader(fr);
       
       Persona per;
       String auxLe;
       StringTokenizer stok;
       
       
       
       while((auxLe=br.readLine())!=null){
           stok= new StringTokenizer(auxLe,",");
           
           per= new Persona();
           
           per.setId(Integer.parseInt(stok.nextToken()));
           per.setNombre(stok.nextToken());
           per.setApePaterno(stok.nextToken());
           per.setApeMaterno(stok.nextToken());
           
           arr.add(per);
       }
       
       
       
       
       
       
       
       
       return arr;
       
   }
   public void Actualizar(ArrayList<Persona> arr) throws IOException{
       File f = new File(ruta);
       
       if(!f.exists()){
           f.createNewFile();
       }
       
        try (FileWriter fw = new FileWriter(f)) {
            for(Persona per : arr){
                fw.write(per.getId());
                fw.write(",");
                fw.write(per.getNombre());
                fw.write(",");
                fw.write(per.getApePaterno());
                fw.write(",");
                fw.write(per.getApeMaterno());
                fw.write("\n");
                
            }}
       
       
   }
}

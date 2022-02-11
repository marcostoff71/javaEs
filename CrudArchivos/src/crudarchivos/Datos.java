/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudarchivos;

import java.util.*;
public class Datos {
    private ArrayList<Persona> arrPersona ;
    
    
    public Datos(){
        this.arrPersona= new ArrayList<>();
    }
    public Datos(ArrayList<Persona> arr){
        this.arrPersona=arr;
    }
    
    
    public ArrayList<Persona> getArrPersona(){
        return this.arrPersona;
    }
    public void addPersona(Persona pPer){
        arrPersona.add(pPer);
    }
    public void modificarPer(Persona pPer){
        int idBus=buscarId(pPer.getId());
        
        
        this.arrPersona.set(idBus, pPer);
    }
    public boolean existePersona(int id){
        
        boolean existe=false;
        
        for (int i = 0; i < arrPersona.size(); i++) {
            
            if (arrPersona.get(i).getId()==id) {
                existe=true;
                break;
            }
            
        }
        
        
        return existe;
        
        
    }
    public boolean eliminarPer(int id){
        
        boolean corre=false;
        if(existePersona(id)){
            int idBorrar=buscarId(id);
            
            if(idBorrar>=0){
                arrPersona.remove(id);
            }
            
            
        }
        return corre;
    }
    
    public int buscarId(int id){
        int aux = -1;
        for (int i = 0; i < arrPersona.size(); i++) {
            
            if(arrPersona.get(i).getId()==id){
                aux=i;
            }
            
        }
        
        
        return aux;
    }
}

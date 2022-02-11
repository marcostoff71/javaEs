
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MARCO
 */
public class Fila<T>implements java.lang.Iterable<T>{

    public FilaIterador<T> ite;
    @Override
    public Iterator<T> iterator() {
        ite=new FilaIterador<>(this);
        return ite;
    }

    @Override
    public void forEach(Consumer<? super T> cnsmr) {
        Iterable.super.forEach(cnsmr); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Nodo{
        public T item;
        public Nodo sig;
    }
    public T getItem(int index){
        return obtenerPorIndice(index).item;
    }
    public void setItem(int index,T item){
        Nodo aux=obtenerPorIndice(index);
        aux.item=item;
    }
    private Nodo obtenerPorIndice(int index){
       
        if (index<0||index>=count()) {
            throw new IndexOutOfBoundsException("Indice fuera de los limtes");
        }
        
        Nodo aux=ini;
        
        for(int i=0;i<index;i++)aux=aux.sig;
        
       
        return aux;
        
    }
    
    private Nodo ini;
    private Nodo fin;
    
    
    public boolean eliminar(T item){
        boolean corre=false;
        
        
        if (!Vacio()) {
            
            Nodo aux=ini;
            Nodo ant=null;
            
            
            while(aux!=null&&!aux.item.equals(item)){
                ant=aux;
                aux=aux.sig;
            }
            
            
            if(aux==null){
                
            }else if(ant==null){
                corre=true;
                ini=ini.sig;
            }else{
                corre=true;
                ant.sig=aux.sig;
            }
            
            if(ini==null){
                fin=null;
            }
            
        }
        
        
        
        return corre;
        
    }
    public int count(){
        int con=0;
        
        for(Nodo aux=ini;aux!=null;aux=aux.sig)con++;
        
        return con;
    }
    public Fila(){
        ini=null;
        fin=null;
    }
    public void Encolar(T item){
        Nodo nuevo= new Nodo();
        nuevo.item=item;
        nuevo.sig=null;
        
        
        if(ini==null){
            ini=nuevo;
        }else{
            fin.sig=nuevo;
        }
        fin=nuevo;
    }
    
    public boolean Vacio(){
    
        return ini==null;
    }
    public T desencolar(){
        
        T item;
        if(Vacio()){
            throw new NullPointerException("fila vacia");
        }
        item=ini.item;
        if(ini==fin){
            ini=null;
            fin=null;
        }else{
            ini=ini.sig;
        }
        
        return item;
    }
    
}

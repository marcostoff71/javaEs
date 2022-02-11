
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MARCO
 */
public class FilaIterador<T> implements Iterator{

    int con=-1;
    Fila<T> fila;
    
    public FilaIterador(Fila<T> fila){
        this.fila=fila;
    }
    @Override
    public boolean hasNext() {
        con++;
        
        return con<fila.count();
    }

    @Override
    public Object next() {
        return fila.getItem(con);
    }
    
}

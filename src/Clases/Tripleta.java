/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
 
/**
 *
 * @author JUAN
 */
public class Tripleta {
    private int fila,columna;
    private Object valor,f,c,v;
   

    
    Tripleta(int f, int c, Object v){  // constructor de la clase y las variables que inicializa
        fila = f;
        columna = c;
        valor = v;
    }
    
    // metodos de la clase tripleta
    public void asignaFila(int f){ 
        fila = f;
    }
    
    public void asignaColumna(int c){
        columna = c;
    }
    
    public void asignaValor(Object v){
        valor = v;
    }
    
    public int retornaFila(){
        return fila;
    }
    
    public int retornaColumna(){
        return columna;
    }
    
    public Object retornaValor(){
        return valor;
    }
    
    
}

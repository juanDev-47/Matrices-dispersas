/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author JUAN
 */
public class MatrizEnTripletas {
    private Tripleta v[];
    private int m,n;
    
    
    MatrizEnTripletas(Tripleta t){
        m = t.retornaFila();
        n = t.retornaColumna();
        int p = m*n+1;
        int j;
        v = new Tripleta[p];  
        v[0] = t;
        for (j = 1; j < p; j++) {
            v[j] = null;
        }
    }
    
    public void asignaTripleta(Tripleta tx, int i){
        v[i] = tx;
    }
    
    public void asignaNumeroTripletas(int b){
        Tripleta t = v[0];
        t.asignaValor(b);
        v[0] = t;
    }
    
    public int retornaFilas(){
        Tripleta t = v[0];
        
        return t.retornaFila();
    }
    
    public int retornaColumnas(){
        Tripleta t = v[0];
        
        return t.retornaColumna();
    }
    
    public int retornaValor(){
        Tripleta t = v[0];
        
        return (int)t.retornaValor();
    }
    
    public int retornaNumeroTripletas(){
        Tripleta t = v[0];
        
        return (int)t.retornaValor();
    }
    
    public Tripleta retornaTripleta(int i){
        return v[i];
    }
    
    public void muestraMatrizEnTripletas(){
        int i = 1;
        Tripleta t = v[0];
        int datos = (int)t.retornaValor();
        while(i <= datos){
            if(i == 1){
                System.out.println(v[0].retornaFila() + ", " + v[0].retornaColumna() + ", " + (int)v[0].retornaValor());
            }
            System.out.println(v[i].retornaFila() + ", " + v[i].retornaColumna() + ", " + (int)v[i].retornaValor());
            i++;
        }
    }
    
    public void insertaTripleta(Tripleta t){
        int f = t.retornaFila();
        int c = t.retornaColumna();
        int i = 1;
        int p = (int)v[0].retornaValor();
        while (i <= p && v[i].retornaFila() < f){
            i++;
        }
        while(i <= p && f == v[i].retornaFila() && v[i].retornaColumna() < c){
            i++;
        }
        int j = p;
        while(j >= i){
            v[j+1] = v[j];
            j--;
        }
        v[i] = t;
        p++;
        v[0].asignaValor(p);
    }
    
    public void muestraMatriz(MatrizEnTripletas M){
        int h = 1;
        int j,i;
        int p = (int)v[0].retornaValor();
        boolean w = true;
        
        for (i = 1; i <= m; i++) {            
            for (j = 1; j <= n; j++) {                
                
                w = true;
                                    
                if(h <= p && i == v[h].retornaFila() && j == v[h].retornaColumna()){                    
                    System.out.print(" "+ (int)v[h].retornaValor() + " ");                            
                    w = false;
                    h++;
                } 
                if (w == true) {
                    System.out.print(" 0 ");                        
                }                    
                    
                if(j == n){
                    System.out.println("");
                }                
                                                                       
            }
        }
    }
    
    public MatrizEnTripletas traspuesta(){
        int m = v[0].retornaFila();
        int n = v[0].retornaColumna();
        int p = (int)v[0].retornaValor();
        int i = 1;
        int f,c,w;
        Tripleta t = new Tripleta(m,n,0);
        MatrizEnTripletas at = new MatrizEnTripletas(t);
        while(i <= p){
            t = retornaTripleta(i);
            f = t.retornaColumna();
            c = t.retornaFila();
            w = (int)t.retornaValor();
            t = new Tripleta(f,c,w);
            at.insertaTripleta(t);
            i++;
        }
        
        return at;
    }
    
    
    
    
}

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
public class MatrizEnForma2 {
    NodoDoble mat;
    
    MatrizEnForma2(int m, int n){
        Tripleta t = new Tripleta(m,n,null);
        mat = new NodoDoble(t);
        Tripleta tx = new Tripleta(0,0,null);
        NodoDoble x = new NodoDoble(tx);
        x.asignaLd(x);
        x.asignaLi(x);
        mat.asignaLd(x);
        
    }
    
    public NodoDoble primerNodo(){
        return mat;
    }
    
    public NodoDoble nodoCabeza(){
        return mat.retornaLd();
    }
    
    public boolean esVacia(){
        NodoDoble p = mat.retornaLd();
        return (p.retornaLi() == p && p.retornaLd() == p);
    }
    
    public boolean finDeRecorrido(NodoDoble p){
        return p == nodoCabeza();
    }
    
    public void conectaPorFila(NodoDoble x){
        NodoDoble p,q,anterior;
        Tripleta tq,tx;
        int i;
        tx = (Tripleta)x.retornaDato();
        p = nodoCabeza();
        anterior = p;
        q = p.retornaLd();
        tq = (Tripleta)q.retornaDato();
        while(q != p && tq.retornaFila() < tx.retornaFila()){
            anterior = q;
            q = q.retornaLd();
            tq = (Tripleta)q.retornaDato();            
        }
        while(q != p && tq.retornaFila() == tx.retornaFila() && tq.retornaColumna() < tx.retornaColumna() ){
            anterior = q;
            q = q.retornaLd();
            tq = (Tripleta)q.retornaDato();
        }
        anterior.asignaLd(x);
        x.asignaLd(q);
        
    }
    
    public void conectaPorColumna(NodoDoble x){
        NodoDoble p,q,anterior;
        Tripleta tq,tx;
        int i;
        tx = (Tripleta)x.retornaDato();
        p = nodoCabeza();
        anterior = p;
        q = p.retornaLi();
        tq = (Tripleta)q.retornaDato();
        while(q != p && tq.retornaColumna() < tx.retornaColumna()){
            anterior = q;
            q = q.retornaLi();
            tq = (Tripleta)q.retornaDato();            
        }
        while(q != p && tq.retornaColumna() == tx.retornaColumna() && tq.retornaFila() < tx.retornaFila() ){
            anterior = q;
            q = q.retornaLi();
            tq = (Tripleta)q.retornaDato();
        }
        anterior.asignaLi(x);
        x.asignaLi(q);
        
    }
    
    public void muestraMatriz(){
        int qf,qc,qv;
        NodoDoble q;
        Tripleta tq;
        q = nodoCabeza().retornaLd();
        while(!finDeRecorrido(q)){
            tq = (Tripleta)q.retornaDato();
            qf = tq.retornaFila();
            qc = tq.retornaColumna();
            qv = (int)tq.retornaValor();
            System.out.println(qf+","+qc+","+qv);
            q = q.retornaLd();
        }
    }
    
    public void muestraMatrizForma2(){
        int m,n;
        NodoDoble q;
        Tripleta tq,mat;
        q = nodoCabeza().retornaLd();  // primer nodo que representa posicion en la lista ejemplo (1,1)
        mat = (Tripleta)primerNodo().retornaDato(); // tripleta que tiene el nodo mat para estraer el tamaño de filas y columnas
        m = mat.retornaFila();
        n = mat.retornaColumna();
        int h = 1;
        int j,i;
        tq = (Tripleta)q.retornaDato(); // Tripleta asociada al primer nodo de la lista
        boolean w;        
        for (i = 1; i <= m; i++) {            
            for (j = 1; j <= n; j++) {                 
                w = true;                                    
                if(q != nodoCabeza() && i == tq.retornaFila() && j == tq.retornaColumna()){                    
                    System.out.print(" "+ (int)tq.retornaValor() + " ");                            
                    w = false;
                    q = q.retornaLd();
                    tq = (Tripleta)q.retornaDato();
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
    
    public void eliminarDato(int f,int c){
        int m,n;
        NodoDoble q,p,aux;
        Tripleta tq,mat1;
        q = nodoCabeza().retornaLd();  
        tq = (Tripleta)q.retornaDato();
        mat1 = (Tripleta)primerNodo().retornaDato(); 
        m = mat1.retornaFila();
        n = mat1.retornaColumna();
        
        if (f > m || c > n) {
            JOptionPane.showMessageDialog(null, "la posicion del dato no corresponde a ninguno en la matriz");
            return;
        }
        while(!finDeRecorrido(q)){
            
            aux = q.retornaLd();
            if (f == tq.retornaFila() && c == tq.retornaColumna()) {
                p = anterior(q);
                p.asignaLd(aux);
                q.asignaLd(q);
                q.asignaLi(q);
                return;
            }
            q = q.retornaLd();
            tq = (Tripleta)q.retornaDato();
        }

        JOptionPane.showMessageDialog(null, "el dato no existe en la matriz");
        
    }
    
    public NodoDoble anterior(NodoDoble x){
        NodoDoble p,y;
        p = nodoCabeza().retornaLd();
        y = nodoCabeza();
        while(p != x){
            y = p;
            p = p.retornaLd();
        }
        
        return y;
    }
    
    public MatrizEnForma2 tarea4(MatrizEnForma1 Mf1, MatrizEnTripletas M){  // tarea 4  se debe ingresar almenos dos matrices        
        Tripleta t;
        t = (Tripleta)Mf1.nodoCabeza().retornaDato();
        MatrizEnForma2 Mf2aux = new MatrizEnForma2(t.retornaFila(),t.retornaColumna());        
        int m,n,t1,v;
        t1 = (int)M.retornaValor();
        NodoDoble q,p;
        Tripleta tq;
        p = Mf1.primerNodo();
        q = p.retornaLd();
        int i;
        tq = (Tripleta)q.retornaDato(); 
       
        for (i = 1; i <= t1; i++) {
            Tripleta k = M.retornaTripleta(i);
            m = k.retornaFila();
            n = k.retornaColumna();
            v = (int)k.retornaValor();
            
                if(q != p && m == tq.retornaFila() && tq.retornaColumna() == n ){  
                    Tripleta ta = new Tripleta(m,n,(int)tq.retornaValor() + v );
                    NodoDoble x = new NodoDoble(ta);
                    Mf2aux.conectaPorColumna(x);
                    Mf2aux.conectaPorFila(x);
                    q = q.retornaLd();  
                    tq = (Tripleta)q.retornaDato();                        
                }else if (q == p) {
                    Tripleta aux = (Tripleta)p.retornaDato();
                    p = (NodoDoble)aux.retornaValor();
                    q = p.retornaLd();
                }

            
                            
        }    
        
        
        
        return Mf2aux;
    }
    
    public void mostrarPosiciones(){
        int c,f,v;
        Tripleta t;
        NodoDoble q = nodoCabeza().retornaLd();
        
        while(!finDeRecorrido(q)){
            t = (Tripleta)q.retornaDato();
            System.out.print("(" + t.retornaFila() + "," + t.retornaColumna() + ")  ");
            q = q.retornaLd();
        }
        

            
        
    }
    
    
    
}

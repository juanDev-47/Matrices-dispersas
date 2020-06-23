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
public class MatrizEnForma1 {
    private NodoDoble mat;
    
    MatrizEnForma1(int m, int n){
        Tripleta t = new Tripleta(m,n,null);
        mat = new NodoDoble(t);
        t.asignaValor(mat);
        mat.asignaDato(t);
    }
    
    public NodoDoble nodoCabeza(){
        return mat;
    }
    
    public NodoDoble primerNodo(){
        Tripleta tp = (Tripleta)mat.retornaDato();
        NodoDoble p = (NodoDoble)tp.retornaValor();
        
        return p;
    }
    
    public boolean esVacia(){
        NodoDoble p = primerNodo();
        return p == mat;
    }
    
    public boolean finDeRecorrido(NodoDoble p){
        return p == mat;
    }
    
    public int mayor(int m, int n){
        int mayor;
        if (m >= n) {
            mayor = m;
        }else{
            mayor = n;
        }
        
        return mayor;
    }
        
    
    public void construyeNodosCabeza(){
        int mayor,i;
        NodoDoble x,ultimo;
        Tripleta t;
        ultimo = nodoCabeza();
        t = (Tripleta)ultimo.retornaDato();
        int m = t.retornaFila();
        int n = t.retornaColumna();        
        mayor = mayor(m,n);
        for (i = 1; i <= mayor; i++) {
            t = new Tripleta(i,i,nodoCabeza());
            x = new NodoDoble(t);
            x.asignaLd(x);
            x.asignaLi(x);
            t = (Tripleta)ultimo.retornaDato();
            t.asignaValor(x);
            ultimo.asignaDato(t);
            ultimo = x;
        }
    }
    
    public void conectaPorFilas(NodoDoble x){
        NodoDoble p,q,anterior;
        Tripleta tp,tq,tx;
        int i;
        tx = (Tripleta)x.retornaDato();
        p = primerNodo();
        for (i = 1; i < tx.retornaFila(); i++) {
            tp = (Tripleta)p.retornaDato();
            p = (NodoDoble)tp.retornaValor();
        }
        anterior = p;
        q = p.retornaLd();
        tq = (Tripleta)q.retornaDato();
        while( (q != p) && (tq.retornaColumna() < tx.retornaColumna()) ){
            anterior = q;
            q = q.retornaLd();
            tq = (Tripleta)q.retornaDato();
        }
        anterior.asignaLd(x);
        x.asignaLd(q);
    }
    
    public void conectaPorColumnas(NodoDoble x){
        NodoDoble p,q,anterior;
        Tripleta tp,tq,tx;
        int i;
        tx = (Tripleta)x.retornaDato();
        p = primerNodo();
        for (i = 1; i < tx.retornaColumna(); i++) {
            tp = (Tripleta)p.retornaDato();
            p = (NodoDoble)tp.retornaValor();
        }
        anterior = p;
        q = p.retornaLi();
        tq = (Tripleta)q.retornaDato();
        while( (q != p) && (tq.retornaFila() < tx.retornaFila()) ){
            anterior = q;
            q = q.retornaLi();
            tq = (Tripleta)q.retornaDato();
        }
        anterior.asignaLi(x);
        x.asignaLi(q);
    }
    
    public void muestraMatriz(){
        int qf,qc,qv;
        NodoDoble p,q;
        Tripleta tq,tp;
        p = primerNodo();
        while(!finDeRecorrido(p)){
            q = p.retornaLd();
            while(q != p){
                tq = (Tripleta)q.retornaDato();
                qf = tq.retornaFila();
                qc = tq.retornaColumna();
                qv = (int)tq.retornaValor();
                System.out.println(qf+","+qc+","+qv);
                q = q.retornaLd();                
            }
            tp = (Tripleta)p.retornaDato();
            p = (NodoDoble)tp.retornaValor();
        }
    }
    
    public MatrizEnForma2 forma1AForma2(MatrizEnForma1 Mf1){  // tarea 3  se debe ingresar almenos un dato
        Tripleta t;
        t = (Tripleta)Mf1.nodoCabeza().retornaDato();
        MatrizEnForma2 Mf2aux = new MatrizEnForma2(t.retornaFila(),t.retornaColumna());        
        int m,n;
        NodoDoble q,p;
        Tripleta tq,mat1,taux;
        p = primerNodo();
        q = p.retornaLd();  // primer nodo cabeza de las listas
        mat1 = (Tripleta)nodoCabeza().retornaDato(); // tripleta que tiene el nodo mat para estraer el tamaño de filas y columnas
        m = mat1.retornaFila();
        n = mat1.retornaColumna();
        int j,i;
        tq = (Tripleta)q.retornaDato(); // Tripleta asociada al primer nodo de la lista
       
        for (i = 1; i <= m; i++) {            
            for (j = 1; j <= n; j++) {                 
                                    
                if(q != p && i == tq.retornaFila() && j == tq.retornaColumna()){  
                    Tripleta ta = new Tripleta(tq.retornaFila(),tq.retornaColumna(),(int)tq.retornaValor());
                    NodoDoble x = new NodoDoble(ta);
                    Mf2aux.conectaPorColumna(x);
                    Mf2aux.conectaPorFila(x);
                    q = q.retornaLd();  
                    tq = (Tripleta)q.retornaDato();                    
                }else if(q == p && p != nodoCabeza()){
                    
                    taux = (Tripleta)p.retornaDato();
                    p = (NodoDoble)taux.retornaValor();                    
                        if (p.retornaLd() == p) {
                            taux = (Tripleta)p.retornaDato();
                            p = (NodoDoble)taux.retornaValor();
                        }
                        
                    q = p.retornaLd();
                                       
                }
                
            }
            
        }    
        
        
        
        return Mf2aux;
    }
    
public void muestraMatrizForma1(){
        int m,n;
        NodoDoble q,p;
        Tripleta tq,mat1,taux;
        p = primerNodo();
        q = p.retornaLd();  // primer nodo cabeza de las listas
        mat1 = (Tripleta)nodoCabeza().retornaDato(); // tripleta que tiene el nodo mat para estraer el tamaño de filas y columnas
        m = mat1.retornaFila();
        n = mat1.retornaColumna();
        int j,i;
        tq = (Tripleta)q.retornaDato(); // Tripleta asociada al primer nodo de la lista
        boolean w;        
        for (i = 1; i <= m; i++) {            
            for (j = 1; j <= n; j++) {  
                
                w = true;                         
                        
                        if(q != p && i == tq.retornaFila() && j == tq.retornaColumna()){                    
                            System.out.print(" "+ (int)tq.retornaValor() + " ");                            
                            w = false;
                            q = q.retornaLd();
                            if (q != p) {
                                tq = (Tripleta)q.retornaDato();
                            }

                        }else if(q == p && p != nodoCabeza()){

                            taux = (Tripleta)p.retornaDato();
                            p = (NodoDoble)taux.retornaValor(); 
                            q = p.retornaLd();
//                            if (q != p) {
//                                tq = (Tripleta)q.retornaDato();
//                            }
                              
                        }
    
                
                  // hasta aqui el if grande
                
                if (w == true) {
                    System.out.print(" 0 ");                        
                }                    
                if(j == n){
                    System.out.println("");
                }
                
                
            } // for interno
        } // for externo
    }

    public void mostrarPosiciones(){
        Tripleta t = (Tripleta)nodoCabeza().retornaDato();
        
//        
//        for (int k = 1; k <= (int)v[0].retornaValor(); k++) {
//            System.out.print("(" + v[k].retornaFila() + "," + v[k].retornaColumna() + ")  ");
//        }
    }
    
}

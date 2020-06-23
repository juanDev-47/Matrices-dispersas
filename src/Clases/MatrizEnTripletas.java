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
    
    public void mostrarPosiciones(){
        for (int k = 1; k <= (int)v[0].retornaValor(); k++) {
            System.out.print("(" + v[k].retornaFila() + "," + v[k].retornaColumna() + ")  ");
        }
    }
    
    public void muestraMatriz(MatrizEnTripletas M){
        int h = 1;
        int j,i;
        int p = (int)v[0].retornaValor();
        boolean w;        
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
    
    public int mayor(int m, int n){
        int mayor;
        if (m >= n) {
            mayor = m;
        }else{
            mayor = n;
        }
        
        return mayor;
    }
    
    public void sumaTridiagonalP(MatrizEnTripletas M){
        if ( m == n) {
        
            int h = 1;
            int j,i,mayor;
            int suma = 0;
            int p = (int)v[0].retornaValor();
            mayor = mayor(m, n);
            if ((mayor + 2*(mayor - 1)) >= (int)v[0].retornaValor()) {                      

            for (i = 1; i <= p; i++) {

                if(h <= p && (int)v[h].retornaValor() != 0){  

                    if(v[h].retornaFila() == v[h].retornaColumna() && v[h].retornaColumna() == 1 ){  // cuando la posicion es 1,1
                                if (M.existe(h, h+1) == true) {
                                    suma = suma + (int)v[h].retornaValor() + (int)v[h+1].retornaValor();

                                }
                                
                            }else if(v[h].retornaFila() == v[h].retornaColumna() && (v[h].retornaFila() == mayor)){

                                if (M.existe(mayor,mayor-1) == true) {
                                    suma = suma + (int)v[h].retornaValor() + (int)v[h-1].retornaValor();

                                }else{
                                    JOptionPane.showMessageDialog(null, "faltan datos en la tridiagonal principal");
                                    return;
                                }
                                
                            }else if(( v[h].retornaFila() == v[h].retornaColumna() ) && (v[h].retornaFila() != 1) && M.existe(v[h].retornaFila(), v[h].retornaColumna()+1 ) ){


                                    suma = suma + (int)v[h].retornaValor() + (int)v[h-1].retornaValor() + (int)v[h+1].retornaValor();
                                
                            } 

                            

                }else if ((int)v[h].retornaValor() == 0) {
                        System.out.println("Las entradas de la tridiagonal deben ser diferentes de 0");
                        return;
                        } 
                
                h++;
            }
            }else{
                        System.out.println("No se puede calcular la tridiagonal principal faltan datos en ella\nó hay datos diferentes de cero"
                                + " por debajo o por encima de la tridiagonal principal");
                        return;
            }
            System.out.println("Total: " + suma);
        }else{
            JOptionPane.showMessageDialog(null, "La matriz no es cuadrada por lo cual no se puede calcular\nla suma de la tridiagonal principal");
        }    
    }
    
    public boolean existe(int f, int c){
        boolean x = false;
        int p = (int)v[0].retornaValor();
        int i;
        
        for (i = 1; i <= p; i++) {
            if (v[i].retornaFila() == f  &&  v[i].retornaColumna() == c) {
                return true;
            }
        }
        
        
        return x;
    }
    
    public void eliminarDato(int f,int c){
        int f1 = v[0].retornaFila();
        int p = (int)v[0].retornaValor();
        if (f > f1 || c > v[0].retornaColumna()) {
            JOptionPane.showMessageDialog(null, "la posicion del dato no corresponde a ninguno en la matriz");
            return;
        }

        for (int i = 1; i <= p; i++) {
            if (f == v[i].retornaFila() && c == v[i].retornaColumna()) {
                while(i < p){
                    v[i] = v[i+1];
                    i++;
                }
                v[0].asignaValor((int)v[0].retornaValor() - 1);
                return;
            }
        }
        
        
    }
    
    
    
    
}

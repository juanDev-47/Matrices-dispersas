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
//        Tripleta t = new Tripleta(4,5,8);
//        
//        MatrizEnTripletas m = new MatrizEnTripletas(t);
//        int p = m.retornaColumnas();
//        System.out.println(p);
//        System.out.println(t.retornaFila() + ", " + t.retornaColumna() + ", " + (int)t.retornaValor());
public class Main {
    public static void main(String[] args) {
        boolean salir = false;        
        int j = 0;
        int opcion; //Guardaremos la opcion del usuario
        JOptionPane.showMessageDialog(null,"Vamos a construir una matriz dispersa\ningresando los valores de fila,columna,valor\n"
               + "Lo que quiere decir que usted indicara su posicion exacta\nEn la matriz");

        
      
           do{
               try{
           opcion =  Integer.parseInt(JOptionPane.showInputDialog("        Escribe una de las opciones\n\n"
                                                                + "1. Ingresar el tamaño de la matriz.\n"
                                                                + "2. Salir"
                                                                
                                                                 ));
            

        switch(opcion){
               case 1:
               try{
                   int f = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de filas a crear"));
                   int c = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Columnas a crear"));
                   Tripleta t = new Tripleta(f,c,0);
                   MatrizEnTripletas M = new MatrizEnTripletas(t);
                   int jj = M.retornaValor(); // prueba
                   System.out.println(jj); // prueba
                   //proceso de insercion de tripletas en la matriz dispersa
                   int opcion2; 
                   boolean a = true;
                   do{
                       opcion2 =  Integer.parseInt(JOptionPane.showInputDialog("        Escribe una de las opciones \ny recuerde la matriz es de tamaño: " + f + "*" + c 
                                                                + "\n\n1. Ingresar una tripleta.\n"
                                                                + "2.Mostrar resultados\n"
                                                                + "3. No ingresar mas"
                                                                 ));
                       switch(opcion2){
                           case 1:
                               int f1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la fila"));
                               if(f1 > f){
                                   JOptionPane.showMessageDialog(null, "La posicion del dato en la fila no puede ser mayor\nal del tamaño de las filas de la matriz\n"
                                           + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                   break;
                               }
                               int c1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la columna"));
                               if(c1 > c){
                                   JOptionPane.showMessageDialog(null, "La posicion del dato en la columna no puede ser mayor\nal del tamaño de las columnas de la matriz\n"
                                           + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                   break;
                               }
                               int v = Integer.parseInt(JOptionPane.showInputDialog("Valor a ingresar en la matriz"));
                               t = new Tripleta(f1,c1,v);
                               M.insertaTripleta(t);
                               
                               
                                                              
                               break;
                               
                           case 2:
                               System.out.println("Matriz representada por tripletas");
                               M.muestraMatrizEnTripletas();
                               System.out.println("");                               
                               System.out.println("Matriz en tripletas representada como matriz");
                               M.muestraMatriz(M);
                               System.out.println("");
                               System.out.println("");
                               System.out.println("Matriz traspuesta");
                               MatrizEnTripletas at = M.traspuesta();
                               at.muestraMatriz(at);
                               System.out.println("");
                               break;
                               
                           case 3:
                               a = false;
                               break;    
                               
                           default:
                               JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 2");
                               
                       }
                       
                   }while(a == true);
                   
                   
                   
                    
                   }
                   catch(NumberFormatException w){
                       JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                   }
                   break;
               case 2:  
                   salir=true;
                   break;
                    
                default:
                   JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 2");
           }
               }
               catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Presiono cancelar ó aceptar\n sin seleccionar opcion validad", "Presiono cancelar ó aceptar sin seleccionar opcion validad", JOptionPane.ERROR_MESSAGE);
      }     
               
       }while(!salir);
    }
}

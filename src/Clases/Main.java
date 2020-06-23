/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 
 */
package Clases;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN PABLO ARENAS VELEZ 
 * cedula 1037633965
 */

public class main {
    public static void main(String[] args) {
        boolean salir = false;  
        Vector vt = new Vector(5,3);  // .size para saber el tamaño
        Vector vf1 = new Vector(5,3);  // .size para saber el tamaño
        Vector vf2 = new Vector(5,3);  // .size para saber el tamaño
        int j = 0;
        int opcion; //Guardaremos la opcion del usuario
        int f1;
        int c1;
        int v;

        
      
           do{
               try{
           opcion =  Integer.parseInt(JOptionPane.showInputDialog("        Escribe una de las opciones\n\n"
                                                                + "1. Crear matriz en tripletas.\n"
                                                                + "2. Crear matriz en forma 2\n"
                                                                + "3. Crear matriz en forma 1\n"
                                                                + "4. Sumar matrices\n"
                                                                + "5. Salir"
                                                                
                                                                 ));
            

        switch(opcion){    // menu principal
                case 1:   // matriz en tripletas
                    try{
                        int f = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de filas a crear"));
                        int c = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Columnas a crear"));
                        Tripleta t = new Tripleta(f,c,0);
                        MatrizEnTripletas M = new MatrizEnTripletas(t);
                        int opcion2; 
                        boolean a = true;
                        do{
                            opcion2 =  Integer.parseInt(JOptionPane.showInputDialog("        Matriz en tripletas\nEscribe una de las opciones \ny recuerde la matriz es de tamaño: " + f + "*" + c 
                                                                     + "\n\n1. Ingresar un dato.\n"
                                                                     + "2. Mostrar matriz como tripletas\n"
                                                                     + "3. (tarea 1) Mostrar matriz en cuadriculas\n"
                                                                     + "4. (tarea 2) sumar la tridiagonal principal\n"
                                                                     + "5. Eliminar dato (ingrese fila y columna)\n"
                                                                     + "6. No ingresar mas y guardar matriz"
                                                                      ));
                            switch(opcion2){
                                case 1:
                                    f1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la fila"));
                                    if(f1 > f){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la fila no puede ser mayor\nal del tamaño de las filas de la matriz\n"
                                                + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    c1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la columna"));
                                    if(c1 > c){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la columna no puede ser mayor\nal del tamaño de las columnas de la matriz\n"
                                                + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    v = Integer.parseInt(JOptionPane.showInputDialog("Valor a ingresar en la matriz"));
                                    t = new Tripleta(f1,c1,v);
                                    System.out.println("\nEntradas hasta el momento.");                                    
                                    M.insertaTripleta(t);
                                    M.mostrarPosiciones();



                                    break;

                                case 2:
                                    if (M.retornaValor() < 1) {
                                        JOptionPane.showMessageDialog(null, "Ingresa almenos un dato para representarlo");
                                    }else{
                                        System.out.println("\nMatriz representada por tripletas");
                                        M.muestraMatrizEnTripletas();
                                        System.out.println("");
                                    }                                   


                                    break;
                                    
                                case 3:   
                                    if (M.retornaValor() < 1) {
                                        JOptionPane.showMessageDialog(null, "Ingresa almenos un dato para representarlo");
                                    }else{
                                        System.out.println("\nMatriz en tripletas representada como matriz dispersa\ny su traspuesta (opcional)");
                                        M.muestraMatriz(M);  
                                        System.out.println("");
                                        if (M.retornaFilas() == M.retornaColumnas()) {
                                            System.out.println("Matriz traspuesta");   
                                            MatrizEnTripletas at = M.traspuesta();
                                            at.muestraMatriz(at);
                                            System.out.println("");
                                        }else{
                                            JOptionPane.showMessageDialog(null, "La matriz debe ser cuadrada para calcular\nla matriz traspuesta");
                                        }
                                    }
                                    
                                    break;

                                case 4:
                                    System.out.println("\nSuma de la tridiagonal principal asociada a la matriz");
                                    M.sumaTridiagonalP(M);                               
                                    System.out.println("");
                                    break; 
                                    
                                case 5:
                                    f1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la fila"));
                                    if(f1 > f){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la fila no puede ser mayor\nal del tamaño de las filas de la matriz\n"
                                                + "ingrese nuevamente la opcion eliminar dato\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    c1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la columna"));
                                    if(c1 > c){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la columna no puede ser mayor\nal del tamaño de las columnas de la matriz\n"
                                                + "ingrese nuevamente la opcion eliminar dato\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    M.eliminarDato(f1,c1);
                                    
                                    break;     

                                case 6:
                                    vt.addElement(M);
                                    a = false;
                                    break;
                                    
                                default:
                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 6");

                            }

                        }while(a == true);




                        }
                        catch(NumberFormatException w){
                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                        }
                        break;
                case 2:  // matriz en forma 2
                    try{  
                        int f = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de filas a crear"));
                        int c = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Columnas a crear"));                        
                        MatrizEnForma2 Mf2 = new MatrizEnForma2(f,c);
                        

                        //
                        int opcion2; 
                        boolean a = true;
                        do{
                            opcion2 =  Integer.parseInt(JOptionPane.showInputDialog("        Matriz en forma 2\nEscribe una de las opciones \ny recuerde la matriz es de tamaño: " + f + "*" + c 
                                                                     + "\n\n1. Ingresar un dato.\n"
                                                                     + "2. Mostrar Matriz en cuadriculas\n"                                                                     
                                                                     + "3. eliminar dato\n"
                                                                     + "4. No ingresar mas y guardar matriz"
                                                                      ));
                            switch(opcion2){
                                case 1:
                                    f1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la fila"));
                                    if(f1 > f){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la fila no puede ser mayor\nal del tamaño de las filas de la matriz\n"
                                                + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    c1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la columna"));
                                    if(c1 > c){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la columna no puede ser mayor\nal del tamaño de las columnas de la matriz\n"
                                                + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    v = Integer.parseInt(JOptionPane.showInputDialog("Valor a ingresar en la matriz"));
                                    Tripleta t = new Tripleta(f1,c1,v);
                                    NodoDoble x = new NodoDoble(t);                                    
                                    Mf2.conectaPorFila(x);
                                    Mf2.conectaPorColumna(x);
                                    System.out.println("\nEntradas hasta el momento.");
                                    Mf2.mostrarPosiciones();


                                    break;

                                case 2:
                                    if (Mf2.primerNodo().retornaLd() == Mf2.primerNodo()) {
                                        JOptionPane.showMessageDialog(null, "Ingresa almenos un dato para representarlo");
                                    }
                                    System.out.println("\nMatriz representada en tripletas");
                                    Mf2.muestraMatriz();
                                    System.out.println("");
                                    System.out.println("\nMatriz representada como lista ligada forma 2 en cuadriculas");
                                    Mf2.muestraMatrizForma2();
                                    System.out.println("");
                                    


                                    break;
                                    
                                case 3:
                                    f1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la fila"));
                                    if(f1 > f){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la fila no puede ser mayor\nal del tamaño de las filas de la matriz\n"
                                                + "ingrese nuevamente la opcion eliminar dato\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    c1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la columna"));
                                    if(c1 > c){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la columna no puede ser mayor\nal del tamaño de las columnas de la matriz\n"
                                                + "ingrese nuevamente la opcion eliminar dato\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    Mf2.eliminarDato(f1,c1);

                                    break;
                                

                                case 4:
                                    vf2.addElement(Mf2);
                                    a = false;
                                    break;    

                                default:
                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");

                            }

                        }while(a == true);




                        }
                        catch(NumberFormatException w){
                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                        }
                   
                   break;  
                case 3: // matriz forma 1 
                     try{
                        int f = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de filas a crear"));
                        int c = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Columnas a crear"));
                        MatrizEnForma1 Mf1 = new MatrizEnForma1(f,c);
                        Mf1.construyeNodosCabeza();

                        
                        int opcion2; 
                        boolean a = true;
                        do{
                            opcion2 =  Integer.parseInt(JOptionPane.showInputDialog("        Matriz forma 1\nEscribe una de las opciones \ny recuerde la matriz es de tamaño: " + f + "*" + c 
                                                                     + "\n\n1. Ingresar un dato.\n"
                                                                     + "2. Mostrar Matriz en cuadriculas\n"
                                                                     + "3. Convertir de forma 1 a forma 2 \n(tarea 3)\n"
                                                                     + "4. eliminar dato\n"
                                                                     + "5. No ingresar mas y guardar matriz"
                                                                      ));
                            switch(opcion2){
                                case 1:
                                    f1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la fila"));
                                    if(f1 > f){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la fila no puede ser mayor\nal del tamaño de las filas de la matriz\n"
                                                + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    c1 = Integer.parseInt(JOptionPane.showInputDialog("Posicion de la columna"));
                                    if(c1 > c){
                                        JOptionPane.showMessageDialog(null, "La posicion del dato en la columna no puede ser mayor\nal del tamaño de las columnas de la matriz\n"
                                                + "ingrese nuevamente la opcion ingresar una tripleta\ny recuerde la matriz es de tamaño: " + f + "*" + c);                                   
                                        break;
                                    }
                                    v = Integer.parseInt(JOptionPane.showInputDialog("Valor a ingresar en la matriz"));
                                    Tripleta t = new Tripleta(f1,c1,v);
                                    NodoDoble x = new NodoDoble(t);                                    
                                    Mf1.conectaPorFilas(x);
                                    Mf1.conectaPorColumnas(x);
//                                    System.out.println("\nEntradas hasta el momento.");
//                                    Mf1.mostrarPosiciones();



                                    break;

                                case 2:
                                    System.out.println("\nMatriz representada en tripletas");
                                    Mf1.muestraMatriz();
                                    System.out.println("");
                                    System.out.println("\nMatriz representada como lista ligada forma 1");
                                    Mf1.muestraMatrizForma1();
                                    System.out.println("");
                                    



                                    break;
                                    
                                case 3:  // se debe ingresar almenos un dato
                                    Tripleta aux = (Tripleta)Mf1.nodoCabeza().retornaDato();
                                    
                                    if(aux.retornaValor() == Mf1.nodoCabeza()){
                                        JOptionPane.showMessageDialog(null, "Ingrese almenos un dato para procesar");
                                        break;
                                    }
                                    System.out.println("\nMatriz representada como lista ligada forma 1\nconvertida a forma #2 (tarea 3)");
                                    MatrizEnForma2 Mforma2;
                                    Mforma2 = Mf1.forma1AForma2(Mf1);
                                    Mforma2.muestraMatrizForma2();

                                    break;
                                    
                                case 4:


                                    break;    

                                case 5:
                                    vf1.addElement(Mf1);
                                    a = false;
                                    break;    

                                default:
                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 5");

                            }

                        }while(a == true);




                        }
                        catch(NumberFormatException w){
                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                        }
                        
                   
                   break;
               
                case 4:
                    try{
                        
                        int opcion3; 
                        boolean a = true;
                        do{
                            opcion3 =  Integer.parseInt(JOptionPane.showInputDialog("        Suma de matrices\nEscribe una de las opciones \n"
                                                                     + "\n\n1. suma matriz forma 1 y matriz en tripletas\ny mostrar como resultado matriz en forma 2\n (tarea 4).\n"
                                                                     + "2. sumar matriz en tripletas con matriz forma 2\n"                                                                     
                                                                     + "3. sumar matriz en tripletas con matriz forma 1\n"
                                                                     + "4. No ingresar mas y guardar matriz"
                                                                      ));
                            switch(opcion3){
                                case 1:
                                    MatrizEnForma2 t4; 
                                    MatrizEnTripletas m = (MatrizEnTripletas)vt.elementAt(0);
                                    MatrizEnForma1 mf1 = (MatrizEnForma1)vf1.elementAt(0);
                                    Tripleta t = (Tripleta)mf1.nodoCabeza().retornaDato();
                                    
                                    if ( (m.retornaColumnas() == t.retornaColumna()) && (m.retornaFilas() == t.retornaFila()) ) {
                                        t4 = new MatrizEnForma2(m.retornaFilas(),m.retornaColumnas());
                                        t4.tarea4(mf1, m);
                                        System.out.println("\nsuma matriz forma 1 con matriz tripletas y muestra forma 2 (tarea 4)");
                                        t4.muestraMatrizForma2();
                                        System.out.println("");
                                        System.out.println("en tripletas");
                                        t4.muestraMatriz();
                                        
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Las matrices deben ser del mismo tañano");
                                        break;
                                    }



                                    break;

                                case 2: // todo
//                                    MatrizEnTripletas m1 = (MatrizEnTripletas)vt.elementAt(0);
//                                    MatrizEnForma2 maf2 = (MatrizEnForma2)vf2.elementAt(0);
//                                    MatrizEnForma1 maf1 = (MatrizEnForma1)vf1.elementAt(0);
//                                    Tripleta t1 = (Tripleta)maf1.primerNodo().retornaDato();
//                                    
//                                    if ( (m1.retornaColumnas() == t1.retornaColumna()) && (m1.retornaFilas() == t1.retornaFila()) ) {
//                                        
//                                        
//                                        
//                                    }else{
//                                        JOptionPane.showMessageDialog(null, "Las matrices deben ser del mismo tañano");
//                                        break;
//                                    }


                                    break;
                                    
                                case 3:  // todo
//                                    MatrizEnTripletas m2 = (MatrizEnTripletas)vt.elementAt(0);
//                                    MatrizEnForma2 matf2 = (MatrizEnForma2)vf2.elementAt(0);
//                                    MatrizEnForma1 matf1 = (MatrizEnForma1)vf1.elementAt(0);
//                                    Tripleta t2 = (Tripleta)matf1.primerNodo().retornaDato();
//                                    
//                                    if ( (m2.retornaColumnas() == t2.retornaColumna()) && (m2.retornaFilas() == t2.retornaFila()) ) {
//                                        
//                                        
//                                        
//                                    }else{
//                                        JOptionPane.showMessageDialog(null, "Las matrices deben ser del mismo tañano");
//                                        break;
//                                    }

                                    break;
                                

                                case 4:
                                    a = false;
                                    break;    

                                default:
                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");

                            }

                        }while(a == true);




                        }
                        catch(NumberFormatException w){
                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                        }
                        
                   
                        
                    break;
                
                case 5:                    
                    salir = true;
                    break;   
                   
                   
                default:
                   JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");
           }
               }
               catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Presiono cancelar ó aceptar\n sin seleccionar opcion validad", "Presiono cancelar ó aceptar sin seleccionar opcion validad", JOptionPane.ERROR_MESSAGE);
      }     
               
       }while(!salir);
    }
}


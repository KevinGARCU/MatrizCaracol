/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturamatriz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author nicol
 */
public final class Leer {
    public Leer(String ruta) throws FileNotFoundException, IOException{
        File archivo = new File(ruta);
        String[] array;
        String[][] matriz;
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String texto = br.readLine();
        array = separar(texto);
        matriz = new String[array.length][array.length];        
        for(int j=0; j<matriz.length;j++){
            matriz[0][j]=array[j];
        }
        int i = 1;
         while(texto!=null){        
             texto = br.readLine();
             if(texto==null)break;
             array = separar(texto);
             matriz = organizar(array,matriz,i);
             i++;
        }
         mostrarMatriz(matriz);
         matrizCaracol(matriz);
    }
    public final String[][] organizar(String[] array,String[][] matriz,int i){  
        for(int j=0; j<matriz.length;j++){
            matriz[i][j]=array[j];
        }
        return matriz;
    }
    public final String[] separar(String texto){
        
        String[] partido = texto.split(" ");
        return partido;
    }
    public void mostrarMatriz(String[][] matriz){
        for (String[] matriz1 : matriz) {
            for (int j = 0; j<matriz.length; j++) {
                System.out.print(matriz1[j]+" ");
            }
            System.out.println();
        }
        System.out.println("");
    }
    public void matrizCaracol(String[][] matriz){
        int TamMatriz=matriz.length;
        int inicio = 0;
        int borde = TamMatriz-1;
        int aux = 1;
        
        while(aux < TamMatriz*TamMatriz ){
            for(int i=inicio; i<=borde; i++){
                System.out.print(matriz[inicio][i] + " ");
                aux++;
            }
            
            for(int i=inicio+1; i<=borde; i++){
                System.out.print(matriz[i][borde] + " ");
                aux++;
            }
            
            for(int i=borde-1; i>=inicio; i--){
                System.out.print(matriz[borde][i] + " ");
                aux++;
            }
            
            for(int i=borde-1; i>=inicio+1; i--){
                System.out.print(matriz[i][inicio] + " ");
                aux++;
            }
           
            inicio++;
            borde--;
        }
    }
}

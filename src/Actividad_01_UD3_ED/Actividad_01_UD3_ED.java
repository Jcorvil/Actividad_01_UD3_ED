/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] intermedio = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream entradaStream = null;
    private static BufferedInputStream entradaIntermedio = null;

    public static void inicializarArchivos() throws FileNotFoundException
    {
        entradaStream = new FileInputStream(nombreArchivo);
        entradaIntermedio = new BufferedInputStream(entradaStream);
    }
    
    public static int mostrarTextoArchivo() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = entradaStream.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivos();
            
            int total = mostrarTextoArchivo();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaIntermedio != null && entradaStream != null )
                {
                    entradaStream.close();
                    entradaIntermedio.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}

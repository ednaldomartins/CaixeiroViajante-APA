
package util;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 25.10.2018                                                           *
 ******************************************************************************/
public class Print 
{
    public static void printMatriz (long[][] matriz)
    {
        System.out.println("\n\nMatriz. Tamanho: " + matriz.length );
        for(int i = 0; i < matriz.length; i++)
        {
            for(int j = 0; j < matriz.length; j++)
                System.out.print( " " + matriz[i][j]);
            System.out.println();
        }
    }
    
    public static void printVetor (int [] vetor)
    {
        System.out.println("\n\nSCV. Tamanho: " + vetor.length + "\n[ ");
        for(int i = 0; i < vetor.length; i++)
            System.out.println( vetor[i] + " ");
        System.out.print("]");
    }
    
    public static void printResultado (long [][] matriz, int [] scv)
    {
        long resultado = 0;
        System.out.println("\n\nSCV. Tamanho: " + scv.length);
        for(int i = 0; i < scv.length-1; i++)
        {
            System.out.println( "("+scv[i]+")______" + 
                                matriz[scv[i]][scv[i+1]] + "______(" + 
                                scv[i+1]+ ")" );
            resultado += matriz[scv[i]][scv[i+1]];
        }
        System.out.println("SCV. Resultado: " + resultado);
    }
    
}

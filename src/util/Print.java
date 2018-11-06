
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
    
    public static void printVetor (int [] vetor, String nome)
    {
        System.out.print("\n\n\n"+ nome +". Tamanho: " + vetor.length + "\n[ ");
        for(int i = 0; i < vetor.length; i++)
            System.out.print( (vetor[i]+1) + " ");
        System.out.print("]");
    }
    
    public static void printResultado (long [][] matriz, int [] scv, String nome)
    {
        long resultado = 0;
        System.out.println("\n\n"+nome+". Tamanho: " + scv.length);
        for(int i = 0; i < scv.length-1; i++)
        {
            System.out.println( "("+(scv[i]+1)+")______" + 
                                matriz[scv[i]][scv[i+1]] + "______(" + 
                                (scv[i+1]+1)+ ")" );
            resultado += matriz[scv[i]][scv[i+1]];
        }
        System.out.println(nome+". Resultado: " + resultado);
    }
    
}

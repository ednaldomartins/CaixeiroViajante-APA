
package util;

import model.Rota;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 25.10.2018                                                           *
 ******************************************************************************/
public class Print 
{
    public static void printMatriz (Rota[][] matriz)
    {
        System.out.println("\n\nMatriz de Rota. Tamanho: " + matriz.length );
        for(int i = 0; i < matriz.length; i++)
        {
            for(int j = 0; j < matriz.length; j++)
                System.out.print( " " + matriz[i][j].getDistancia());
            System.out.println();
        }
    }
    
    public static void printResultado (Rota [][] matrizSCV)
    {
        if(matrizSCV != null) {
            long resultadoPCV = 0;
            for(int i = 0; i < matrizSCV.length; i++)
                for(int j = 0; j < matrizSCV.length; j++)
                    resultadoPCV += matrizSCV[i][j].getDistancia();
            System.out.println("SCV. Tamanho: " + matrizSCV.length);
            System.out.println("SCV. Resultado: " + resultadoPCV);
        }
        else
            System.out.println("Matriz vazia");
    }
    
    public static void printVetor (Rota [] vetor)
    {
        System.out.println("\n\nSCV. Tamanho: " + vetor.length);
        for(int i = 0; i < vetor.length; i++)
        {
            System.out.println( "idRota: " + vetor[i].getId() +
                                "(" + vetor[i].getCidade1()+ ")" + 
                                "______" + vetor[i].getDistancia()+ "______" + 
                                "(" + vetor[i].getCidade2()+ ")" );
        }
    }
    
    public static void printResultado (Rota [] vetor)
    {
        long resultado = 0;
        System.out.println("\n\nSCV. Tamanho: " + vetor.length);
        for(int i = 0; i < vetor.length; i++)
        {
            System.out.println( "idRota: " + vetor[i].getId() +
                                "(" + vetor[i].getCidade1()+ ")" + 
                                "______" + vetor[i].getDistancia()+ "______" + 
                                "(" + vetor[i].getCidade2()+ ")" );
            resultado += vetor[i].getDistancia();
        }
        System.out.println("SCV. Resultado: " + resultado);
    }
}


package model;

import util.FuncoesVetor;
import util.RefinamentoPCV;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 26.10.2018                                                           *
 ******************************************************************************/
public class VND implements RefinamentoPCV
{
    /**
     * VND: Variable Neighborhood Descent
     * DVV: Descida em Vizinhança Variavel
     * @param r
     * @param grafo
     * @param rota
     */
    @Override
    public void refinar(Rota r, long[][] grafo, int[] rota)
    {
        r.setResultado(calcularResultado(grafo, rota));
        int [] novaRota = new int[rota.length];
        //FuncoesVetor.copiarVetor(rota, novaRota);
        twoOPT(r, grafo, rota, novaRota);
    }
    
    /**
     * Metodo de Descida 2-opt
     * O elemento i deve ir da posicao inicial dele, descendo ate o fim do vetor
     * na posicao n-1, depois o elemento i+1, e assim por diante.
     * @param r
     * @param grafo
     * @param rota
     * @param novaRota 
     */
    private void twoOPT(Rota r, long [][] grafo, int [] rota, int [] novaRota)
    {
        for(int i = 1; i < rota.length; i++)
        {
            FuncoesVetor.copiarVetor(rota, novaRota);
            for(int j = i+1; j < rota.length-1; j++)
            {
                exchange(novaRota, j-1, j);
                buildMelhorSolucao(r, grafo, rota, novaRota);
            }
        }
    }
    
    private void buildMelhorSolucao(Rota r, long [][] grafo, int [] rota, int [] novaRota)
    {
        r.addSolucao(novaRota);
        long resultado = calcularResultado(grafo, novaRota);
        if( resultado < r.getResultado() )
        {
            r.setResultado(resultado);
            r.setMelhorRota(r.getUltimaSolucao());
            r.setMelhorSolucao(novaRota);
        }
    }
    
    private void exchange ( int [] list, int i, int j )
    {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
    
    private void insert (int [] list, int i, int j)
    {
        int temp = list[i];
        while(i < j)
            list[i] = list[++i];
        list[j] = temp;
    }
    
    private long calcularResultado (long [][] grafo, int [] vetorSCV)
    {
        long calculo = 0;
        for(int i = 0; i < vetorSCV.length-1; i++)
            calculo += grafo[vetorSCV[i]][vetorSCV[i+1]];
        return calculo;
    }

}

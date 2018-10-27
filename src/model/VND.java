
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
     * @param grafo
     * @param rota
     */
    @Override
    public void refinar(Rota r, long[][] grafo, int[] rota)
    {
        r.setResultado(calcularResultado(grafo, rota));
        int [] novaRota = new int[rota.length];
        for(int i = 1, j = rota.length-1; i < j; i++, j--)
        {
            FuncoesVetor.copiarVetor(rota, novaRota);
            this.exchange(novaRota, i, j-1);
            //rota = ( this.buildMelhorSolucao(r, grafo, novaRota) )  ? novaRota : rota;
            this.buildMelhorSolucao(r, grafo, rota, novaRota);
            this.insert(novaRota, i, j-1);
            this.buildMelhorSolucao(r, grafo, rota, novaRota);
            //rota = ( this.buildMelhorSolucao(r, grafo, novaRota) )  ? novaRota : rota;
            //r.setResultado( resultado  <  r.getResultado() ? resultado : r.getResultado() );
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
            rota = novaRota;
        }
        else 
            novaRota = rota;
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

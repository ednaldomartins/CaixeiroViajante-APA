
package model;

import util.FuncoesVetor;
import util.HeuristicaRefinamento;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 26.10.2018                                                           *
 ******************************************************************************/
public class VND extends VariableNeighborhood implements HeuristicaRefinamento
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
        r.setMelhorResultado(calcularResultado(grafo, rota));
        int [] novaRota = new int[rota.length];
        int [] melhorRota = new int[rota.length];
        FuncoesVetor.copiarVetor(rota, novaRota);
        
        //dah pra usar um padrao de projeto para transformacao de um objeto em varias formas(estruturas de vizinhancas)
        int estruturaVizinhanca = 1;
        while(estruturaVizinhanca != 0)
        {
            long resultadoInicial = r.getMelhorResultado(), melhorResultado = resultadoInicial;
            //N1: Exchange
            if(estruturaVizinhanca == 1)
            {
                for(int i = 1; i < rota.length-2; i++)
                {
                    long novoResultado = Long.MAX_VALUE;
                    for(int j = 1; j < rota.length-1; j++)
                    {
                        exchange(novaRota, i, j);
                        novoResultado = calcularResultado(grafo, novaRota);
                        if(i!=j && novoResultado < melhorResultado)
                        {
                            melhorResultado = novoResultado;
                            FuncoesVetor.copiarVetor(novaRota, melhorRota);
                        }
                        else//entao eh melhor q o inicial mas melhor q o que ja foi encontrado
                        exchange(novaRota, i, j);
                    }
                    if(melhorResultado < r.getMelhorResultado())
                        buildMelhorSolucao(r, grafo, melhorRota, melhorResultado);
                }
                if(melhorResultado >= resultadoInicial)
                    estruturaVizinhanca = 2;
            }//fim da estrutura de vizinhaca N1.
            
            else    
            //N2: Insert
            if(estruturaVizinhanca == 2)
            {
                //FuncoesVetor.copiarVetor(melhorRota, novaRota);
                for(int i = 1; i < rota.length-2; i++)
                {
                    long novoResultado = Long.MAX_VALUE;
                    for(int j = 1; j < rota.length-1; j++)
                    {
                        insert(novaRota, i, j);
                        novoResultado = calcularResultado(grafo, novaRota);
                        if(i!=j && novoResultado < melhorResultado)
                        {
                            melhorResultado = novoResultado;
                            FuncoesVetor.copiarVetor(novaRota, melhorRota);
                        }
                        else//entao eh melhor q o inicial mas melhor q o que ja foi encontrado
                        insert(novaRota, j, i);
                    }
                    if(melhorResultado < r.getMelhorResultado())
                        buildMelhorSolucao(r, grafo, melhorRota, melhorResultado);
                }
                estruturaVizinhanca = (melhorResultado >= resultadoInicial) ? 0:1;
//                if(melhorResultado >= resultadoInicial)
//                    estruturaVizinhanca = 0;
//                else
//                    estruturaVizinhanca = 1;
            }//fim da estrutura de Vizinhaca N2
         
            
        }//fim do while
        
    }
    
    
}

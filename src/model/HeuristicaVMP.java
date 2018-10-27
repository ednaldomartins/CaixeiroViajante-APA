
package model;

import util.Heuristica;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date 24.10.2018                                                            *
 ******************************************************************************/
public class HeuristicaVMP implements Heuristica
{
    int contRotas[];
    int inicio;
    /*
    VMP: Vizinho mais proximo
    SCV: Solucao do caixeiro viajante
    */
    //nova funcao simplificada
    @Override
    public void solucionarPCV(long[][] grafo, int[] vetorSCV)
    {
        //contador de rotas por cidade
        contRotas = new int[grafo.length];
        //ponto de partida escolhido
        int inicio = 0, cidadeAtual = inicio, proximaCidade = -1, n = 0;
        vetorSCV[0] = inicio;
        contRotas[inicio]++;
        while(!isHamiltoniano(vetorSCV)) 
        {
            long menor = Long.MAX_VALUE;
            proximaCidade = -1;
            for(int j = 0; j < grafo.length; j++)
            {
                if( grafo[cidadeAtual][j]!= 0 && grafo[cidadeAtual][j] < menor 
                    && contRotas[j] < 2 && j != inicio)
                {
                    proximaCidade = j;
                    menor = grafo[cidadeAtual][proximaCidade];
                }
            }
            
            if(proximaCidade != -1)
            {   //teoricamente encontrou uma proxima rota
                addCidade(grafo, vetorSCV, cidadeAtual, proximaCidade, ++n);
                cidadeAtual = proximaCidade;
            }
        }
    }
    
    private void addCidade( long [][] grafo, int [] vetor, int i, int j, int pos)
    {
        vetor[pos] = j;
        contRotas[i]++;
        contRotas[j]++;
        vetor[pos+1] = inicio;
    }
    
    //contador simplificado usando vetor
    private boolean isHamiltoniano( int [] vetor)
    {
        return !(vetor[vetor.length-1] != vetor[0]);
    }
}

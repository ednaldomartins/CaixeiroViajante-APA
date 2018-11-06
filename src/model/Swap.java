
package model;

import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 03.11.2018                                                           *
 ******************************************************************************/
public class Swap extends EstruturaVizinhanca
{
    @Override
    public EstruturaVizinhanca explorar(Rota r, long[][] grafo, int[] novaRota, int[] melhorRota) 
    {
        long resultadoInicial = r.getMelhorResultado(), melhorResultado = resultadoInicial;
        //buscar todas as possiveis combinacoes em rota atraves de Exchange
        for(int i = 1; i < novaRota.length-2; i++)
        {
            long novoResultado = 0;
            for(int j = i+1; j < novaRota.length-1; j++)
            {
                //a cada interacao faz a troca e calcula o novo resultado obtido
                exchange(novaRota, i, j);
                novoResultado = calcularResultado(grafo, novaRota);
                if(novoResultado < melhorResultado)
                {
                    melhorResultado = novoResultado;
                    FuncoesVetor.copiarVetor(novaRota, melhorRota);
                }
                exchange(novaRota, i, j);
            }
            //se encontrou um melhorResultado, guarda-lo
            if(melhorResultado < r.getMelhorResultado())
            {
                buildMelhorSolucao(r, grafo, melhorRota, melhorResultado);
                FuncoesVetor.copiarVetor(melhorRota, novaRota);
            }
        }
        //N1: Swap, entao se nao encontrou um melhorResultado ir para o N2.
        return (melhorResultado < resultadoInicial) ? this : new Reinsertion();
    }
    
    private void exchange ( int [] list, int i, int j )
    {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
    
}


package model;

import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 03.11.2018                                                           *
 ******************************************************************************/
public class Swap extends EstruturaVizinhanca
{
    @Override
    public EstruturaVizinhanca explorar(Rota r, long[][] grafo, int[] rota, int[] novaRota, int[] melhorRota) 
    {
        long otimoGlobal = r.getMelhorResultado(), otimoLocal = otimoGlobal;
        //buscar todas as possiveis combinacoes em rota atraves de Exchange
        for(int i = 1; i < rota.length-2; i++)
        {
            long novoResultado = 0;
            for(int j = 1; j < rota.length-1; j++)
            {
                //a cada interacao faz a troca e calcula o novo resultado obtido
                exchange(novaRota, i, j);
                novoResultado = calcularResultado(grafo, novaRota);
                if(i!=j && novoResultado < otimoLocal)
                {
                    otimoLocal = novoResultado;
                    FuncoesVetor.copiarVetor(novaRota, melhorRota);
                }
                exchange(novaRota, i, j);
            }
            //se encontrou um otimoLocal, guarda-lo
            if(otimoLocal < r.getMelhorResultado())
            {
                buildMelhorSolucao(r, grafo, melhorRota, otimoLocal);
                FuncoesVetor.copiarVetor(melhorRota, novaRota);
            }
        }
        //N1: Swap, entao se nao encontrou um otimoLocal ir para o N2.
        return (otimoLocal >= otimoGlobal) ? new Reinsertion() : this;
    }
    
    private void exchange ( int [] list, int i, int j )
    {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
    
}

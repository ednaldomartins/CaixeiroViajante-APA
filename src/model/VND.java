
package model;

import util.FuncoesVetor;
import util.HeuristicaRefinamento;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 26.10.2018                                                           *
 ******************************************************************************/
public class VND implements HeuristicaRefinamento
{
    EstruturaVizinhanca ev;
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
        int [] melhorRota = new int[rota.length];
        FuncoesVetor.copiarVetor(rota, melhorRota);
        
        ev = new Swap();
        while(ev != null)
            ev = ev.explorar(r, grafo, rota, melhorRota);
        FuncoesVetor.copiarVetor(r.getMelhorRota(), rota);
    }

    
    
}

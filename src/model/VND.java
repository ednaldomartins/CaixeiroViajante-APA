
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
        int [] novaRota = new int[rota.length];
        int [] melhorRota = new int[rota.length];
        FuncoesVetor.copiarVetor(rota, novaRota);
        
        ev = new Swap();
        while(ev != null)
            ev = ev.explorar(r, grafo, rota, novaRota, melhorRota);
    }
    
}

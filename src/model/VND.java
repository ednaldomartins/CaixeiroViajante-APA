
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
        r.setResultado(calcularResultado(grafo, rota));
        int [] novaRota = new int[rota.length];
        //FuncoesVetor.copiarVetor(rota, novaRota);
        twoOPT(r, grafo, rota, novaRota);
    }
    
    
}


package util;

import model.Rota;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 26.10.2018                                                           *
 ******************************************************************************/
public interface HeuristicaRefinamento 
{
    void refinar(Rota r, long [][] grafo, int [] rota);
}

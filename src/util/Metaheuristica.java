
package util;

import model.Rota;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 30.10.2018                                                           *
 ******************************************************************************/
public interface Metaheuristica 
{
    public void explorar(Rota r, long[][] grafo, int[] rota);
}

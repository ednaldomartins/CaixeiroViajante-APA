
package util;

import model.Rota;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date 24.10.2018                                                            *
 ******************************************************************************/
public interface Heuristica 
{
    void solucionarPCV(Rota [][] grafo, Rota [][] grafoSCV);
}


package model;

import util.Metaheuristica;

/**
 *
 * @author Ednaldo
 */
public class VNS extends VariableNeighborhood implements Metaheuristica
{
    @Override
    public void explorar(Rota r, long[][] grafo, int[] rota) 
    {
        int [] novaRota = new int[rota.length];
        kOPT(r, grafo, rota, novaRota);
    }
    
    public void kOPT (Rota r, long [][] grafo, int [] rota, int [] novaRota)
    {
        
    }
    
    
}

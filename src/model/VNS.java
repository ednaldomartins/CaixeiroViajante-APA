
package model;

import java.util.Random;
import util.FuncoesVetor;
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
        Random random = new Random();
        for(int i = 1, k = 3; i < rota.length-2; i++)
        {
            FuncoesVetor.copiarVetor(rota, novaRota);
            for(int cont = 2; cont <= k; cont++)
            {
                
                int a = i, b = random.nextInt(novaRota.length-4)+1, c = (novaRota.length-2)/2 + (b-4)/2;
                if(otimaTroca(grafo, a, b, c))
                    buildMelhorSolucao(r, grafo, rota, novaRota);
            }
            //buildMelhorSolucao(r, grafo, rota, novaRota);
            if(r.getNumMelhorRota() != r.getUltimaSolucao())
            {
                FuncoesVetor.copiarVetor(rota, novaRota);
                k=4;
            }
            else{k=3;}
        }
    }
    
    public boolean otimaTroca(long [][] grafo, int a, int b, int c)
    {
        return (grafo[a-1][a] + grafo[a][a+1] + 
                grafo[b-1][b] + grafo[b][b+1] +
                grafo[c-1][c] + grafo[c][c+1] 
                >
                grafo[b-1][a] + grafo[a][b+1] +
                grafo[c-1][b] + grafo[b][c+1] +
                grafo[a-1][c] + grafo[c][a+1] 
                );
    }
}

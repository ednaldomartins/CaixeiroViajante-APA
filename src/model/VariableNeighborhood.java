
package model;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 30.10.2018                                                           *
 ******************************************************************************/
public class VariableNeighborhood 
{
    protected void buildMelhorSolucao(Rota r, long [][] grafo, int [] melhorRota, long resultado)
    {
        r.addSolucao(melhorRota);
        r.setMelhorResultado(resultado);
        r.setNumMelhorRota(r.getUltimaSolucao());
        r.setMelhorSolucao(melhorRota);
    }
    
    protected void exchange ( int [] list, int i, int j )
    {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
    
    protected void insert (int [] list, int i, int j)
    {
        int temp = list[i];
        if( i < j )
            while(i < j)
                list[i] = list[++i];
        else
            while(i > j)
                list[i] = list[--i];
        list[j] = temp;
    }
   
    protected long calcularResultado (long [][] grafo, int [] vetorSCV)
    {
        long calculo = 0;
        for(int i = 0; i < vetorSCV.length-1; i++) 
            calculo += grafo[vetorSCV[i]][vetorSCV[i+1]];
        return calculo;
    }

}

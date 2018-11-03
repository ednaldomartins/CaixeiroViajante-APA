
package model;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 30.10.2018                                                           *
 ******************************************************************************/
public abstract class EstruturaVizinhanca 
{
    //STATE
    public abstract EstruturaVizinhanca explorar(Rota r, long[][] grafo, int[] rota, int[] novaRota, int[] melhorRota);
            
    protected void buildMelhorSolucao(Rota r, long [][] grafo, int [] melhorRota, long resultado)
    {
        r.addSolucao(melhorRota);
        r.setMelhorResultado(resultado);
        r.setNumMelhorRota(r.getUltimaSolucao());
        r.setMelhorSolucao(melhorRota);
    }
    
    protected long calcularResultado (long [][] grafo, int [] vetorSCV)
    {
        long calculo = 0;
        for(int i = 0; i < vetorSCV.length-1; i++) 
            calculo += grafo[vetorSCV[i]][vetorSCV[i+1]];
        return calculo;
    }
}

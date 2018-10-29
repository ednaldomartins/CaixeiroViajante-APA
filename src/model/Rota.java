
package model;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.10.2018                                                           *
 ******************************************************************************/
public class Rota 
{
    /**
     * melhorRota: guarda a posicao da melhor rota na matriz de solucoes
     * ultimaSolucao: guarda a posicao da ultima solucao na matriz de solucoes
     * melhorResultado: guarda o valor do calculo da melhor rota
     * solucoes: matriz de solucoes
     */
    private int melhorRota;         
    private int ultimaSolucao;  
    private long melhorResultado; 
    private int [] melhorSolucao;
    private int [][] solucoes;
    
    public Rota(int numCidades)
    {
        this.melhorRota = -1;
        this.ultimaSolucao = -1;
        this.melhorResultado = Long.MAX_VALUE;
        this.melhorSolucao = new int [numCidades+1];
        this.solucoes = new int [(numCidades-1)*(numCidades-1)/2][numCidades+1];
    }

    public void addSolucao(int [] solucao)
    {
        this.ultimaSolucao++;
        for(int i = 0; i < solucao.length; i++)
            solucoes[ultimaSolucao][i] = solucao[i];
    }

    public int [] getMelhorRota() {
        int [] vetor = new int [solucoes[0].length];
        for(int i = 0; i < vetor.length; i++)
            vetor[i] = solucoes[melhorRota][i];
        return vetor;
    }
    
    //GETs 
    public int getNumMelhorRota() {
        return melhorRota;
    }

    public int[][] getSolucoes() {
        return solucoes;
    }

    public int getUltimaSolucao() {
        return ultimaSolucao;
    }
    
    public long getResultado() {
        return melhorResultado;
    }

    public int[] getMelhorSolucao() {
        return melhorSolucao;
    }
    
    

    //SETs
    public void setMelhorRota(int melhorRota) {
        this.melhorRota = melhorRota;
    }

    public void setUltimaSolucao(int ultimaSolucao) {
        this.ultimaSolucao = ultimaSolucao;
    }

    public void setResultado(long resultado) {
        this.melhorResultado = resultado;
    }

    public void setMelhorSolucao(int[] melhorSolucao) {
        this.melhorSolucao = melhorSolucao;
    }
    
    public void setSolucoes(int[][] solucoes) {
        this.solucoes = solucoes;
    }
    
}


package model;

import util.FuncoesVetor;
import util.Heuristica;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date 24.10.2018                                                            *
 ******************************************************************************/
public class HeuristicaVMP implements Heuristica
{
    int contRotas[];
    int inicio;
    /*
    VMP: Vizinho mais proximo
    SCV: Solucao do caixeiro viajante
    */
    //nova funcao simplificada
    @Override
    public void solucionarPCV(long[][] grafo, int[] vetorSCV)
    {
        //contador de rotas por cidade
        contRotas = new int[grafo.length];
        //ponto de partida escolhido
        int inicio = 0, cidadeAtual = inicio, proximaCidade = -1, n = 0;
        vetorSCV[0] = inicio;
        contRotas[inicio]++;
        while(!isHamiltoniano(vetorSCV)) 
        {
            long menor = Long.MAX_VALUE;
            proximaCidade = -1;
            for(int j = 0; j < grafo.length; j++)
            {
                if( grafo[cidadeAtual][j]!= 0 && grafo[cidadeAtual][j] < menor 
                    && contRotas[j] < 2 && j != inicio)
                {
                    proximaCidade = j;
                    menor = grafo[cidadeAtual][proximaCidade];
                }
            }
            
            if(proximaCidade != -1)
            {   //teoricamente encontrou uma proxima rota
                addCidade(grafo, vetorSCV, cidadeAtual, proximaCidade, ++n);
                cidadeAtual = proximaCidade;
            }
        }
    }
    
    private void addCidade( long [][] grafo, int [] vetor, int i, int j, int pos)
    {
        vetor[pos] = j;
        contRotas[i]++;
        contRotas[j]++;
        vetor[pos+1] = inicio;
    }
    
    //contador simplificado usando vetor
    private boolean isHamiltoniano( int [] vetor)
    {
        return !(vetor[vetor.length-1] != vetor[0]);
    }
    
    @Override
    public void solucionarPCV(Rota[][] grafo, Rota[] vetorSCV)
    {
        //contador de rotas por cidade
        contRotas = new int[grafo.length];
        FuncoesVetor.iniciarVetor(contRotas);
        //ponto de partida escolhido
        int inicio = 0;
        int i = inicio, n = 0;
        contRotas[inicio]++;
        while(!isHamiltoniano(vetorSCV))
        {
            Rota vmp = new Rota(-1, -1, -1, Long.MAX_VALUE, false);
            int j = 0;
            while(j < grafo.length)
            {
                if(     grafo[i][j].getDistancia()!= 0 && 
                        grafo[i][j].getDistancia() < vmp.getDistancia() &&
                        !grafo[i][j].isSelecionada() && 
                        contRotas[j] < 2 )
                {
                    vmp = grafo[i][j];
                }
                j++;
            }
            
            if(vmp.getId() != -1)
            {   //teoricamente encontrou uma proxima rota
                grafo[vmp.getCidade1()][vmp.getCidade2()].setSelecionada(true);
                grafo[vmp.getCidade2()][vmp.getCidade1()].setSelecionada(true);
                vmp.setSelecionada(true);
                addRota(grafo, vetorSCV, vmp, n);
                n++;
                i = vmp.getCidade2();
            }
         
            
        }
        
            
    }
    
    //contador simplificado usando vetor
    private boolean isHamiltoniano( Rota [] vetor)
    {
        for(int i = 0; i < vetor.length; i++)
            if(!vetor[i].isSelecionada())
                return false;
        return true;
    }
    
    private void addRota( Rota [][] grafo, Rota [] vetor, Rota rota, int pos)
    {
        vetor[pos] = rota;
        contRotas[rota.getCidade1()]++;
        contRotas[rota.getCidade2()]++;
        Rota retorno = new Rota( grafo[pos][0].getId(), rota.getCidade2(), 0, grafo[pos][0].getDistancia(), true);
        vetor[pos+1] = retorno;
    }
}

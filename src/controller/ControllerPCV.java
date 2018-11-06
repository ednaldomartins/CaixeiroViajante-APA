
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import infra.Arquivo;
import model.Rota;
import util.FuncoesVetor;
import util.Print;
import util.HeuristicaRefinamento;
import util.HeuristicaConstrutiva;
import util.Metaheuristica;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.10.2018                                                           *
 ******************************************************************************/
public class ControllerPCV 
{
    private final String ARQUIVO_ORIGEM = "..\\CaixeiroViajante\\instancias\\pcv7_29.txt";
    private final long[][] matriz;
    private Rota r;          //Objeto Rota guarda varias informacoes sobre rotas
    private int [] vetorSCV;    //primeira solucao

    public ControllerPCV() 
    {
        this.matriz = carregarMatrizArquivo();
        this.r = new Rota(matriz.length);
    }
    
    public void controlePCV (HeuristicaConstrutiva heuristica, HeuristicaRefinamento refinamento)
    {
        vetorSCV = new int[matriz.length+1];
        FuncoesVetor.iniciarVetor(vetorSCV);
        heuristica.solucionarPCV(matriz, vetorSCV);
        r.setSolucaoInicial(vetorSCV);
        r.addSolucao(vetorSCV);
        refinamento.refinar(r, matriz, vetorSCV);
        r.setSolucaoRefinamento(vetorSCV);
    }
    
    public void controlePCV (HeuristicaConstrutiva heuristica, HeuristicaRefinamento refinamento, Metaheuristica metaheuristica)
    {
        this.controlePCV(heuristica, refinamento);
        metaheuristica.explorar(r, matriz, vetorSCV);
    }
    
    //Arquivo
    private long[][] carregarMatrizArquivo() 
    {
        try {
            return new Arquivo(ARQUIVO_ORIGEM).carregarMatrizLongPCV();
        } catch (IOException ex) { Logger.getLogger(ControllerPCV.class.getName()).log(Level.SEVERE, null, ex); }
        return null;
    }    
    
    //Prints
    public void printMatrizPCV ()
    {
        Print.printMatriz(matriz);
    }
    
    public void printVetorInicialSCV ()
    {
        Print.printVetor(r.getSolucaoInicial(), "SCV inicial");
    }
    
    public void printResultadoInicialSCV ()
    {
        Print.printResultado(matriz, r.getSolucaoInicial(), "SCV inicial");
    }
    
    public void printVetorRefinamentoSCV ()
    {
        Print.printVetor(r.getSolucaoRefinamento(), "SCV com Refinamento");
    }
    
    public void printResultadoRefinamentoSCV ()
    {
        Print.printResultado(matriz, r.getSolucaoRefinamento(), "SCV com Refinamento");
    }
    
    public void printVetorOtimoGlobalSCV ()
    {
        Print.printVetor(r.getMelhorSolucao(), "SCV - MelhorSolucao");
    }
    public void printOtimoGlobalSCV()
    {
        Print.printResultado(matriz, r.getSolucao(r.getNumMelhorRota() ), "SCV - MelhorSolucao");
    }
}

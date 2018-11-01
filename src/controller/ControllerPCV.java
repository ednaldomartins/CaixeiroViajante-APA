
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
    private final String ARQUIVO_ORIGEM = "..\\CaixeiroViajante\\instancias\\pcv9_177.txt";
    private final long[][] matriz;
    private Rota rota;          //Objeto Rota guarda varias informacoes sobre rotas
    private int [] vetorSCV;    //primeira solucao

    public ControllerPCV() 
    {
        this.matriz = carregarMatrizArquivo();
        this.rota = new Rota(matriz.length);
    }
    
    public void controlePCV (HeuristicaConstrutiva heuristica, HeuristicaRefinamento refinamento)
    {
        vetorSCV = new int[matriz.length+1];
        FuncoesVetor.iniciarVetor(vetorSCV);
        heuristica.solucionarPCV(matriz, vetorSCV);
        rota.addSolucao(vetorSCV);
        rota.setNumMelhorRota(0);
        refinamento.refinar(rota, matriz, vetorSCV);
    }
    
    public void controlePCV (HeuristicaConstrutiva heuristica, HeuristicaRefinamento refinamento, Metaheuristica metaheuristica)
    {
        this.controlePCV(heuristica, refinamento);
        metaheuristica.explorar(rota, matriz, vetorSCV);
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
    
    public void printVetorSCV ()
    {
        Print.printVetor(vetorSCV);
    }
    
    public void printResultadoSCV ()
    {
        Print.printResultado(matriz, vetorSCV);
    }
    
    public void printMelhorResultado()
    {
        Print.printResultado(matriz, rota.getSolucao( rota.getNumMelhorRota() ));
    }
}

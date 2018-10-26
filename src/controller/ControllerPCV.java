
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import infra.Arquivo;
import util.FuncoesVetor;
import util.Heuristica;
import util.Print;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.10.2018                                                           *
 ******************************************************************************/
public class ControllerPCV 
{
    private final String ARQUIVO_ORIGEM = "..\\CaixeiroViajante\\instancias\\pcv10.txt";
    private final long[][] matriz;
    private int [] vetorSCV;

    public ControllerPCV() 
    {
        this.matriz = carregarMatrizArquivo();
    }
    
    public void controlePCV (Heuristica heuristica)
    {
        vetorSCV = new int[matriz.length+1];
        FuncoesVetor.iniciarVetor(vetorSCV);
        heuristica.solucionarPCV(matriz, vetorSCV);
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
}

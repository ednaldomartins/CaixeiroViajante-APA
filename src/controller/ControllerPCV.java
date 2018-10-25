
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Rota;
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
    private final String ARQUIVO_ORIGEM = "..\\CaixeiroViajante\\instancias\\pcv177.txt";
    private final Rota[][] matrizRota;
    private Rota [] vetorSCV;

    public ControllerPCV() 
    {
        this.matrizRota = carregarMatrizArquivo();
    }
    
    public void controlePCV (Heuristica heuristica)
    {
        vetorSCV = new Rota[matrizRota.length];
        FuncoesVetor.iniciarVetor(vetorSCV);
        heuristica.solucionarPCV(matrizRota, vetorSCV);
    }
    
    //Arquivo
    private Rota[][] carregarMatrizArquivo() 
    {
        try {
            return new Arquivo(ARQUIVO_ORIGEM).carregarMatrizMST();
        } catch (IOException ex) { Logger.getLogger(ControllerPCV.class.getName()).log(Level.SEVERE, null, ex); }
        return null;
    }    
    
    //Prints
    public void printMatrizPCV ()
    {
        Print.printMatriz(matrizRota);
    }
    
    public void printVetorSCV ()
    {
        Print.printVetor(vetorSCV);
    }
    
    public void printResultadoSCV ()
    {
        Print.printResultado(vetorSCV);
    }
}

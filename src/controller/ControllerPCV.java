
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Rota;
import infra.Arquivo;
import util.FuncoesVetor;
import util.Heuristica;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.10.2018                                                           *
 ******************************************************************************/
public class ControllerPCV 
{
    private final String ARQUIVO_ORIGEM = "..\\CaixeiroViajante\\src\\infra\\instancias\\dij20.txt";
    private final Rota[][] matrizRota;
    private Rota [][] matrizSCV;

    public ControllerPCV() 
    {
        this.matrizRota = carregarMatrizArquivo();
    }
    
    public void controlePCV (Heuristica heuristica)
    {
        matrizSCV = new Rota[matrizRota.length][matrizRota.length];
        FuncoesVetor.copiarMatriz(matrizRota, matrizSCV);
        heuristica.solucionarPCV(matrizRota, matrizSCV);
    }
    
    private Rota[][] carregarMatrizArquivo() 
    {
        try {
            return new Arquivo(ARQUIVO_ORIGEM).carregarMatrizMST();
        } catch (IOException ex) { Logger.getLogger(ControllerPCV.class.getName()).log(Level.SEVERE, null, ex); }
        return null;
    }    
}

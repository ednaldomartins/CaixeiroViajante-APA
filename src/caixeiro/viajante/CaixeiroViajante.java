
package caixeiro.viajante;

import controller.ControllerPCV;
import model.HeuristicaVMP;
import model.VND;
import model.VNS;


/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.10.2018                                                           *
 ******************************************************************************/
public class CaixeiroViajante {

    public static void main(String[] args)
    {
        //intancia da classe controladora
        ControllerPCV control = new ControllerPCV();
        //print da matriz de origem
        control.printMatrizPCV();
        //geracao da solucao para o PCV com base na heuristica usada
        control.controlePCV( new HeuristicaVMP(), new VND() );
        //geracao da solucao para o PCV com base na metaheuristica usada
        //control.controlePCV(new HeuristicaVMP(), new VND(), new VNS() );
        //print da primeira solucao
        control.printResultadoSCV();
        //print da melhor solucao apos refinamento
        control.printMelhorResultado();
    }
    
}

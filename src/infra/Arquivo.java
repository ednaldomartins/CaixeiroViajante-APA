
package infra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.Rota;
import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  data: 23.10.2018                                                           *
 ******************************************************************************/
public class Arquivo 
{
    private final Path loadPath;
    private final Charset utf8 = StandardCharsets.UTF_8;
    
    public Arquivo (String loadPath) 
    {
        this.loadPath = Paths.get(loadPath);
    }
    /***************************************************************************
     * PCV: Problema do Caixeiro Viajante                                      *
     *      Note que o primeiro elemento a ser recuperado da lista eh o        *
     *  numero de cidades da lista.                                            *
     * i: primeiro vertice                                                     *
     * j: segundo vertice                                                      *
     * k: distancia da rota que estah ligando as cidades 'i' e 'j'             *
     * @return grafo                                                           *
     * @throws IOException                                                     *
     **************************************************************************/
    public Rota [][] carregarMatrizRotaPCV() throws IOException 
    {
        Rota [][] matriz = null;
        try (BufferedReader reader = Files.newBufferedReader(loadPath, utf8))
        {
            String line = null;
            int tamanhoMatriz = Integer.parseInt( reader.readLine() );
            matriz = new Rota[tamanhoMatriz][tamanhoMatriz];
            FuncoesVetor.iniciarMatriz(matriz);
            for(int i = 0, id = 0; (line = reader.readLine()) != null; i++) 
            {   
                String[] parametro = line.split(" |\t");
                for(int j = 0, k = 0; k < parametro.length; k++, j++, id++)
                {
                    matriz[i][j] =  new Rota( id, i, j, Long.parseLong(parametro[k]), false);
                    //matriz[j][i] =  new Rota( id, j, i, Long.parseLong(parametro[k]), false);
                }
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");}
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        catch(IOException ex) {System.err.println("Erro de leitura");}
            
        return matriz;
    }
    
    
    public long [][] carregarMatrizLongPCV() throws IOException 
    {
        long [][] matriz = null;
        try (BufferedReader reader = Files.newBufferedReader(loadPath, utf8))
        {
            String line = null;
            int tamanhoMatriz = Integer.parseInt( reader.readLine() );
            matriz = new long[tamanhoMatriz][tamanhoMatriz];
            FuncoesVetor.iniciarMatriz(matriz);
            for(int i = 0, id = 0; (line = reader.readLine()) != null; i++) 
            {   
                String[] parametro = line.split(" |\t");
                for(int j = 0, k = 0; k < parametro.length; k++, j++, id++)
                    matriz[i][j] =  Long.parseLong(parametro[k]);
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");}
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        catch(IOException ex) {System.err.println("Erro de leitura");}
            
        return matriz;
    }
    
}

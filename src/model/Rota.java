
package model;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.10.2018                                                           *
 ******************************************************************************/
public class Rota 
{
    private int id;
    private int cidade1;
    private int cidade2;
    private long distancia;
    private boolean selecionada;

    public Rota(int id, int cidade1, int cidade2, long distancia, boolean selecionada) 
    {
        this(distancia, selecionada);
        this.id = id;
        this.cidade1 = cidade1;
        this.cidade2 = cidade2;
    }

    public Rota(long distancia, boolean selecionada) {
        this.distancia = distancia;
        this.selecionada = selecionada;
    }

    //GETs
    public int getId() {
        return id;
    }

    public int getCidade1() {
        return cidade1;
    }

    public int getCidade2() {
        return cidade2;
    }

    public long getDistancia() {
        return distancia;
    }

    public boolean isSelecionada() {
        return selecionada;
    }

    
    //SETs
    public void setId(int id) {
        this.id = id;
    }

    public void setCidade1(int cidade1) {
        this.cidade1 = cidade1;
    }

    public void setCidade2(int cidade2) {
        this.cidade2 = cidade2;
    }

    public void setDistancia(long distancia) {
        this.distancia = distancia;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }
    
}
